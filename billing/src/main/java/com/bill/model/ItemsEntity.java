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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Long id;
	
	@Column(name = "invoice_number", columnDefinition = "varchar(256)")
	private String invoiceNumber;
	
	@Column(name = "date_of_Invoice", columnDefinition = "varchar(256)")
	private String dateOfInvoice;
		
	@Column(name = "other_item", columnDefinition = "varchar(256)")
	private String otherItem;
	
	@Column(name = "item_name_code", columnDefinition = "varchar(256)")
	private String itemNameCode;
	
	@Column(name = "category_item", columnDefinition = "varchar(256)")
	private String categoryItem;
	
	@Column(name = "unit", columnDefinition = "varchar(256)")
	private String unit;
	
	@Column(name = "quantity", columnDefinition = "varchar(256)")
	private double quantity;
	
	@Column(name = "rate", columnDefinition = "varchar(256)")
	private double rate;
	
	@Column(name = "amount", columnDefinition = "varchar(256)")
	private double amount;
	
	@Column(name = "gst_amount_item", columnDefinition = "varchar(256)")
	private double gstAmountItem;
	
	@Column(name = "tds_amount", columnDefinition = "varchar(256)")
	private double tdsAmount;
	
	@Column(name = "discount", columnDefinition = "varchar(256)")
	private double discount;
	
	@Column(name = "amount_paid", columnDefinition = "varchar(256)")
	private double amountPaid;
	
	@Column(name = "redeemed", columnDefinition = "varchar(256)")
	private double redeemed;
	
	@Column(name = "cgst_percentage", columnDefinition = "varchar(256)")
	private double cgst;

	@Column(name = "igst_percentage", columnDefinition = "varchar(256)")
	private double igst;
	
	@Column(name = "sgst_percentage", columnDefinition = "varchar(256)")
	private double sgst;
	
	@Column(name = "tds_percentage", columnDefinition = "varchar(256)")
	private double tds;
	
	@Column(name = "invoice_id", columnDefinition = "varchar(10)")
	private String invoiceId;
	
	
}
