package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BindingClass.StudentBind;
import com.example.demo.Entity.StudentInformation;
import com.example.demo.Repository.StudentDataRepo;

@RestController
@RequestMapping("/first")
public class FirstMemberController {

	@Autowired
	StudentDataRepo str;

	@PostMapping("/insertdata")
	public String getMessage(@RequestBody StudentBind bnd) {
        System.out.println(bnd);
		StudentInformation std = new StudentInformation();
		std.setName(bnd.getName());
		std.setPassword(bnd.getPassword());
		std.setPlace(bnd.getPlace());
		std.setEmail(bnd.getEmail());
		System.out.println(std);
		StudentInformation save = str.save(std);
		System.out.println(save);
		if (save != null) {
			return "Your Data is Inserted Successfully";
		} else {
			return "Your Data is not Inserted Successfully";
		}
	}
	
	@GetMapping("/fetchalldata")
	public List<StudentInformation> GetAllData() {
		List<StudentInformation> findAll = str.findAll();
		return findAll; 
	}
	
	
	@PostMapping("/updateonedata")
	public String UpdateOneData(@RequestBody StudentInformation std) {
		Optional<StudentInformation> findById = str.findById(std.getId());
		StudentInformation studentInformation = findById.get();
		studentInformation.setId(std.getId());
		studentInformation.setEmail(std.getEmail());
		studentInformation.setName(std.getName());
		studentInformation.setPassword(std.getPassword());
		studentInformation.setPlace(std.getPlace());
		
		StudentInformation save = str.save(studentInformation);
		if(save!=null) {
			return "Your data is Update Successfully";
		}else {
			return "Your Data Was Not Updated Please try Again";
		}
	}
	
	@GetMapping("/deletebyid/{id}")
	public String Deletebyid(@PathVariable int id) {
		 str.deleteById(id);
         return "Your Data Was Deleted";
	}
	
	@GetMapping("/getonedata/{id}")
	public StudentInformation getOneData(@PathVariable int id) {
		Optional<StudentInformation> findById = str.findById(id);
		StudentInformation studentInformation = findById.get();
		return studentInformation;
	}
	
}
