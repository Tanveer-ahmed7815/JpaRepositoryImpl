package com.springboot.crudexample.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "crud_example")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrudExample implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "personal_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personalDetailsId;

	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "gender")
	private String gender;

	@Column(name = "name")
	private String name;

	@JsonFormat(pattern = "dd/mm/yyyy")
	@Column(name = "ty_joining_date")
	private Date tyJoiningDate;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "alternate_number")
	private String alternateNumber;

	@Column(name = "emergency_contact_number_one")
	private String emergencyContactNumberOne;

	@Column(name = "emergency_contact_number_two")
	private String emergencyContactNumberTwo;

	@Column(name = "official_email_id")
	private String officialEmailId;

	@Column(name = "personal_email_id")
	private String personalEmailId;

	@Column(name = "temperory_address")
	private String temperoryAddress;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "resume")
	private String resume;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "personal_detail_id", referencedColumnName = "personal_detail_id")
	private List<EducationalDetailsDto> educationalDetails;

}
