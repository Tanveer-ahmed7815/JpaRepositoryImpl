package com.springboot.crudexample.reqdto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.crudexample.dto.EducationalDetailsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CrudExampleReq {

	private int personalDetailsId;

	private String employeeId;

	private String gender;

	private String name;

	@JsonFormat(pattern = "dd/mm/yyyy")

	private Date tyJoiningDate;

	private String contactNumber;

	private String alternateNumber;

	private String emergencyContactNumberOne;

	private String emergencyContactNumberTwo;

	private String officialEmailId;

	private String personalEmailId;

	private String temperoryAddress;

	private String permanentAddress;

	private String resume;

	private List<EducationalDetailsDto> educationalDetails;
}
