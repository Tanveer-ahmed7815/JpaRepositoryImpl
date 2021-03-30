package com.springboot.crudexample.reqdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationalDetailsReq {
	
	private int eductaionDetailsId;


	private String highestQualification;


	private String courses;


	private String specialization;


	private String institutionName;


	private int passoutYear;


	private double percentage;
	
}
