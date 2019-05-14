package com.auspost.application.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.auspost.application.dao.SuburbPostCodeRepository;
import com.auspost.application.model.SuburbPostCode;

@RunWith(MockitoJUnitRunner.class)
public class PostCodeControllerTest {

	@Mock
	private SuburbPostCodeRepository repository;

	@InjectMocks
	PostCodeController postCodeController = new PostCodeController();

	private SuburbPostCode suburbPostCode1;
	private SuburbPostCode suburbPostCode2;
	private SuburbPostCode suburbPostCode3;

	@Before
	public void before() {
		suburbPostCode1 = new SuburbPostCode(3335, "Thornhill Park");
		suburbPostCode2 = new SuburbPostCode(3037, "Sydenham");
		suburbPostCode3 = new SuburbPostCode(3000, "Melbourne");
	}

	@Test
	public void createTest() {
		when(repository.save(Mockito.any(SuburbPostCode.class))).thenReturn(suburbPostCode1);
		ResponseEntity<SuburbPostCode> responseEntity = postCodeController.create(suburbPostCode1);
		SuburbPostCode savedSuburbPostCode = responseEntity.getBody();
		Assert.assertEquals(3335, savedSuburbPostCode.getPostCode());
		Assert.assertEquals("Thornhill Park", savedSuburbPostCode.getSuburb());

	}

	@Test
	public void getSuburbTest() {
		when(repository.getByPostCode(Mockito.any(Integer.class))).thenReturn(suburbPostCode2);
		ResponseEntity<SuburbPostCode> responseEntity = postCodeController.getSuburb(3037);
		SuburbPostCode suburbPostCode = responseEntity.getBody();
		Assert.assertEquals(3037, suburbPostCode.getPostCode());
		Assert.assertEquals("Sydenham", suburbPostCode.getSuburb());
	}

	@Test
	public void getPostCodeTest() {
		when(repository.getBySuburb(Mockito.any(String.class))).thenReturn(suburbPostCode3);
		ResponseEntity<SuburbPostCode> responseEntity = postCodeController.getPostCode("Melbourne");
		SuburbPostCode suburbPostCode = responseEntity.getBody();
		Assert.assertEquals(3000, suburbPostCode.getPostCode());
		Assert.assertEquals("Melbourne", suburbPostCode.getSuburb());
	}
}