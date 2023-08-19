package com.capstone.doconnect.service;

import java.util.List;

import com.capstone.doconnect.entity.Answers;
import com.capstone.doconnect.entity.Questions;
import com.capstone.doconnect.entity.User;

public interface IUserService {

	boolean login(User user);

	boolean register(User user);

	public Questions askQuestion(Questions que);

	public List<Questions> findByQueLike(String que);

	public Answers getAnsById(int aid);

	List<Answers> getAllAnswers();

	List<Questions> getAllQuestions();

	List<Questions> getByTopic(String topic);

	Answers addAnswers(Answers answers,int qid);

}
