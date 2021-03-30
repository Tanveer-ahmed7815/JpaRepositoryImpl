package com.springboot.crudexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.crudexample.dao.CrudExampleDao;
import com.springboot.crudexample.dto.CrudExample;
import com.springboot.crudexample.dto.EducationalDetailsDto;
import com.springboot.crudexample.service.CrudService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudWithSpringBootApplicationTests {

	@MockBean
	private CrudExampleDao crudExampleDao;

	@Autowired
	private CrudService crudService;
	
	
	
	private static List<EducationalDetailsDto> list = new ArrayList<>();
	static {
		list.add(new EducationalDetailsDto(5, "degree", "BE", "ECE", "TOCE", 2019, 70));
		list.add(new EducationalDetailsDto(5, "PG", "ME", "TCE", "MSRIT", 2022, 60));
	}

	@Test
	public void findAllDataTest() {
		when(crudExampleDao.findAll()).thenReturn(Stream
				.of(new CrudExample(5, "xyz123", "male", "tanveer", new Date(), "123456", "121213", "4232121", "122111",
						"abc@gmail.com", "xyz@gmail.com", "india", "Usa", "resume", list))
				.collect(Collectors.toList()));

		assertEquals(1, crudService.findAllData().size());

	}

	@Test
	public void addData() {
		CrudExample crudExample = new CrudExample(5, "xyz123", "male", "tanveer", new Date(), "123456", "121213",
				"4232121", "122111", "abc@gmail.com", "xyz@gmail.com", "india", "Usa", "resume", list);
		when(crudExampleDao.save(crudExample)).thenReturn(crudExample);

		assertEquals(crudExample, crudService.saveData(crudExample));
	}

//	@Test
//	public void deleteData() {
////		CrudExample crudExample = new CrudExample(5, "xyz123", "male", "tanveer", new Date(), "123456", "121213",
////				"4232121", "122111", "abc@gmail.com", "xyz@gmail.com", "india", "Usa", "resume", list);
//		int id=5;
//		crudService.deleteData(id);
//		verify(crudExampleDao, times(1)).deleteById(id);
//	}
}
