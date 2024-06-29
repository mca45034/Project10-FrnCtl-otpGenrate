package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.EmployeDAOInt;
import com.rays.dto.EmployeDTO;

@Service
@Transactional
public class EmployeServiceImpl extends BaseServiceImpl<EmployeDTO, EmployeDAOInt> implements EmployeServiceInt{
	

}
