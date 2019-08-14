package com.example.demo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "sequence")
@Data
public class SeqInfo {
	@Id
	private String id;
 
	@Field
	private String collName;
 
	@Field
	private Long seqId;
 

}
