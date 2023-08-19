package com.capstone.doconnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Answers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ansid;
	@Column(length = 1000)
	private String ans;
	
	@Column(name = "isApproved" ,columnDefinition = "boolean default 0")
	private Boolean isApproved;

	@ManyToOne//(optional = false)
    @JoinColumn(name = "qid")
   // @OnDelete(action = OnDeleteAction.CASCADE)
    private Questions questions;

	

}
