package com.ss.training.lms.orchestrator;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ss.training.lms.entity.BookLoan;


@RestController
@CrossOrigin
public class AdminOverrideLoanOrchestrator {

	@Autowired
	RestTemplate restTemplate;
	
	@PutMapping(path="lms/admin/bookloans/extend")
	public ResponseEntity<BookLoan> updateCopies(@RequestBody BookLoan bookLoan)
	{
		RequestEntity<BookLoan> request;
		try {
			request = RequestEntity
				     .put(new URI("http://localhost:8083/lms/admin/bookloans/extend"))
				     .accept(MediaType.APPLICATION_JSON)
				     .body(bookLoan);
					ResponseEntity<BookLoan> response = restTemplate.exchange(request, BookLoan.class);
					return response;

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	  
}
