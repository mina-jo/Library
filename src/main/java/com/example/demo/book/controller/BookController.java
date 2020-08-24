package com.example.demo.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.sample.BootstrapSampleController;

@Controller
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BootstrapSampleController.class);
	
	@RequestMapping(value="/bookList", method = RequestMethod.GET)
	public String bookList() {
		logger.info("===== bookList =====");
		return "book/bookList";
	}

}
