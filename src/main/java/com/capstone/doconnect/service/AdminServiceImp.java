package com.capstone.doconnect.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capstone.doconnect.entity.Admin;
import com.capstone.doconnect.entity.Answers;
import com.capstone.doconnect.entity.Questions;
import com.capstone.doconnect.entity.User;
import com.capstone.doconnect.repository.AdminRepository;
import com.capstone.doconnect.repository.AnswerRepository;
import com.capstone.doconnect.repository.QuestionRepository;
import com.capstone.doconnect.repository.UserRepository;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	AdminRepository arepo;
	@Autowired
	QuestionRepository qrepo;
	@Autowired
	AnswerRepository ansrepo;
	@Autowired
	UserRepository urepo;

	int counter = 0;

	@Override
	public boolean login(Admin admin) {
		if(arepo.findByAemail(admin.getAemail())!=null) {
			Admin pass = arepo.findByAemail(admin.getAemail());
			if(pass.getApassword().equals(admin.getApassword())){
				return true;
			}
			
			return false;
		}
		return false;
	}

	@Override
	public boolean register(Admin admin) {
		if(arepo.findByAemail(admin.getAemail())==null) {
			arepo.save(admin);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return arepo.findAll();

	}

	@Override
	public Admin getAdminById(int aid) {
		// TODO Auto-generated method stub
		return arepo.findById(aid).orElse(new Admin());
	}

	@Override
	public List<User> getAllUser() {
		return urepo.findAll();

	}

	@Override
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		return urepo.findById(uid).orElse(new User());
	}

	@Override
	public ResponseEntity<String> deleteAnsById(int aid) {
		// TODO Auto-generated method stub
		ansrepo.deleteById(aid);

		return new ResponseEntity<String>("Record Deleted Successfully", HttpStatus.ACCEPTED);
	}

	@Override
	@Transactional
	public ResponseEntity<String> deleteQueById(int qid) {
		
		ansrepo.deleteAllByQuestionsQidLike(qid);
		qrepo.deleteById(qid);

		return new ResponseEntity<String>("Record Deleted Successfully", HttpStatus.ACCEPTED);
	}

	@Override
	public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		return qrepo.findAll();
	}

	@Override
	public List<Answers> getAllAnswers() {
		// TODO Auto-generated method stub
		return ansrepo.findAll();
	}

	@Override
	public boolean approveQue(Questions que) {
		// TODO Auto-generated method stub
		Questions app = qrepo.findByQid(que.getQid());
		if(app.getIsApproved()==null || !app.getIsApproved()){
			app.setIsApproved(true);
			qrepo.save(app);
			return true;
		}
		else {
		app.setIsApproved(false);
		qrepo.save(app);
		return false;
		}
		
	}
	
	@Override
	public boolean approveAns(Answers ans) {
		// TODO Auto-generated method stub
		Answers app = ansrepo.findByAnsid(ans.getAnsid());
		if(app.getIsApproved()==null || !app.getIsApproved()){
			app.setIsApproved(true);
			ansrepo.save(app);
			return true;
		}
		else {
		app.setIsApproved(false);
		ansrepo.save(app);
		return false;
		}
		
	}

}
