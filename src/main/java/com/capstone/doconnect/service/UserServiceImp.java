package com.capstone.doconnect.service;

import java.util.HashMap;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.doconnect.entity.Answers;
import com.capstone.doconnect.entity.Questions;
import com.capstone.doconnect.entity.User;
import com.capstone.doconnect.repository.AnswerRepository;
import com.capstone.doconnect.repository.QuestionRepository;
import com.capstone.doconnect.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {
	public static HashMap<String, User> map = new HashMap<>();
	
	int counter=0;
	@Autowired
	UserRepository urepo;
	@Autowired
	QuestionRepository qrepo;
	@Autowired
	AnswerRepository arepo;

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		
		if(urepo.findByUemail(user.getUemail())!=null) {
			User pass = urepo.findByUemail(user.getUemail());
			if(pass.getUpassword().equals(user.getUpassword())){
				return true;
			}
			
			return false;
		}
		return false;
	}
		

	@Override
	public boolean register(User user) {
		if(urepo.findByUemail(user.getUemail())==null) {
			urepo.save(user);
			return true;
		}
		
		return false;
}


	@Override
	public Questions askQuestion(Questions que) {
		// TODO Auto-generated method stub
		Questions q1 = new Questions();
		q1.setQue(que.getQue());
		q1.setTopic(que.getTopic());
		
		return qrepo.save(q1);

	}

	@Override
	public Answers addAnswers(Answers answers, int qid) {
		// TODO Auto-generated method stub
		Answers a1 = new Answers();
		a1.setAns(answers.getAns());
		Questions que1 = new Questions();
		que1.setQid(qid);
		a1.setQuestions(que1);
		return arepo.save(a1);
	}

	@Override
	public List<Questions> findByQueLike(String que) {
		// TODO Auto-generated method stub
		return qrepo.findByQueLike(que);
	}

	@Override
	public Answers getAnsById(int aid) {
		// TODO Auto-generated method stub
		return arepo.findByAnsid(aid);
	}
	@Override
	public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		return qrepo.findAll();
	}

	@Override
	public List<Answers> getAllAnswers() {
		// TODO Auto-generated method stub
		return arepo.findAll();
	}


	@Override
	public List<Questions> getByTopic(String topic) {
		// TODO Auto-generated method stub
		return qrepo.findAllByTopic(topic);
	}
	
	
}