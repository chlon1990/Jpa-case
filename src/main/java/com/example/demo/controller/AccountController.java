package com.example.demo.controller;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.entity.Emp;
import com.example.demo.entity.Student;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.StudentRepo;
import com.google.common.collect.Lists;

@RestController
public class AccountController {
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private MongoTemplate mongoTemplate;
	
   @PersistenceContext
    protected EntityManager entityManager;

	@GetMapping("/findByHrId")
	public Object findByHrId(String hrId) {
		Account account = accountRepo.findByHrId(hrId);
		return account;
	}
	
	@PostMapping("/saveStu")
	public Object saveStu(@RequestBody Student student) {
		Student save = studentRepo.save(student);
		return save;
	}

	@GetMapping("/findAccount")
	public Object findAccount() {
		List<String> hrIds = new ArrayList<>();
		List<Account> findByHrIdIn = accountRepo.findByHrIdIn(hrIds);
		return findByHrIdIn;
	}

	@PostMapping("/saveEmp")
	public void save(@RequestBody Emp emp) {

		Map<String, Object> empDetail = emp.getEmpDetail();

		Collection<Object> values = empDetail.values();
		values.forEach(value -> {
			if (value instanceof Map) {
				System.out.println("我是  MAP");
			}

			if (value instanceof List) {
				System.out.println("我是  List");
			}
		});

		mongoTemplate.save(emp);
	}
	
	
	
	
	/**
	 * 	获取 实体类与表字段的映射关系
	 * 
	 */
	
	@RequestMapping(value = "/printFormTableData", method = RequestMethod.GET)
    @ResponseBody
    public void printFormTableData() {

        List needFormTableMetaData = Lists.newArrayList("LeadershipHuddleForm", "AgentHuddleForm","HLPCCoach","RFPCCoach","OFPCCoach","MGSLCoach","MGSCCoach",
                                                        "PFSPCoach","StrategicAlignmentMeeting","THPCCoach","SkillTransferCoach","SettingExpectationsCoach",
                                                        "DMFPCoach","AccountabilityConversationCoach","UFFCoach","MGSACoach","UVDFCoach","DFMCoach","TPCFCoach",
                                                        "UVDF2Coach","VDFUCoach","AGSFCoach","CLFCoach","JDPPQAFCoach","TPCNCoach","MGSSCoach","MGSSCoachAgent","MGSSCoachKpi");

        EntityManagerFactory entityManagerFactory = (entityManager).getEntityManagerFactory();
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl) entityManagerFactory.unwrap(SessionFactory.class);
        Map<String, EntityPersister> persisterMap = sessionFactory.getEntityPersisters();
        
        for (Map.Entry<String, EntityPersister> entity : persisterMap.entrySet()) {
            Class targetClass = entity.getValue().getMappedClass();
            SingleTableEntityPersister persister = (SingleTableEntityPersister) entity.getValue();
            Iterable<AttributeDefinition> attributes = persister.getAttributes();
            String entityName = targetClass.getSimpleName();// Entity的名称

            if (needFormTableMetaData.contains(entityName)) {
                String tableName = persister.getTableName();// Entity对应的表的英文名
                StringBuilder sql_object = new StringBuilder("insert into form_info values ( \""+ tableName + "\", \" JSON_OBJECT ( ");

                // 属性
                for (AttributeDefinition attr : attributes) {
                    String propertyName = attr.getName(); // 在entity中的属性名称 
                    if(propertyName.equals("coach")) {
                        continue;
                    }
                    
                    if(propertyName.equals("mgssCoachId")) {
                        continue;
                    }
                    String[] columnName = persister.getPropertyColumnNames(propertyName); // 对应数据库表中的字段名
                    String type = "";
                    PropertyDescriptor targetPd = BeanUtils.getPropertyDescriptor(targetClass, propertyName);
                    if (targetPd != null) {
                        type = targetPd.getPropertyType().getName();
                    }
                   // System.out.println( "属性名：" + propertyName + " => 类型：" + type + " => 数据库字段名：" + columnName[0]);
                    sql_object.append("'").append(propertyName).append("',").append(tableName).append(".").append(columnName[0]).append(",");
                }
                sql_object.deleteCharAt(sql_object.lastIndexOf(","));
                System.out.println(sql_object.append(" )\" ); ").toString());
            }
        }
    }

}
