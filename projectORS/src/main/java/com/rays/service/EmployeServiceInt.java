package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.common.BaseServiceInt;
import com.rays.dto.EmployeDTO;

@Service
@Transactional
public interface EmployeServiceInt extends BaseServiceInt<EmployeDTO>{

}
