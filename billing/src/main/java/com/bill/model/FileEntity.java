package com.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@Table(name = "file")
@Entity(name = "file")
public class FileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "invoice_number", columnDefinition = "varchar(256)")
	private String invoiceNumber;

	@Column(name = "file_name", columnDefinition = "varchar(256)")
	private String fileName;

	@Column(name = "file_type", columnDefinition = "varchar(256)")
	private String fileType;
	
	@Column(name = "invoice_id", columnDefinition = "varchar(256)")
	private String invoiceId;

	@Lob
	private byte[] data;

	public FileEntity() {

	}

	public FileEntity(String fileName, String fileType, byte[] data, String invoice) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.invoiceId = invoice;
}
	


	
}