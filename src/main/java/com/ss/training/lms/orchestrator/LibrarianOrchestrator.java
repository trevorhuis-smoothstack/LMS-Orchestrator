package com.ss.training.lms.orchestrator;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.ss.training.lms.entity.Book;
import com.ss.training.lms.entity.BookCopies;
import com.ss.training.lms.entity.LibraryBranch;


@RestController
@CrossOrigin
public class LibrarianOrchestrator {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(path = "/lms/librarian/branches")
	public ResponseEntity<LibraryBranch[]> getBranches() {
		try {
			return restTemplate.getForEntity("http://localhost:8081/lms/librarian/branches", LibraryBranch[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<LibraryBranch[]>((LibraryBranch[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}
	
	@GetMapping(path = "/lms/librarian/books/{search}")
	public ResponseEntity<Book[]> getBooksWithSearch(@PathVariable String search) {
		try {
			return restTemplate.getForEntity("http://localhost:8081/lms/librarian/books/"+search, Book[].class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<Book[]>((Book[]) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}
	
	@GetMapping(path="lms/librarian/branches/{branch}/books/{book}/copies")
	public ResponseEntity<BookCopies> getAnEntryOfBookCopies(@PathVariable int branch, @PathVariable int book)
	{
	  return restTemplate.getForEntity("http://localhost:8081/lms/librarian/branches/"+branch+"/books/"+book+"/copies", BookCopies.class);
	}
	
	@PutMapping(path="lms/librarian/branches/{branch}/copies")
	public ResponseEntity<BookCopies> updateCopies(@PathVariable int branch, @RequestBody BookCopies bookCopies)
	{
		RequestEntity<BookCopies> request;
		try {
			request = RequestEntity
				     .put(new URI("http://localhost:8081/lms/librarian/branches/"+branch+"/copies"))
				     .accept(MediaType.APPLICATION_JSON)
				     .body(bookCopies);
					ResponseEntity<BookCopies> response = restTemplate.exchange(request, BookCopies.class);
					return response;

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	  
	@PutMapping(path="lms/librarian/branches/{branchId}")
	public ResponseEntity<LibraryBranch> updateBranch(@PathVariable int branchId, @RequestBody LibraryBranch branch)
	{
		RequestEntity<LibraryBranch> request;
		try {
			request = RequestEntity
				     .put(new URI("http://localhost:8081/lms/librarian/branches/"+branchId))
				     .accept(MediaType.APPLICATION_JSON)
				     .body(branch);
					ResponseEntity<LibraryBranch> response = restTemplate.exchange(request, LibraryBranch.class);
					return response;

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	  
}
