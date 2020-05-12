package com.ss.training.lms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Justin O'Brien
 */
@RestController
public class DummyController {

	@RequestMapping(path = "/lms")
	public String lmsDummy() {
		return "LMS page";
	}

	@RequestMapping(path = "/lms/librarian/dummy")
	public String librarianDummy() {
		return "Librarian page";
	}

	@RequestMapping(path = "/lms/borrower/dummy")
	public String borrowerDummy() {
		return "Borrower page";
	}

	@RequestMapping(path = "/lms/admin/dummy")
	public String adminDummy() {
		return "Admin page";
	}

}
