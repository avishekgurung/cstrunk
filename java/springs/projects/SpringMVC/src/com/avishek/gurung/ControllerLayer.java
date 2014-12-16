package com.avishek.gurung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLayer {

	@Autowired
	private ServiceLayer serviceLayer;
	Boolean result;
	String message;
	
	@RequestMapping(value={"/","home","index","welcome"})
	public String indexPage(Model model){
		model.addAttribute("message", "Welcome to Spring MVC");
		return "index";
	}
	
	@RequestMapping(value="addInfo")
	public String addInfo(Model model){
		model.addAttribute("message", "Add Employee Detail");
		return "addInfo";
	}
	
	@RequestMapping(value="deleteInfo")
	public String deleteInfo(Model mode){
		mode.addAttribute("message","Delete Employee Detail");
		return "deleteInfo";
	}
	
	@RequestMapping(value="delete")
	public String delete(Model model, Employee employee){
		message = serviceLayer.delete(employee.getId());
		model.addAttribute("message", message);
		return "result";
	}
	
	@RequestMapping(value="add")
	public String add(Model model, Employee employee){
		serviceLayer.add(employee);
		message = "Employee Info added successfully";
		model.addAttribute("message", message);
		return "result";
	}
	
	@RequestMapping(value="show")
	public String show(Model model){
		List<Employee> list = serviceLayer.show();
		message = "Employee Records";
		model.addAttribute("message", message);
		model.addAttribute("list", list);
		return "show";
	}
}

