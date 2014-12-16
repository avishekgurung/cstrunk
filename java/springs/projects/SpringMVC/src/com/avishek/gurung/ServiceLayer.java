package com.avishek.gurung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
	
	@Autowired
	private DataLayer dataLayer;
	int result = 0;
	String message = "";
	public void add(Employee employee){
		int random = (int)(Math.random()*100000);
		employee.setId(random);
		dataLayer.add(employee);
	}
	
	public String delete(int id){
		result = dataLayer.delete(id);
		if(result == 0) message = "Employee record not found";
		else message = "Employee deleted";
		return message;
	}
	
	public List<Employee> show(){
		List<Employee> list = dataLayer.show();
		return list;
	}
}
