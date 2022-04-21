package com.bbva.makz.lib.r001;

import java.util.List;

import com.bbva.makz.dto.employees.EmployeesDTO;

public interface MAKZR001 {
	
	public EmployeesDTO executeInsert(EmployeesDTO employee);
	public EmployeesDTO executeUpdate(EmployeesDTO employee);
	public void executeDeleteByNumber(EmployeesDTO employee);
	public EmployeesDTO executeGetByName(EmployeesDTO employee);
	public List<EmployeesDTO> executeAllEmployees();
	void execute();

}
