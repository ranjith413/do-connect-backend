package com.capstone.doconnect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.capstone.doconnect.entity.Admin;
import com.capstone.doconnect.repository.AdminRepository;



@Service
public class EmailServiceImp implements IEmailService {

  @Autowired private JavaMailSender javaMailSender;
	  
	  @Autowired
	  AdminRepository arepo;
	  
	    @Value("${spring.mail.username}") 
	    private  String sender;
	    
	    
	 @Override   
	public String[] getAdminEmails() {
	    List<Admin> admins= arepo.findAll();

        List<String> emails = new ArrayList<String>();
        
        for (Admin admin : admins)
        {
        	emails.add(admin.getAemail());
        	
        }
        
        String AdminEmails[] = emails.toArray(new String[emails.size()]);
        return AdminEmails;
	}
	 
	 	@Override
	    public String sendMailWhenQuestion(String msg)
	    {
	 

	        try {
	 

	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	            
	            String [] toEmails= getAdminEmails();
	            
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(toEmails);
	            mailMessage.setText(msg);
	            mailMessage.setSubject("A User has posted a question");
	 
	            
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 

	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	    }
	    
	    @Override
	    public String sendMailWhenAnswered(String msg)
	    {
	 

	        try {
	 

	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	            
	            String [] toEmails= getAdminEmails();
	            
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(toEmails);
	            mailMessage.setText(msg);
	            mailMessage.setSubject("A user has posted an answer");
	 
	            
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 

	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	    }

}
