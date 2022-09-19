package com.training.employeedemo.port;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.training.employeedemo.model.Employee;

@Component
public interface EmployeeServicePort {
	public List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee employee);
	
	public Employee getEmployeeById(Long id);
	
	public Employee updateEmployee(Long id,Employee employee);
	
	public void deleteEmployee(Long id);
}
