package com.example.demo;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.mongodb.DBObject;

@Component
public class MongoSaveEventListener extends AbstractMongoEventListener<Object> {
	@Autowired
	private MongoTemplate mongo;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		final Object source = event.getSource();
		if (source != null) {
			ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
					ReflectionUtils.makeAccessible(field);
					if (field.isAnnotationPresent(AutoIncKey.class)) {
						Long id = (Long)field.get(source);
						if(id == null || id == 0L ) {
							field.set(source, getNextId(source.getClass().getSimpleName()));
						}
					}
				}
			});
		}
		
	}


	@Override
	public void onAfterLoad(AfterLoadEvent<Object> event) {
		
	}





	private Long getNextId(String collName) {
		Query query = new Query(Criteria.where("collName").is(collName));
		Update update = new Update();
		update.inc("seqId", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.upsert(true);
		options.returnNew(true);
		SeqInfo seq = mongo.findAndModify(query, update, options, SeqInfo.class);
		return seq.getSeqId();
	}
}
