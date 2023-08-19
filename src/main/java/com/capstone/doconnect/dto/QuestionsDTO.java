package com.capstone.doconnect.dto;

import java.util.List;

import com.capstone.doconnect.entity.Answers;

import lombok.Data;


@Data
public class QuestionsDTO {

	private int qid;
	private String que;
	private String topic;
	private Boolean isApproved;
	
	private List<Answers> answers;

}
