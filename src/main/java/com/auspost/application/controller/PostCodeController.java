package com.auspost.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auspost.application.dao.SuburbPostCodeRepository;
import com.auspost.application.model.SuburbPostCode;

@RestController
@RequestMapping(value = "/api")
public class PostCodeController {

	private final Logger logger = LoggerFactory.getLogger(PostCodeController.class.getName());
	@Autowired
	SuburbPostCodeRepository suburbPostCodeRepository;

	@PutMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<SuburbPostCode> create(@RequestBody SuburbPostCode suburbPostCode) {
		logger.info("Creating SuburbPostCode");
		SuburbPostCode toBeDeleted = suburbPostCodeRepository.getByPostCode(suburbPostCode.getPostCode());
		if (toBeDeleted != null) {
			suburbPostCodeRepository.delete(toBeDeleted);
			SuburbPostCode savedSuburbPostCode = suburbPostCodeRepository.save(suburbPostCode);
			return new ResponseEntity<SuburbPostCode>(savedSuburbPostCode, HttpStatus.OK);
		} else {
			SuburbPostCode savedSuburbPostCode = suburbPostCodeRepository.save(suburbPostCode);
			return new ResponseEntity<SuburbPostCode>(savedSuburbPostCode, HttpStatus.CREATED);
		}
	}

	@DeleteMapping(value = "/delete", consumes = "application/json")
	public ResponseEntity<String> delete(@RequestBody SuburbPostCode suburbPostCode) {
		logger.info("Deleting SuburbPostCode");
		SuburbPostCode toBeDeleted = suburbPostCodeRepository.getByPostCode(suburbPostCode.getPostCode());
		if (toBeDeleted != null) {
			suburbPostCodeRepository.delete(toBeDeleted);
		} else {
			return new ResponseEntity<String>("Not found : " + suburbPostCode, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Deleted successfully : " + toBeDeleted, HttpStatus.OK);
	}

	@RequestMapping(value = "/getbypostcode/{postCode}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<SuburbPostCode> getSuburb(@PathVariable int postCode) {
		logger.info("Getting Suburb for postcode: {}", postCode);
		SuburbPostCode suburbPostCode = suburbPostCodeRepository.getByPostCode(postCode);
		if (suburbPostCode != null) {
			return new ResponseEntity<SuburbPostCode>(suburbPostCode, HttpStatus.OK);
		} else {
			return new ResponseEntity<SuburbPostCode>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/getbysuburb/{suburb}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<SuburbPostCode> getPostCode(@PathVariable String suburb) {
		logger.info("Getting postcode for suburb: {}", suburb);
		SuburbPostCode suburbPostCode = suburbPostCodeRepository.getBySuburb(suburb);
		if (suburbPostCode != null) {
			return new ResponseEntity<SuburbPostCode>(suburbPostCode, HttpStatus.OK);
		} else {
			return new ResponseEntity<SuburbPostCode>(HttpStatus.NOT_FOUND);
		}
	}
}
