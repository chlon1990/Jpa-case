package com.example.demo.entity;


import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Document(collection = "emp")
public class Emp {
	@Id
	@AutoIncKey
	private Long id;
	
	private String name;
	
	private String sex;
	
	private Integer age;
	
	@Field("hire_date")
	private String hireDate;
	
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "America/New_York")
	private Date createTime; 
	
	private String post;
	
	private Double salary;
	
	private Map<String,Object> empDetail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Map<String, Object> getEmpDetail() {
		return empDetail;
	}

	public void setEmpDetail(Map<String, Object> empDetail) {
		this.empDetail = empDetail;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", hireDate=" + hireDate
				+ ", createTime=" + createTime + ", post=" + post + ", salary=" + salary + ", empDetail=" + empDetail
				+ "]";
	}
	
	
	
	
}
