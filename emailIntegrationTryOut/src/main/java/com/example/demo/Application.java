package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostMapping("/compose")
	
	public String sendMail(@RequestParam String toEmail, @RequestParam String Subject, @RequestParam String body) {
		emailSenderService.sendEmail(toEmail, Subject, body);
		return "Sucessfully send mail";

	}

}
