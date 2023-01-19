package com.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Column(name = "reporting_manager", columnDefinition = "varchar(256)")
	private String reportingManager;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", columnDefinition = "varchar(50)")
	private UserType userType;

	@Column(name = "submission_date", columnDefinition = "varchar(256)")
	public String submissionDate;
	
	@Column(name = "reporting_manager_id", columnDefinition = "varchar(256)")
	private String reportingManagerId;
	
	@Column(name = "high_reporting_manager_id", columnDefinition = "varchar(256)")
	private String highReportingManagerId;

}
