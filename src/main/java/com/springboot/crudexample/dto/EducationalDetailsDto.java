package com.springboot.crudexample.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educational_details")

public class EducationalDetailsDto implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "educational_details_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eductaionDetailsId;

	@Column(name = "highest_qualification")
	private String highestQualification;

	@Column(name = "courses")
	private String courses;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "institution_name")
	private String institutionName;

	@Column(name = "passout_year")
	private int passoutYear;

	@Column(name = "percentage")
	private double percentage;

	public EducationalDetailsDto(int eductaionDetailsId, String highestQualification, String courses,
			String specialization, String institutionName, int passoutYear, double percentage) {
		super();
		this.eductaionDetailsId = eductaionDetailsId;
		this.highestQualification = highestQualification;
		this.courses = courses;
		this.specialization = specialization;
		this.institutionName = institutionName;
		this.passoutYear = passoutYear;
		this.percentage = percentage;
	}

	@ManyToOne
	@JoinColumn(name = "personal_detail_id", referencedColumnName = "educational_details_id")
	private CrudExample crudExample;

}
