package com.ss.training.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.ss.training.lms.entity.Author;

/**
 * @author Justin O'Brien
 */
@RestController
public class OrchestratorController {

	@Autowired
	RestTemplate restTemplate;

	// this one still needs try-catch
//	@PostMapping(path = "/lms/admin/author")
//	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
//		return restTemplate.postForEntity("http://localhost:8083/lms/admin/author/", author, Author.class);
//	}

	@GetMapping(path = "/lms/admin/authors/{id}")
	public ResponseEntity<Author> readAuthor(@PathVariable int id) {
		try {
			return restTemplate.getForEntity("http://localhost:8083/lms/admin/authors/" + id, Author.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Author>((Author) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/lms/admin/authors")
	public ResponseEntity<Author[]> readAuthors() {
		try {
			return restTemplate.getForEntity("http://localhost:8083/lms/admin/authors", Author[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Author[]>((Author[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

}
