package com.springboot.crudexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.crudexample.dto.CrudExample;


public interface CrudExampleDao extends JpaRepository<CrudExample, Integer>{

	public CrudExample findByName(String name);

}
