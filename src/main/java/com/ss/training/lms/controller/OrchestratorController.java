package com.ss.training.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ss.training.lms.entity.Author;

/**
 * @author Justin O'Brien
 */
@RestController
public class OrchestratorController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(path = "/lms/admin/authors/{id}")
	public ResponseEntity<Author> readAuthor(@PathVariable int id) {
		return restTemplate.getForEntity("/lms/admin/authors/{id}" + id, Author.class);
	}

}
