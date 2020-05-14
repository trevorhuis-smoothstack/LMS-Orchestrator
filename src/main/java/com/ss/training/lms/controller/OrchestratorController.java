package com.ss.training.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.ss.training.lms.entity.Book;
import com.ss.training.lms.entity.BookAuthor;
import com.ss.training.lms.entity.BookGenre;
import com.ss.training.lms.entity.Borrower;
import com.ss.training.lms.entity.Genre;
import com.ss.training.lms.entity.LibraryBranch;
import com.ss.training.lms.entity.Publisher;

/**
 * @author Justin O'Brien
 */
@RestController
@CrossOrigin
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

	// admin book

	@PostMapping(path = "/admin/book")
	public ResponseEntity<Book> createBook(RequestEntity<Book> request) {
		try {
			return restTemplate.exchange(adminBase + "/book", HttpMethod.POST, request, Book.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Book>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/book/{id}")
	public ResponseEntity<Book> readBook(@PathVariable int id, RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/book/{id}", HttpMethod.GET, request, Book.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Book>((Book) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/book")
	public ResponseEntity<Book[]> readBooks(RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/book", HttpMethod.GET, request, Book[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Book[]>((Book[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@PutMapping(path = "/admin/book")
	public ResponseEntity<Book> updateBook(RequestEntity<Book> request) {
		try {
			return restTemplate.exchange(adminBase + "/book", HttpMethod.PUT, request, Book.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Book>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@DeleteMapping(path = "/admin/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, RequestEntity<Book> request) {
		try {
			return restTemplate.exchange(adminBase + "/book/{id}", HttpMethod.DELETE, request, Book.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Book>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@PostMapping(path = "admin/book/genre")
	public ResponseEntity<BookGenre> createGenreReference(RequestEntity<BookGenre> request) {
		try {
			return restTemplate.exchange(adminBase + "/book/genre", HttpMethod.PUT, request, BookGenre.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<BookGenre>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}
	
	@PostMapping(path = "admin/book/author")
	public ResponseEntity<BookAuthor> createAuthorReference(RequestEntity<BookAuthor> request) {
		try {
			return restTemplate.exchange(adminBase + "/book/author", HttpMethod.PUT, request, BookAuthor.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<BookAuthor>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	// admin borrower

	@PostMapping(path = "/admin/borrowers")
	public ResponseEntity<Borrower> createBorrower(RequestEntity<Borrower> request) {
		try {
			return restTemplate.exchange(adminBase + "/borrowers", HttpMethod.POST, request, Borrower.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Borrower>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/borrowers/{id}")
	public ResponseEntity<Borrower> readBorrower(@PathVariable int id, RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/borrowers/{id}", HttpMethod.GET, request, Borrower.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Borrower>((Borrower) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/borrowers")
	public ResponseEntity<Borrower[]> readBorrowers(RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/borrowers", HttpMethod.GET, request, Borrower[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Borrower[]>((Borrower[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@PutMapping(path = "/admin/borrowers")
	public ResponseEntity<Borrower> updateBorrower(RequestEntity<Borrower> request) {
		try {
			return restTemplate.exchange(adminBase + "/borrowers", HttpMethod.PUT, request, Borrower.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Borrower>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@DeleteMapping(path = "/admin/borrowers/{id}")
	public ResponseEntity<Borrower> updateBorrower(@PathVariable int id, RequestEntity<Borrower> request) {
		try {
			return restTemplate.exchange(adminBase + "/borrowers/{id}", HttpMethod.DELETE, request, Borrower.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Borrower>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
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
			return restTemplate.exchange(adminBase + "/branches/{id}", HttpMethod.GET, request, LibraryBranch.class,
					id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch>((LibraryBranch) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/branches")
	public ResponseEntity<LibraryBranch[]> readBranches(RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/branches", HttpMethod.GET, request, LibraryBranch[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch[]>((LibraryBranch[]) null,
					HttpStatus.valueOf(e.getRawStatusCode()));
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
			return restTemplate.exchange(adminBase + "/branches/{id}", HttpMethod.DELETE, request, LibraryBranch.class,
					id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	// admin genre

	@PostMapping(path = "/admin/genre")
	public ResponseEntity<Genre> createGenre(RequestEntity<Genre> request) {
		try {
			return restTemplate.exchange(adminBase + "/genre", HttpMethod.POST, request, Genre.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Genre>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/genre/{id}")
	public ResponseEntity<Genre> readGenre(@PathVariable int id, RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/genre/{id}", HttpMethod.GET, request, Genre.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Genre>((Genre) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@GetMapping(path = "/admin/genre")
	public ResponseEntity<Genre[]> readGenres(RequestEntity<?> request) {
		try {
			return restTemplate.exchange(adminBase + "/genre", HttpMethod.GET, request, Genre[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Genre[]>((Genre[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@PutMapping(path = "/admin/genre")
	public ResponseEntity<Genre> updateGenre(RequestEntity<Genre> request) {
		try {
			return restTemplate.exchange(adminBase + "/genre", HttpMethod.PUT, request, Genre.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Genre>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

	@DeleteMapping(path = "/admin/genre/{id}")
	public ResponseEntity<Genre> updateGenre(@PathVariable int id, RequestEntity<Genre> request) {
		try {
			return restTemplate.exchange(adminBase + "/genre/{id}", HttpMethod.DELETE, request, Genre.class, id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Genre>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
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

	@GetMapping(path = "/admin/publisher")
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
			return restTemplate.exchange(adminBase + "/publishers/{id}", HttpMethod.DELETE, request, Publisher.class,
					id);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Publisher>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

}
