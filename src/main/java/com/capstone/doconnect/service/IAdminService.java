package com.capstone.doconnect.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capstone.doconnect.entity.Admin;
import com.capstone.doconnect.entity.Answers;
import com.capstone.doconnect.entity.Questions;
import com.capstone.doconnect.entity.User;

public interface IAdminService {

	boolean login(Admin admin);

	boolean register(Admin admin);

	public List<Admin> getAllAdmin();

	public Admin getAdminById(int aid);

	public List<User> getAllUser();

	public User getUserById(int uid);

	public List<Questions> getAllQuestions();

	public List<Answers> getAllAnswers();

	public ResponseEntity<String> deleteAnsById(int aid);

	public ResponseEntity<String> deleteQueById(int qid);

	boolean approveQue(Questions qid);
	
	boolean approveAns(Answers aid);

}
