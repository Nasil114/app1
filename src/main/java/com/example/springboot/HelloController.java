package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloController {

	@Autowired
	private Environment env;


	@GetMapping("service1/app1")
	public String index() {
		return "This is a application1!";
	}


	@GetMapping("service1/getcurrentime")
	public String getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return (dtf.format(now));
	}

	@GetMapping("service1/getapplicationproperties")
	public String getApplicationProperties() {

		StringBuilder sb=new StringBuilder();
		sb.append("\"spring.datasource.url").append(" : ").append( env.getProperty("spring.datasource.url")).append("\n");
		sb.append("\"app.debug").append(" : ").append( env.getProperty("app.debug"));
    	return (sb.toString());
	}

}
