package com.evry.fs.payment.pms.srv.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author venkata.kuppili
 *
 */

@Setter
@Getter

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	private String address;
	@ManyToOne(optional = false)
	@JoinColumn(name = "PROJECT_ID")
	private ProjectDetailsEntity projectDetailsEntity;

}
