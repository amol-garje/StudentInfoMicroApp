package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BindingDataHere.BindingData;
import com.example.demo.BindingDataHere.ResponceComeBindData;
import com.example.demo.DataBaseConnect.ConnecToTheDataBase;

@Controller
public class AppHandler {

	@Autowired
	ConnecToTheDataBase cns;
	
	// Welcome Page Controller ....
	@GetMapping("/")
	public ModelAndView Welcome() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("Welcome");
		return mav;
	}
	
	//AddUser Page Controller...
	@GetMapping("/addstudent")
	public String AddUser() {
		return "AddStudent";
	}
	
	// Display User Controller...
	@GetMapping("/displaystudent")
	public String DisplayStudent(Model m) {
		List<ResponceComeBindData> displayData = cns.DisplayData();
        m.addAttribute("dta", displayData);
		return "Display";
	}
	
	//Contact User Controller ...
	@GetMapping("/contactus")
	public String ContactUs(Model m) {
		return "Contact";
	}
	
	
	//Data Fetch From The From  ...
		@PostMapping("/fromdata")
		public String AddFromData(BindingData dta,Model m) {
			
			String dataBase = cns.InsertDataIntoDataBase(dta);
			System.out.println(dataBase);			
			return "redirect:/addstudent";
		}
		
		
    // Delete The Data 
		
		@GetMapping("/deletedata")
		public String DeleteData(@RequestParam int id) {
			String deleteData = cns.DeleteData(id);
			return "redirect:/displaystudent";
		}
		
		
    // Update the Data 
		
	   @GetMapping("/getmapping")
	   public String UpdateTheData(@RequestParam int id,Model m) {
		   ResponceComeBindData oneData = cns.getOneData(id);
		   System.out.println(oneData);
		   m.addAttribute("dta", oneData);
		   return "Update";
	   }
	   
	   
	   
	   @PostMapping("/mainupdate")
	   public String UpdatemainDataTheData(ResponceComeBindData c) {
		   System.out.println(c);
		   String updateData = cns.UpdateData(c);
		   System.out.println(updateData);
		   return "redirect:/displaystudent";
	   }
	
	
	
	
	
	
}
