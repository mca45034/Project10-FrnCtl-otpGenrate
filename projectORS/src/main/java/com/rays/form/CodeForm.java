package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;

public class CodeForm extends BaseForm{
	
	@NotEmpty(message = "please enter Code")
	public String codeId;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	

	
	

}
