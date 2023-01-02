package com.bill.dropdowns;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subCatogeries")
@Entity(name = "subCatogeries")
public class SubCategories1Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column(name = "sub_categories_name", columnDefinition = "varchar(100)")
	private String SubCategories1Name;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<SubCategories2Entity> subCategories2;
	
}
