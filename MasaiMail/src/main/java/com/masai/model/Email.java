package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Email {

	@Id
	private String email;
	private String sender_email_id;
//	@Embedded
//	private List<String> list_of_receiver_email_id = new ArrayList<>();
	private String msg;
	private LocalDate localDate = LocalDate.now();
	private Boolean Star;
	
//	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "email")
//	private List<User> list_user = new ArrayList<>();
	
	
}
