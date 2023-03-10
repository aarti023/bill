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
@Table(name = "brands")
@Entity(name = "brands")
public class BrandsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column(name = "brand_name" , columnDefinition = "varchar(100)")
	private String brandsName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<SubBrandsEntity> subBrands;
	
}
