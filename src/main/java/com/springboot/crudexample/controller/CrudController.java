package com.springboot.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudexample.dto.CrudExample;
import com.springboot.crudexample.service.CrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/crud")
@Api(value = "Crud Example")
public class CrudController {

	@Autowired
	CrudService crudService;

	@PostMapping()
	@ApiOperation(value="store employee details api")
	public CrudExample addData(@RequestBody CrudExample crudExample) {

		return crudService.saveData(crudExample);
	}

	@PostMapping("/list")
	@ApiOperation(value="store list of employee details api")
	public List<CrudExample> addBulkData(@RequestBody List<CrudExample> crudExample) {
		return crudService.saveBulkData(crudExample);
	}

	@GetMapping("/list")
	@ApiOperation(value="fetch list of employee details api")
	public List<CrudExample> findAllData() {
		return crudService.findAllData();
	}

	@GetMapping("/{name}")
	@ApiOperation(value="fetch by name api")
	public CrudExample getDataByName(@PathVariable String name) {
		return crudService.getDataByName(name);
	}

	@GetMapping("/get/{id}")
	@ApiOperation(value="fetch by Id api")
	public CrudExample getDataById(@PathVariable int id) {
		return crudService.getDataById(id);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value="delete by Id api")
	public String deleteData(@PathVariable Integer id) {

		return crudService.deleteData(id);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="update employee details api")
	public CrudExample updateData(@RequestBody CrudExample crudExample) {
		
		return crudService.updateData(crudExample);
	}

}
