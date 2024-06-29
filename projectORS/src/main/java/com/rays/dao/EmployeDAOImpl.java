package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.EmployeDTO;
@Repository
public class EmployeDAOImpl extends BaseDAOImpl<EmployeDTO> implements EmployeDAOInt {

	@Override
	protected List<Predicate> getWhereClause(EmployeDTO dto, CriteriaBuilder builder, Root<EmployeDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		if (!isEmptyString(dto.getFirstName())) {

			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}
		if (!isEmptyString(dto.getLastName())) {

			whereCondition.add(builder.like(qRoot.get("lastName"), dto.getLastName() + "%"));
		}
		if (!isEmptyString(dto.getEmail())) {

			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
		}
		if (!isEmptyString(dto.getDepartment())) {

			whereCondition.add(builder.like(qRoot.get("department"), dto.getDepartment() + "%"));
		}
		if (!isEmptyString(dto.getAddress())) {

			whereCondition.add(builder.like(qRoot.get("address"), dto.getAddress() + "%"));
		}
		
		
		
		return whereCondition;
	}

	@Override
	public Class<EmployeDTO> getDTOClass() {
		return EmployeDTO.class;
	}

}
