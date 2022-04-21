package com.bbva.makz.dto.employees;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The EmployeesDTO class...
 */
public class EmployeesDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;
	
	private int employeeNumber;
	private String employeeName;
	private String employeeDept;
	private String employeeRFC;
	private String employeeEmail;
	private String employeePhone;
	private String employeeAddress;
	private Date employeeDate;
	private int employeeStatus;
	private int salary;
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeDept() {
		return employeeDept;
	}
	
	public void setEmployeeDept(String employeeDept) {
		this.employeeDept = employeeDept;
	}
	
	public String getEmployeeRFC() {
		return employeeRFC;
	}
	
	public void setEmployeeRFC(String employeeRFC) {
		this.employeeRFC = employeeRFC;
	}
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	public String getEmployeePhone() {
		return employeePhone;
	}
	
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	public Date getEmployeeDate() {
		return employeeDate;
	}
	
	public void setEmployeeDate(Date employeeDate) {
		this.employeeDate = employeeDate;
	}
	
	public int getEmployeeStatus() {
		return employeeStatus;
	}
	
	public void setEmployeeStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.employeeNumber)
				.append(this.employeeName)
				.append(this.employeeDept)
				.append(this.employeeRFC)
				.append(this.employeeEmail)
				.append(this.employeePhone)
				.append(this.employeeAddress)
				.append(this.employeeDate)
				.append(this.employeeStatus)
				.append(this.salary)
				.toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EmployeesDTO rhs = (EmployeesDTO) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(employeeNumber, rhs.employeeNumber)
				.append(employeeName, rhs.employeeName)
				.append(employeeDept, rhs.employeeDept)
				.append(employeeRFC, rhs.employeeRFC)
				.append(employeeEmail, rhs.employeeEmail)
				.append(employeePhone, rhs.employeePhone)
				.append(employeeAddress, rhs.employeeAddress)
				.append(employeeDate, rhs.employeeDate)
				.append(employeeStatus, rhs.employeeStatus)
				.append(salary, rhs.salary)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("employeeNumber", employeeNumber)
				.append("employeeName", employeeName)
				.append("employeeDept", employeeDept)
				.append("employeeRFC", employeeRFC)
				.append("employeeEmail", employeeEmail)
				.append("employeePhone", employeePhone)
				.append("employeeAddress", employeeAddress)
				.append("employeeDate", employeeDate)
				.append("employeeStatus", employeeStatus)
				.append("salary", salary)
				.toString();
	}
	
	
}
