package com.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "item")
@Entity(name = "item")
public class ItemsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column(name = "invoice_number", columnDefinition = "varchar(256)")
	private String invoiceNumber;
	
	@Column(name = "date_of_Invoice", columnDefinition = "varchar(256)")
	private String dateOfInvoice;
		
	@Column(name = "source", columnDefinition = "varchar(256)")
	private String source;
	
	@Column(name = "item_Code", columnDefinition = "varchar(256)")
	private String itemCode;
	
	@Column(name = "item_name", columnDefinition = "varchar(256)")
	private String itemName;
	
	@Column(name = "hsn_sac_code", columnDefinition = "varchar(256)")
	private String hSNCode;
	
	@Column(name = "category", columnDefinition = "varchar(256)")
	private String category;
	
	@Column(name = "unit", columnDefinition = "varchar(256)")
	private String unit;
	
	@Column(name = "quantity", columnDefinition = "varchar(256)")
	private double quantity;
	
	@Column(name = "price", columnDefinition = "varchar(256)")
	private double price;
	
	@Column(name = "amount", columnDefinition = "varchar(256)")
	private double amount;
	
	@Column(name = "gst_slab", columnDefinition = "varchar(256)")
	private String gSTSlab;
	
	@Column(name = "gst_amount", columnDefinition = "varchar(256)")
	private double gSTAmount;
	
	@Column(name = "siscount", columnDefinition = "varchar(256)")
	private double discount;
	
	@Column(name = "amount_paid", columnDefinition = "varchar(256)")
	private double amountPaid;
	
	@Column(name = "redeemed", columnDefinition = "varchar(256)")
	private double redeemed;
	
	
}