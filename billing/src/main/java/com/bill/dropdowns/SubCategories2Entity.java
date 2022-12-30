package com.bill.dropdowns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subCatogeries2")
@Entity(name = "subCatogeries2")
public class SubCategories2Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;

	@Column(name = "sub_categories2" , columnDefinition = "varchar(100)")
	private String subCategories2;
	

}
