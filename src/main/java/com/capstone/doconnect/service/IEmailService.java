package com.capstone.doconnect.service;

public interface IEmailService {
	
	public String[] getAdminEmails();
	
	public String sendMailWhenQuestion(String msg);
	
	public String sendMailWhenAnswered(String msg);

}
