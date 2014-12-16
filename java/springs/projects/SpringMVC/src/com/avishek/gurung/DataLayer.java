package com.avishek.gurung;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataLayer {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	int result = 0;

	public void add(Employee employee){
		jdbcTemplate.update("INSERT INTO employeeRecord(ID,NAME,COMPANY) values(?,?,?)",new Object[]{employee.getId(),employee.getName(),employee.getCompany()});
	}
	
	public int delete(int id){
		result = jdbcTemplate.update("delete from employeeRecord where id = "+id);
		return result;
	}
	
	public List<Employee> show(){
		List<Employee> list = new ArrayList<Employee>();
		list = jdbcTemplate.query("select * from employeeRecord", new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}
}
