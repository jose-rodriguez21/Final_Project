package com.bbva.makz.lib.r001.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.apx.exception.db.DuplicateKeyException;
import com.bbva.apx.exception.db.NoResultException;
import com.bbva.apx.exception.db.TimeoutException;
import com.bbva.makz.dto.employees.EmployeesDTO;

public class MAKZR001Impl extends MAKZR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(MAKZR001Impl.class);

	@Override
	public void execute() {
		// TODO - Implementation of business logic
	}

	@Override
	public EmployeesDTO executeInsert(EmployeesDTO employee) {
		LOGGER.info("Entrado al metodo executeInsert");

		int result = 0;

		try {

			Map<String, Object> param = new HashMap<>();
			param.put("number", employee.getEmployeeNumber());
			param.put("name", employee.getEmployeeName());
			param.put("dept", employee.getEmployeeDept());
			param.put("rfc", employee.getEmployeeRFC());
			param.put("email", employee.getEmployeeEmail());
			param.put("phone", employee.getEmployeePhone());
			param.put("address", employee.getEmployeeAddress());
			param.put("date", employee.getEmployeeDate());
			param.put("status", employee.getEmployeeStatus());
			param.put("salary", employee.getSalary());
			
			if (validatePhone(employee.getEmployeePhone().toString()) &&
					validateEmail(employee.getEmployeeEmail().toString()) &&
					validateRfc(employee.getEmployeeRFC().toString())) {
				
				result = this.jdbcUtils.update("insert", param);
				
			}

		} catch (DuplicateKeyException e) {

			LOGGER.error("Ocurrio un problema se duplico el key en la tabla customers");
			addAdvice("MNEO01317004");

		} catch (TimeoutException e) {

			LOGGER.error("Ocurrio un problema se excedio el tiempo para insertar en la tabla customers");
			addAdvice("MNEO01317005");

		}
		return employee;
	}

	@Override
	public EmployeesDTO executeUpdate(EmployeesDTO employee) {
		LOGGER.info("Entrado al metodo executeInsert");

		int result = 0;

		try {

			Map<String, Object> param = new HashMap<>();
			param.put("name", employee.getEmployeeName());
			param.put("dept", employee.getEmployeeDept());
			param.put("rfc", employee.getEmployeeRFC());
			param.put("email", employee.getEmployeeEmail());
			param.put("phone", employee.getEmployeePhone());
			param.put("address", employee.getEmployeeAddress());
			param.put("date", employee.getEmployeeDate());
			param.put("status", employee.getEmployeeStatus());
			param.put("salary", employee.getSalary());
			param.put("number", employee.getEmployeeNumber());

			result = this.jdbcUtils.update("update", param);

		} catch (DuplicateKeyException e) {

			LOGGER.error("Ocurrio un problema se duplico el key en la tabla customers");
			addAdvice("MNEO01317004");

		} catch (TimeoutException e) {

			LOGGER.error("Ocurrio un problema se excedio el tiempo para insertar en la tabla customers");
			addAdvice("MNEO01317005");

		}
		return employee;
	}

	@Override
	public void executeDeleteByNumber(EmployeesDTO employee) {
		LOGGER.info("Entrando al metodo executeDelete");

		int result = 0;
		EmployeesDTO empleado = null;

		try {

			Map<String, Object> param = new HashMap<>();
			param.put("number", employee.getEmployeeNumber());
			result = this.jdbcUtils.update("delete", param);

		} catch (DuplicateKeyException e) {

			LOGGER.error("Ocurrio un problema se duplico el key en la tabla customers");
			addAdvice("MNEO01317004");

		} catch (TimeoutException e) {

			LOGGER.error("Ocurrio un problema se excedio el tiempo para insertar en la tabla customers");
			addAdvice("MNEO01317005");

		}

	}

	@Override
	public EmployeesDTO executeGetByName(EmployeesDTO employee) {

		LOGGER.info("Entrando al metodo executeGetByName");

		EmployeesDTO empleado = new EmployeesDTO();
		;

		try {

			Map<String, Object> param = new HashMap<>();
			param.put("name", employee.getEmployeeName());

			List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
			lista = this.jdbcUtils.queryForList("getEmployeeName", param);

			if (lista.size() > 1) {

				LOGGER.info("Entrando a buscar registo");

				for (Map<String, Object> map : lista) {
					if (employee.equals(map.get("EMPLOYEE_NAME").toString())) {

						empleado.setEmployeeNumber(Integer.parseInt(map.get("EMPLOYEE_NUMBER").toString()));
						empleado.setEmployeeName(map.get("EMPLOYEE_NAME").toString());
						empleado.setEmployeeDept(map.get("EMPLOYEE_DEPARTMENT").toString());
						empleado.setEmployeeRFC(map.get("EMPLOYEE_RFC").toString());
						empleado.setEmployeeEmail(map.get("EMPLOYEE_EMAIL").toString());
						empleado.setEmployeePhone(map.get("EMPLOYEE_PHONE").toString());
						empleado.setEmployeeAddress(map.get("EMPLOYEE_ADDRESS").toString());
						empleado.setEmployeeDate((Date) map.get("EMPLOYEE_REGISTRATION_DATE"));
						empleado.setEmployeeStatus(Integer.parseInt(map.get("EMPLOYEE_STATUS").toString()));
						empleado.setSalary(Integer.parseInt(map.get("SALARY").toString()));

						break;
					}
				}

				LOGGER.info("Saliendo del If de buscar registro");

			} else {

				LOGGER.info("Entrando al else");

				empleado.setEmployeeNumber(Integer.parseInt(lista.get(0).get("EMPLOYEE_NUMBER").toString()));
				empleado.setEmployeeName(lista.get(0).get("EMPLOYEE_NAME").toString());
				empleado.setEmployeeDept(lista.get(0).get("EMPLOYEE_DEPARTMENT").toString());
				empleado.setEmployeeRFC(lista.get(0).get("EMPLOYEE_RFC").toString());
				empleado.setEmployeeEmail(lista.get(0).get("EMPLOYEE_EMAIL").toString());
				empleado.setEmployeePhone(lista.get(0).get("EMPLOYEE_PHONE").toString());
				empleado.setEmployeeAddress(lista.get(0).get("EMPLOYEE_ADDRESS").toString());
				empleado.setEmployeeDate((Date) lista.get(0).get("EMPLOYEE_REGISTRATION_DATE"));
				empleado.setEmployeeStatus(Integer.parseInt(lista.get(0).get("EMPLOYEE_STATUS").toString()));
				empleado.setSalary(Integer.parseInt(lista.get(0).get("SALARY").toString()));

			}

			LOGGER.info("saliendo del else");

		} catch (NoResultException e) {
			LOGGER.error("Ocurrio un problema al obtener el customer en BD");
			addAdvice("MNEO01317008");
		}

		LOGGER.info("Saliendo del metodo executeGetByName");

		return empleado;
	}

	@Override
	public List<EmployeesDTO> executeAllEmployees() {
		
		LOGGER.info("Entrando al metodo executeAllEmployees");
		
		List<EmployeesDTO> list1 = new LinkedList<EmployeesDTO>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		
		list2 = this.jdbcUtils.queryForList("getAllEmployees");
		
		for (Map<String, Object> map : list2) {
			
			EmployeesDTO empleado = new EmployeesDTO();

			empleado.setEmployeeNumber(Integer.parseInt(map.get("EMPLOYEE_NUMBER").toString()));
			empleado.setEmployeeName(map.get("EMPLOYEE_NAME").toString());
			empleado.setEmployeeDept(map.get("EMPLOYEE_DEPARTMENT").toString());
			empleado.setEmployeeRFC(map.get("EMPLOYEE_RFC").toString());
			empleado.setEmployeeEmail(map.get("EMPLOYEE_EMAIL").toString());
			empleado.setEmployeePhone(map.get("EMPLOYEE_PHONE").toString());
			empleado.setEmployeeAddress(map.get("EMPLOYEE_ADDRESS").toString());
			empleado.setEmployeeDate((Date) map.get("EMPLOYEE_REGISTRATION_DATE"));
			empleado.setEmployeeStatus(Integer.parseInt(map.get("EMPLOYEE_STATUS").toString()));
			empleado.setSalary(Integer.parseInt(map.get("SALARY").toString()));
			
			list1.add(empleado);
			
		}
		
		return list1;
	}
	
	private boolean validateRfc(String rfc){
		
		rfc = rfc.toUpperCase().trim();
		return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
		
	}
	
	private boolean validateEmail(String email) {
		
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		
		if (mather.find() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean validatePhone(String phone) {
		
		if (phone.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

}
