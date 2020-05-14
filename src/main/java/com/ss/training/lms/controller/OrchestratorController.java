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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.ss.training.lms.entity.Author;
import com.ss.training.lms.entity.LibraryBranch;
import com.ss.training.lms.entity.Publisher;

/**
 * @author Justin O'Brien
 */
@RestController
@RequestMapping("/lms")
public class OrchestratorController {

	private final String adminBase = "http://localhost:8083/lms/admin";

	@Autowired
	RestTemplate restTemplate;

	// admin author
	
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
	
	// admin branch
	
	@PostMapping(path = "/admin/branch")
	public ResponseEntity<LibraryBranch> createBranch(RequestEntity<LibraryBranch> request) {
		try {
			return restTemplate.exchange(adminBase + "/branch", HttpMethod.POST, request, LibraryBranch.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/branches/{id}")
	public ResponseEntity<LibraryBranch> readBranch(@PathVariable int id, RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/branches/{id}", HttpMethod.GET, request, LibraryBranch.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch>((LibraryBranch) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/branches")
	public ResponseEntity<LibraryBranch[]> readBranches(RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/branches", HttpMethod.GET, request, LibraryBranch[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch[]>((LibraryBranch[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@PutMapping(path = "/admin/branch")
	public ResponseEntity<LibraryBranch> updateBranch(RequestEntity<LibraryBranch> request) {
		try {
			return restTemplate.exchange(adminBase + "/branch", HttpMethod.PUT, request, LibraryBranch.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@DeleteMapping(path = "/admin/branches/{id}")
	public ResponseEntity<LibraryBranch> updateBranch(@PathVariable int id, RequestEntity<LibraryBranch> request) {
		try {
			return restTemplate.exchange(adminBase + "/branches/{id}", HttpMethod.DELETE, request, LibraryBranch.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}
	
	// admin publisher
	
	@PostMapping(path = "/admin/publisher")
	public ResponseEntity<Publisher> createPublisher(RequestEntity<Publisher> request) {
		try {
			return restTemplate.exchange(adminBase + "/publisher", HttpMethod.POST, request, Publisher.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Publisher>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/publishers/{id}")
	public ResponseEntity<Publisher> readPublisher(@PathVariable int id, RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/publishers/{id}", HttpMethod.GET, request, Publisher.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Publisher>((Publisher) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/publishers")
	public ResponseEntity<Publisher[]> readPublishers(RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/publishers", HttpMethod.GET, request, Publisher[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Publisher[]>((Publisher[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@PutMapping(path = "/admin/publisher")
	public ResponseEntity<Publisher> updatePublisher(RequestEntity<Publisher> request) {
		try {
			return restTemplate.exchange(adminBase + "/publisher", HttpMethod.PUT, request, Publisher.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Publisher>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@DeleteMapping(path = "/admin/publishers/{id}")
	public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, RequestEntity<Publisher> request) {
		try {
			return restTemplate.exchange(adminBase + "/publishers/{id}", HttpMethod.DELETE, request, Publisher.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Publisher>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

}
