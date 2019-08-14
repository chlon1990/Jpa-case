package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.entity.Emp;
import com.example.demo.repository.AccountRepo;

@RestController
public class AccountController {
	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	@GetMapping("/findByHrId")
	public Object findByHrId(String hrId) {
		Account account = accountRepo.findByHrId(hrId);
		return account;
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

}
