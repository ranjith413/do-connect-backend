package com.capstone.doconnect.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.doconnect.entity.Answers;
import com.capstone.doconnect.entity.Questions;
import com.capstone.doconnect.entity.User;
//import com.capstone.doconnect.service.IEmailService;
import com.capstone.doconnect.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	IUserService service;
	
	/*
	 * @Autowired IEmailService emailService;
	 */

	@PostMapping("/login")
	public boolean loginUser(@RequestBody User user) {
		System.out.println("user = " + user);
		service.login(user);
		if(service.login(user)==true) {
			return true;
		}
		else {
			return false;
		}
	}

	@PostMapping("/register")
	public boolean regitserUser(@RequestBody User user) {
		System.out.println("user = " + user);
		return service.register(user);
	}

	@PostMapping("/askque")
	public Questions askQuestion(@RequestBody Questions que) {
		
		//emailService.sendMailWhenQuestion(que.getQue());
		return service.askQuestion(que);
	}

	@PostMapping("/addAnswer/{qid}")
	public Answers addAnswers(@RequestBody Answers answers, @PathVariable int qid) {
		
		//emailService.sendMailWhenAnswered(answers.getAns());
		
		return service.addAnswers(answers,qid);

	}

	@GetMapping("/SearchByQue/{que}")
	public ResponseEntity<List<Questions>> getByQuestion(@PathVariable String que) {
		ResponseEntity<List<Questions>> q = new ResponseEntity<List<Questions>>(service.findByQueLike("%" + que + "%"),
				HttpStatus.OK);

		return q;
	}

	@GetMapping("/GetAns/aid")
	public Answers getAnsById(@RequestParam int aid) {
		return service.getAnsById(aid);
	}
	@GetMapping("/getallque")
	public List<Questions> getAllQue() {
		return service.getAllQuestions();
	}

	@GetMapping("/getallans")
	public List<Answers> getAllAns() {
		return service.getAllAnswers();
	}
	@GetMapping("/getbytopic/{topic}")
	public List<Questions> getByTopic(@PathVariable String topic){
		return service.getByTopic(topic);
	}
	
}
