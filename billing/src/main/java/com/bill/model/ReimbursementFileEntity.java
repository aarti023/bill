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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reimbursement_file")
@Entity(name = "reimbursement_file")
public class ReimbursementFileEntity {
	
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
	
	@Column(name = "reimburse_Id", columnDefinition = "varchar(256)")
	private String reimburseId;

	@Lob
	private byte[] data;

	public ReimbursementFileEntity(String employeeCode, String fileName, String fileType, String reimburseId,
			byte[] data) {
		super();
		this.employeeCode = employeeCode;
		this.fileName = fileName;
		this.fileType = fileType;
		this.reimburseId = reimburseId;
		this.data = data;
	}

	
}
