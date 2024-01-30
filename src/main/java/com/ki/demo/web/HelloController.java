package com.ki.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String sayHello() {
		return "<h1>hello world</h1>";
	}
}