package com.bbva.makz;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.makz.dto.employees.EmployeesDTO;
import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractMAKZT00101MXTransaction extends AbstractTransaction {

	public AbstractMAKZT00101MXTransaction(){
	}


	/**
	 * Return value for input parameter entrada
	 */
	protected String getEntrada(){
		return (String)this.getParameter("entrada");
	}

	/**
	 * Return value for input parameter employeeIn
	 */
	protected EmployeesDTO getEmployeein(){
		return (EmployeesDTO)this.getParameter("employeeIn");
	}

	/**
	 * Set value for EmployeesDTO output parameter employeeOut
	 */
	protected void setEmployeeout(final EmployeesDTO field){
		this.addParameter("employeeOut", field);
	}

	/**
	 * Set value for List<EmployeesDTO> output parameter listDTO
	 */
	protected void setListdto(final List<EmployeesDTO> field){
		this.addParameter("listDTO", field);
	}
}
