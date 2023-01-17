package com.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "profile")
@Entity(name = "profile")
public class ProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "employee_code", columnDefinition = "varchar(256)")
	private String employeeCode;

	@Column(name = "file_name", columnDefinition = "varchar(256)")
	private String fileName;

	@Column(name = "file_type", columnDefinition = "varchar(256)")
	private String fileType;

	@Lob
	private byte[] data;

	public ProfileEntity( String employeeCode, String fileName, String fileType, byte[] data) {
		super();
		this.employeeCode = employeeCode;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	
	
	

}
