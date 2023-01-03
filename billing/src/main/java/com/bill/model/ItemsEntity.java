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
		
	@Column(name = "item_Code", columnDefinition = "varchar(256)")
	private String itemCode;
	
	@Column(name = "item_name", columnDefinition = "varchar(256)")
	private String itemName;
	
	@Column(name = "category", columnDefinition = "varchar(256)")
	private String category;
	
	@Column(name = "unit", columnDefinition = "varchar(256)")
	private String unit;
	
	@Column(name = "quantity", columnDefinition = "varchar(256)")
	private double quantity;
	
	@Column(name = "rate", columnDefinition = "varchar(256)")
	private double rate;
	
	@Column(name = "amount", columnDefinition = "varchar(256)")
	private double amount;
	
	@Column(name = "gst_amount", columnDefinition = "varchar(256)")
	private double gstAmount;
	
	@Column(name = "tds_amount", columnDefinition = "varchar(256)")
	private double tdsAmount;
	
	@Column(name = "tds%", columnDefinition = "varchar(256)")
	private double tds;
	
	@Column(name = "discount", columnDefinition = "varchar(256)")
	private double discount;
	
	@Column(name = "amount_paid", columnDefinition = "varchar(256)")
	private double amountPaid;
	
	@Column(name = "redeemed", columnDefinition = "varchar(256)")
	private double redeemed;
	
	@Column(name = "cgst%", columnDefinition = "varchar(256)")
	private double cgst;

	@Column(name = "igst%", columnDefinition = "varchar(256)")
	private double igst;
	
	@Column(name = "sgst%", columnDefinition = "varchar(256)")
	private double sgst;
	
	
}
