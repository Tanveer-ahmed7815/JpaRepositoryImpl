package com.springboot.crudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crudexample.dao.CrudExampleDao;
import com.springboot.crudexample.dto.CrudExample;
import com.springboot.crudexample.exception.ResourceNotFoundException;

@Service
public class CrudServiceImpl implements CrudService {

	@Autowired
	CrudExampleDao crudExampleDao;

	@Override
	public CrudExample saveData(CrudExample crudExample) {

		CrudExample crud = crudExampleDao.save(crudExample);
		System.out.println("Data is persisted " + crud);
		return crud;
	}

	@Override
	public List<CrudExample> saveBulkData(List<CrudExample> crudExample) {

		return crudExampleDao.saveAll(crudExample);
	}

	@Override
	public List<CrudExample> findAllData() {

		List<CrudExample> list = crudExampleDao.findAll();
		System.out.println("getting data from db " + list);
		return list;
	}

	@Override
	public CrudExample getDataByName(String name) {

		return crudExampleDao.findByName(name);
	}

	@Override
	public CrudExample getDataById(int id) {

		return crudExampleDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
	}

	@Override
	public String deleteData(Integer id) {

		if (id != null) {
			Optional<CrudExample> value = crudExampleDao.findById(id);
			if (!value.isPresent()) {
				throw new ResourceNotFoundException("User not found with id :" + id);

			} else {
				crudExampleDao.deleteById(id);
			}
		}
		return "data deleted !!" + id;

	}

	@Override
	public CrudExample updateData(CrudExample crudExample) {

		CrudExample existingData = crudExampleDao.findById(crudExample.getPersonalDetailsId()).orElse(null);

		if (existingData == null) {
			throw new RuntimeException("User Id is not available");
		}

		return crudExampleDao.save(crudExample);

	}

}
