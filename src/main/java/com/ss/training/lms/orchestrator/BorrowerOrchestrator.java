package com.ss.training.lms.orchestrator;

import java.net.URI;
import java.net.URISyntaxException;

import com.ss.training.lms.entity.BookLoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@RestController
public class BorrowerOrchestrator {

    @Autowired
    RestTemplate restTemplate;

	
	@PutMapping(path = "lms/borrower/returnBook")
	public ResponseEntity<BookLoan> updateBook(RequestEntity<BookLoan> request) {
		try {
			return restTemplate.exchange("http://localhost:8082/lms/borrower/returnBook", HttpMethod.PUT, request, BookLoan.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<BookLoan>(request.getBody(), HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}

    @PostMapping(path = "lms/borrower/checkOutBook/{bookId}/branch/{branchId}/borrower/{cardNo}")
	public ResponseEntity<BookLoan> createBook(@PathVariable int bookId, @PathVariable int branchId, @PathVariable int cardNo) {
		try {
			return restTemplate.postForEntity("http://localhost:8082/lms/borrower/checkOutBook/" + bookId + "/branch/"
                    + branchId + "/borrower/" + cardNo, HttpMethod.POST, BookLoan.class);
		} catch (RestClientResponseException e) {
			return new ResponseEntity<BookLoan>((BookLoan) null, HttpStatus.valueOf(e.getRawStatusCode()));
		}
	}
} 