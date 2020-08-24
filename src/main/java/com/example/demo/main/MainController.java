package com.example.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.sample.BootstrapSampleController;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(BootstrapSampleController.class);
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String main() {
		logger.info("===== main =====");
		return "index";
	}

}
