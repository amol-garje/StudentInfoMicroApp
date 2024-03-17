package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="FIRSTMEMBERAPPLICATION")
public interface ReciveData {
    
	@GetMapping("/firstmfirst")
	public String getMessage();
	
}
