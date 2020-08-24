package com.example.demo.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleClass {
	
	@RequestMapping(value="/sample", method = RequestMethod.GET)
	public String sample() {
		return "sample";
	}

}
