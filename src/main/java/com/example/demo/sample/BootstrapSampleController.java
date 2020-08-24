package com.example.demo.sample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BootstrapSampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(BootstrapSampleController.class);
	
	@RequestMapping(value="/bootstrapSample", method = RequestMethod.GET)
	public String sample() {
		logger.info("INFO test");
		System.out.println("sys info");
		return "bootstrap/bootstrapSample";
	}
	
	@RequestMapping(value="/htmlTagPage", method = RequestMethod.GET)
	public String htmlTagPage() {
		logger.info("====== htmlTagPage PAGE ======");
		return "bootstrap/htmlTagPage";
	}
	

}
