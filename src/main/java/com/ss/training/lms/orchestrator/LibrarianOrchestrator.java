package com.ss.training.lms.orchestrator;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ss.training.lms.entity.BookCopies;
import com.ss.training.lms.entity.LibraryBranch;

@RestController
public class LibrarianOrchestrator {
	@Autowired
	RestTemplate restTemplate;
	
//	@RequestMapping(path="/lms/librarian/branches")
//	public ResponseEntity<List<LibraryBranch>> getBranches() throws SQLException {
//		ResponseEntity<List<LibraryBranch>> branches = new ResponseEntity<List<LibraryBranch>>(null);
//		return restTemplate.getForObject("http://localhost:8081/lms/librarian/branches", branches.getClass());
//	}
//	
	  @RequestMapping(path="lms/librarian/branches/{branch}/books/{book}/copies",
              produces = {
                  MediaType.APPLICATION_XML_VALUE,
                  MediaType.APPLICATION_JSON_VALUE
              })
	  public ResponseEntity<BookCopies> getAnEntryOfBookCopies(@PathVariable int branch, @PathVariable int book)
	  {
		  return restTemplate.getForEntity("http://localhost:8081/lms/librarian/branches/"+branch+"/books/"+book+"/copies", BookCopies.class);
	  }
}
