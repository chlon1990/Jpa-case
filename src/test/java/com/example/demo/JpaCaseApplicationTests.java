package com.example.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.example.demo.repository.AccountRepo;
import com.mongodb.DBObject;
/**
 * 
 * 
 * ConditionalOperators  IFNULL 等条件判断
 * 
 * 
 * ConvertOperators  toDouble 等 转换操作
 * 
 * 	 坑：   1，在使用 Criteria 时，一个字段只能使用一次 
 * 	 		eg: Criteria.where("name").ne("").ne(null)  为错误写法
 * 				正确写法应为  Criteria.where("name").nin("",null);
 * 
 * @author long.chen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaCaseApplicationTests {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

//	@Test
//	public void contextLoads() {
//		long count = accountRepo.count();
//		System.out.println(count);
//	}
//	

	/**
	 * 
	 * Criteria.and() 虽然也返回了新 new 对象，但是将条件添加到老对象中的，所以可以不用连续 点 （.） 来调用。
	 * 
	 */

//	@Test
//	public void FieldTest() {
//		Query query = new Query();
//		
//		Criteria criteria = Criteria.where("sex").is("male");
//		criteria.and("post").is("公务员");
//		Criteria criteria2 = criteria.and("name").is("柴进");
//		
//		System.out.println("是否为一个对象：" + (criteria  == criteria2) );
//		//query.addCriteria(criteria);
//		query.addCriteria(criteria2);
//		Field fields = query.fields();
//		fields.exclude("hireDate");
//		fields.exclude("sex");
//		List<Emp> find = mongoTemplate.find(query, Emp.class);
//		find.forEach(emp -> System.out.println("FieldTest ====>>>" + emp.toString()));
//		
//	}

//	@Test
//	public void aggregationTest() {
//		List<AggregationOperation> operations = Lists.newArrayList();
//		
//		Fields fields = Aggregation.fields("name","sex","age");
//		ProjectionOperation project = Aggregation.project(fields);
//		
//		Criteria criteria = Criteria.where("sex").is("male") ;
//		MatchOperation match = Aggregation.match(criteria );
//		
//		
//		//CountOperation countOperation = Aggregation.count().as("num");
//		
//		operations.add(match);
//		//operations.add(countOperation);
//		//operations.add(project);
//		Aggregation aggregation = Aggregation.newAggregation(operations);
//		 List<Emp> mappedResults = mongoTemplate.aggregate(aggregation, Emp.class , Emp.class).getMappedResults();
//		 mappedResults.forEach(System.out::println);
//		
//	}

//	@Test
//	public void aggregationTest1() {
//		Criteria criteria2 = Criteria.where("post").is("文人");
//		MatchOperation match = Aggregation.match(criteria2);
//		
//		GroupOperation group = Aggregation.group("post").count().as("num").sum("salary").as("sum_salary");
//		Criteria criteria = Criteria.where("num").is(5);
//		MatchOperation matchOperation = Aggregation.match(criteria);
//		
////		Fields fields = Aggregation.fields("name","sex","post","salary");
////		ProjectionOperation project = Aggregation.project(fields);
//		
//		Aggregation aggregation = Aggregation.newAggregation(match,group,matchOperation);
//		List<Map> mappedResults = mongoTemplate.aggregate(aggregation, Emp.class , Map.class).getMappedResults();
//		System.out.println(mappedResults.size());
//		mappedResults.forEach(System.out::println);
//		
//	}

	/**
	 * 注意事项：GroupOperation 必须连点
	 * Aggregation.group("post").count().as("num").sum("salary").as("sum_salary");
	 * 
	 * 由于每次. 函数之后都是返回的一个新 new 的对象。
	 */

//	@Test
//	public void aggregationTest2() {
//		
//		GroupOperation group = Aggregation.group("post","sex").avg("salary").as("avg");
//		
//		
//		
//		Aggregation aggregation = Aggregation.newAggregation(group,Aggregation.project("post","sex","avg").and("avg")
//				.applyCondition(ConditionalOperators.IfNull.ifNull("avg").then(0)));
//		
//		List<Map> mappedResults = mongoTemplate.aggregate(aggregation, Emp.class , Map.class).getMappedResults();
//		System.out.println(mappedResults.size());
//		mappedResults.forEach(System.out::println);
//	}
	
	
	// null  值的判断
//	@Test
//	public void aggregationTest3() {
//		
//		Criteria criteria = Criteria.where("salary").ne(null);
//		
//		Query query = new Query(criteria);
//		
//		List<Emp> find = this.mongoTemplate.find(query, Emp.class);
//		
//		find.forEach(System.out::println);
//		
//	}
	
//	@Test
//	public void orOperator() {
//		Criteria criteria = Criteria.where("post").is("公务员");
//		Criteria criteria2 = Criteria.where("post").is("文人");
//		
//		Criteria criteria3 = new Criteria();
//		criteria3.orOperator(criteria,criteria2);
//		
//		Query query = new Query(criteria3);
//		
//		List<Emp> list = this.mongoTemplate.find(query, Emp.class);
//		
//		list.forEach(System.out::println);
//		
//	}
	
//	@Test
//	public void orOperator2() {
//		
//		//select * from emp where age = 18 and ((post = '文人' and name = '朱贵')  or (post = '公务员' and name = '卢俊义' ) )  
//		
//		Criteria criteria = Criteria.where("age").is(18);
//		//Criteria criteria = new Criteria();
//		
//		// criteria = criteria.orOperator(Criteria.where("post").is("文人").and("name").is("朱贵"),Criteria.where("post").is("公务员").and("name").is("卢俊义"));
//		
//		//criteria.andOperator(Criteria.where("age").is(18),criteria);
//		
//		//Criteria.where("post").is("文人").and("name").is("朱贵");
//		
//		//Criteria.where("post").is("公务员").and("name").is("卢俊义");
//		
//		criteria.andOperator(criteria,criteria.orOperator(Criteria.where("post").is("文人").and("name").is("朱贵"),Criteria.where("post").is("公务员").and("name").is("卢俊义")));
//		
//		Query query = new Query(criteria);
//		
//		List<Emp> list = this.mongoTemplate.find(query , Emp.class);
//		
//		list.forEach(System.out::println);
//		
//	}
//	
//	@Test
//	public void inlineSum() {
//		Criteria criteria = Criteria.where("post").is("学生");
//		Aggregation aggregation = Aggregation.newAggregation(
//				Aggregation.match(criteria ),
//				Aggregation.group()
//				.sum("empDetail.points1").as("points1")
//				.sum("empDetail.points2").as("points2"));
//		
//		List<Map> results = this.mongoTemplate.aggregate(aggregation, "emp",Map.class).getMappedResults();
//		
//		results.forEach(System.out::println);
//	}
	
	@Test
	public void inlineConvertout() {
//		Criteria criteria = Criteria.where("post").is("学生").and("empDetail").ne(null);
//		Aggregation aggregation = Aggregation.newAggregation(
//				Aggregation.match(criteria ));
//		
//		List<Map> results = this.mongoTemplate.aggregate(aggregation, "emp",Map.class).getMappedResults();
//		results.forEach(map -> {
//			
//			map.putAll((Map) map.get("empDetail"));map.remove("empDetail");
//			
//		});
//		results.forEach(System.out::println);
		
	}
	
//	public static void main(String[] args) {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("hahaMMsa", 1);
//		map.put("hahaMssa", 2);
//		map.put("hahammsa", 3);
//		
//		Map<String,Object> newMap = new HashMap<String,Object>();
//		
//		Set<String> keySet = map.keySet();
//		
//		
//		keySet.forEach(str -> {
//			
//			String strNew = humpToLine2(str);
//			
//			newMap.put(strNew, map.get(str));
//			
//		});
//		
//		System.out.println(newMap);
//	}
//	
//	
//	private static Pattern humpPattern = Pattern.compile("[A-Z]");
//	
//	 public static String humpToLine2(String str) {
//	      Matcher matcher = humpPattern.matcher(str);
//	     StringBuffer sb = new StringBuffer();
//	     while (matcher.find()) {
//	          matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
//	      }
//	       matcher.appendTail(sb);
//	     return sb.toString();
//	 }
	
//	
//	@Test
//	public void unionOperator() {
//		Criteria criteria = Criteria.where("post").is("公务员");
//		
//		Criteria criteria2 = Criteria.where("post").is("文人");
//		
//		Aggregation.newAggregation(Aggregation.match(criteria2),Aggregation.project(fields));
//		
//	
//		
//		list.forEach(System.out::println);
//		
//	}

//	@Test
//	public void UpdateTest() {
//		
//		Query query = new Query();
//		Criteria criteria = Criteria.where("sex").is("male").and("post").is("公务员");
//		query.addCriteria(criteria);
//		
////		Emp findOne = mongoTemplate.findOne(query, Emp.class);
////		findOne.setName("李东");
////		
////		mongoTemplate.insert(findOne);
//		
//		Update update = new Update();
//		update.set("name", "管健");
//		update.set("post", "学生");
//		WriteResult updateMulti = mongoTemplate.updateFirst(query, update, Emp.class);
//		
//	}

//	@Test
//	public void concurrentSaveTest() {
//		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(100);
//		
//		for(int i = 0;i<100000;i++) {
//			Emp emp = new Emp();
//			emp.setAge(19);
//			emp.setHireDate("2019-06-27");
//			emp.setName("吴青峰");
//			emp.setPost("学生");
//			emp.setSalary(2000.0);
//			emp.setSex("male");
//			executor.execute(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						mongoTemplate.save(emp);
//						
//					} catch (Exception e) {
//						System.out.println("冲突：！！！！" + emp.getId());
//					}
//					
//				}
//			});
//			
//		}
//		while(true) {
//			
//		}
//	}

//	@Test
//	public void saveTest() {
//		Emp emp = new Emp();
//		emp.setAge(19);
//		emp.setHireDate("2106-07-09");
//		emp.setName("wu峰");
//		emp.setPost("学生");
//		emp.setSalary(2000.0);
//		emp.setSex("male");
//		
//		Calendar cal = Calendar.getInstance();
//		
//		emp.setCreateTime(cal.getTime());
//		
//		Map<String,Object> empDetail = new HashMap<>();
//		empDetail.put("firstname", 100);
//		empDetail.put("lastName", 100);
//		
//		emp.setEmpDetail(empDetail);
//		mongoTemplate.save(emp);
//		
//	}
	
	@Test
	public void findDateTest() {
		Criteria criteria = Criteria.where("name").is("wu峰");
		Fields fields = Fields.from(Fields.field("cid", "_id"),
				Fields.field("cname", "name")
				); 
		Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria),Aggregation.project(fields));
		AggregationResults<Map> aggregate = this.mongoTemplate.aggregate(aggregation, "emp",Map.class);
		if(aggregate != null ) {
			List<Map> results = aggregate.getMappedResults();
			results.forEach(System.out::println);
		}else {
			System.out.println("没有查询到数据。。");
		}
		
		
	}
	
	
	// 注意事项：：：：：：：this.mongoTemplate.aggregate(aggregation, "emp",Map.class).getMappedResults();
	
	// 此方法可以传实体，可以传 collection 名称， 传实体的时候 ，不能获取到 实体中 Map 集合的子集
//	@Test
//	public void getInlinePropertyTest() {
//		Criteria criteria = Criteria.where("name").is("吴青峰").and("empDetail.leader").is("赵雷");
//		Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria ),
//				Aggregation.project("name","empDetail.dept")
//				);
//		
//		// error  List<Map> results = this.mongoTemplate.aggregate(aggregation, Emp.class ,Map.class).getMappedResults();
//		//   会报错  找不到 empDetail.dept 路径， 因为 empDetail 在实体中是一个 Map ，此种方式  empDetail 必须是一个 bean对象。。。
//		List<Map> results = this.mongoTemplate.aggregate(aggregation, "emp",Map.class).getMappedResults();
//		
//		results.forEach(System.out::println);
//	}

}
