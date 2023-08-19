package com.capstone.doconnect.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.doconnect.entity.Admin;
import com.capstone.doconnect.entity.Answers;
import com.capstone.doconnect.entity.Questions;
import com.capstone.doconnect.entity.User;
import com.capstone.doconnect.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {

	@Autowired
	IAdminService service;

	@PostMapping("/login")
	public boolean loginAdmin(@RequestBody Admin admin) {
		service.login(admin);
		if(service.login(admin)==true) {
			return true;
		}
		else {
			return false;
		}
	}

	@PostMapping("/register")
	public boolean regitserAdmin(@RequestBody Admin admin) {
		System.out.println("admin = " + admin);
		return service.register(admin);
	}

	@GetMapping("/getAllAdmim")
	public List<Admin> getAllAdmin() {

		return service.getAllAdmin();
	}

	@GetMapping("/getAdminById/{aid}")
	public Admin getAdminById(@PathVariable int aid) {
		return service.getAdminById(aid);
	}

	@GetMapping("/getAllUser")
	public ArrayList<User> getAll() {

		return (ArrayList<User>) service.getAllUser();
	}

	@GetMapping("/getUserById/{uid}")
	public User getById(@PathVariable int uid) {
		return service.getUserById(uid);
	}

	@DeleteMapping("/Deleteans/{aid}")
	public ResponseEntity<String> deleteAnsById(@PathVariable int aid) {
		return service.deleteAnsById(aid);
	}

	@DeleteMapping("/Deleteque/{qid}")
	public ResponseEntity<String> deleteQueById(@PathVariable int qid) {
		return service.deleteQueById(qid);
	}

	@GetMapping("/getallque")
	public List<Questions> getAllQue() {
		return service.getAllQuestions();
	}

	@GetMapping("/getallans")
	public List<Answers> getAllAns() {
		return service.getAllAnswers();
	}
	@PutMapping("/approveque/qid")
	public boolean approveQue(@RequestBody Questions qid) {
		
		return service.approveQue(qid);
	}
	@PutMapping("/approveans/aid")
	public boolean approveAns(@RequestBody Answers aid) {
		
		return service.approveAns(aid);
	}
}
