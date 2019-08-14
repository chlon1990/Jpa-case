package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;

public class BasicTest {
	public static void main(String[] args) {
		objectTest1();
	}
	
	
	public static void objectTest() {
		Emp emp = new Emp();
		emp.setAge(18);
		emp.setName("qin");
		
		Map<String, Object> empDetail = emp.getEmpDetail();
		
		if(empDetail == null || empDetail.isEmpty()) {
			empDetail = new HashMap();
			empDetail.put("key", "have a fun");
			emp.setEmpDetail(empDetail);
		}
		
		System.out.println(emp);
	}
	
	public static void objectTest1() {
		Emp emp = new Emp();
		emp.setAge(18);
		emp.setName("qin");

		Map<String, Object> empDetail = new HashMap<String, Object>();
		empDetail.put("key", "have a fun");
		emp.setEmpDetail(empDetail);
		mapTest(empDetail);
		System.out.println(emp);
	}
	
	public static void mapTest(Map<String, Object> map,String ... keys) {
		
		ArrayList<String> list = Lists.newArrayList(keys);
		
		map.put("key1", "good night");
		map.entrySet().removeIf(en -> en.getKey().equals("key"));
		
		Map<String, Object> mapTarget = new HashMap<>();
		mapTarget.put("key", "onece agen");
		mapTarget.put("no", "no insert");
		mapTarget.put("no1", "no1 insert");
		mapTarget.put("no2", "no2 insert");
		mapTarget.put("null",null);
		mapTarget.entrySet().removeIf(entrt -> entrt.getValue() == null || list.contains(entrt.getKey()));
		map.putAll(mapTarget);
		
	}
	
	public static void listTest(List<String> list) {
		list.removeIf(null);
	}
}
