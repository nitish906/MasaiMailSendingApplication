package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.core.type.filter.RegexPatternTypeFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User {
	
	@Id
	@Email
	private String email_id;
	

	@NotNull
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[A-Za-z]{1,120}",message = "first name must not contain special character")
	private String first_name;
	
	@Pattern(regexp = "[A-Za-z]{1,120}",message = "last name must not contain special character")
	private String last_name;
	
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	@Size(min = 10, max = 10)
	private String mobilenumber;
	
	
	@NotNull(message="Password cannot be null!")
	@NotBlank(message= "Password cannot be blank!")
	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include alphanumerics and special characters")	
	private String password;
	
	@Past
	private LocalDate localDate;
	
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private List<com.masai.model.Email> list_of_Email = new ArrayList<>();
}
