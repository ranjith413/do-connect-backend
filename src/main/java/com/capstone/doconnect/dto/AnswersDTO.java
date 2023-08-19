package com.capstone.doconnect.dto;

import com.capstone.doconnect.entity.Questions;

import lombok.Data;

@Data
public class AnswersDTO {

	private int ansid;
	private String ans;
	private int uid;

    private Questions questions;
}

