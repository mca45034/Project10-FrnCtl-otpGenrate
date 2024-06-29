package com.rays.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;
import com.rays.form.CodeForm;
import com.rays.form.UserForm;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value = "Code")
public class CodeCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt>{
	
	@PostMapping("CodeOTP")
	public ORSResponse otpLogin(@RequestBody @Valid CodeForm form, BindingResult bindingResult, HttpSession session,
			HttpServletRequest request) throws Exception {
		System.out.println("))))))))))))000000000000000000000000000000000000000000");
		ORSResponse res = validate(bindingResult);

		//session = request.getSession(true);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.findByOTP(form.getCodeId());
		System.out.println(dto+"+++++++++++++++++++++++++++++++++++++++++++++++++++");
		if (dto == null) {
			System.out.println("dto == null ");
			res.setSuccess(false);
			res.addMessage("Please Enter Correct Code..");
			return res;
		} else {
			UserContext context = new UserContext(dto);

			

//			 session.setAttribute("userContext", context); 				

	session.setAttribute("test", dto.getFirstName());
	System.out.println("login id => " + session.getId());

	res.setSuccess(true);
	session.setAttribute("user", dto.getFirstName());
	res.addData(dto);
//			res.addResult("jsessionid", session.getId());
	res.addResult("loginId", dto.getLoginId());
	res.addResult("role", dto.getRoleName());
	res.addResult("fname", dto.getFirstName());
	res.addResult("lname", dto.getLastName());

	/* System.out.println("jsessionid " + session.getId()); */
	System.out.println("Before calling userDetail authenticate");
			return res;

		}

		
	}
	
	
}
	

