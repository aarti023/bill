package com.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bill.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relation")
@Entity(name = "relation")
public class RelationsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "employee_code", columnDefinition = "varchar(256)")
	private String employeeCode;
	
	@Column(name = "employee_name", columnDefinition = "varchar(256)")
	private String employeeName;
	
	@Column(name = "password", columnDefinition = "varchar(256)")
	private String password;

	@Column(name = "email", columnDefinition = "varchar(256)")
	private String email;
	
	private UserType userType;
}
