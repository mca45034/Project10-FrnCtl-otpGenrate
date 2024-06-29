package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EmployeDTO;
import com.rays.dto.StudentDTO;

public class EmployeForm extends BaseForm{
	@NotEmpty(message = "please enter firstname")
	private String firstName;
	@NotEmpty(message = "please enter lastname")
	private String lastName;
	@NotEmpty(message= "please enter email")
	@Email
	private String email;
	@NotEmpty(message= "please enter department")
	private String department;
	@NotEmpty(message= "please enter address")
	private String address;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public BaseDTO getDto() {

		EmployeDTO dto = initDTO(new EmployeDTO());
	
	dto.setFirstName(firstName);
	dto.setLastName(lastName);
	dto.setEmail(email);
	dto.setDepartment(department);
	dto.setAddress(address);
	return dto;
	
}

}
