package com.ss.training.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.ss.training.lms.entity.Author;

/**
 * @author Justin O'Brien
 */
@RestController
@RequestMapping("/lms")
public class OrchestratorController {

	private final String adminBase = "http://localhost:8083/lms/admin";

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/admin/author")
	public ResponseEntity<Author> createAuthor(RequestEntity<Author> request) {
		try {
			return restTemplate.exchange(adminBase + "/author", HttpMethod.POST, request, Author.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Author>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/authors/{id}")
	public ResponseEntity<Author> readAuthor(@PathVariable int id, RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/authors/{id}", HttpMethod.GET, request, Author.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Author>((Author) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/authors")
	public ResponseEntity<Author[]> readAuthors(RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/authors", HttpMethod.GET, request, Author[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Author[]>((Author[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@PutMapping(path = "/admin/author")
	public ResponseEntity<Author> updateAuthor(RequestEntity<Author> request) {
		try {
			return restTemplate.exchange(adminBase + "/author", HttpMethod.PUT, request, Author.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Author>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@DeleteMapping(path = "/admin/authors/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable int id, RequestEntity<Author> request) {
		try {
			return restTemplate.exchange(adminBase + "/authors/{id}", HttpMethod.DELETE, request, Author.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Author>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

}
