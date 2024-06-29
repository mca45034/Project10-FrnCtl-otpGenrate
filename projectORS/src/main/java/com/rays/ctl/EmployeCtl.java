package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.EmployeDTO;
import com.rays.form.EmployeForm;
import com.rays.service.EmployeServiceInt;
 
@RestController
@RequestMapping(value = "Emp")
public class EmployeCtl extends BaseCtl<EmployeForm, EmployeDTO, EmployeServiceInt> {
	@Autowired
	private EmployeServiceInt employeService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		EmployeDTO dto = new EmployeDTO();

		List<DropdownList> list = employeService.search(dto, userContext);
		res.addResult("employeList", list);
		return res;
	}

}
