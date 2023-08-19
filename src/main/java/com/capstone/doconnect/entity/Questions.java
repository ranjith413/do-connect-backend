package com.capstone.doconnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qid;
	
	@Column(length = 1000)
	private String que;
	
	private String topic;
	
	
	@Column(name = "is_approved" ,columnDefinition = "boolean default 0")
	private Boolean isApproved;

}
