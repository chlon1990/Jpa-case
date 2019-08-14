package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	@Query(value = "select a.* from Account a where a.hr_Id = ?1",nativeQuery = true)
	Account findByHrId(String hrId);
	
	List<Account> findByHrIdIn(List<String> hrIds);

}
