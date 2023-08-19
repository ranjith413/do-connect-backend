package com.capstone.doconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String aname;
	private String apassword;
	private String aemail;
}
