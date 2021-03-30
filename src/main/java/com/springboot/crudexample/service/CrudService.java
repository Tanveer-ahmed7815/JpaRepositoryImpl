package com.springboot.crudexample.service;

import java.util.List;

import com.springboot.crudexample.dto.CrudExample;

public interface CrudService {

	public CrudExample saveData(CrudExample crudExample);

	public List<CrudExample> saveBulkData(List<CrudExample> crudExample);

	public List<CrudExample> findAllData();

	public CrudExample getDataByName(String name);

	public CrudExample getDataById(int id);

	public String deleteData(Integer id);

	public CrudExample updateData(CrudExample crudExample);

}
