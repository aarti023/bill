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
@Table(name = "departments")
@Entity(name = "departments")
public class Departments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "department_name", columnDefinition = "varchar(100)")
	private String departmentName;

//	@OneToMany(cascade = CascadeType.ALL)
//	private List<CategoriesEntity> categories;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<SubCategories1Entity> subCategories;

}
