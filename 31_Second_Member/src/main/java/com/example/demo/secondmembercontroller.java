package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class secondmembercontroller {
	
	    @Autowired
	    ReciveData rec;
	
		@GetMapping("/secondmfirst")
		public String getMessage() {
			 String message = rec.getMessage();
			 return message;
		}
}
