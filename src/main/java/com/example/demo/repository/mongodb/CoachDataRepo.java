package com.example.demo.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CoachNew;

@Repository
public interface CoachDataRepo extends MongoRepository<CoachNew, Long> {

}
