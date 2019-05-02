package com.evry.fs.payment.pms.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsRequest;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.service.GetAllProjects;
@Component("getAllProjects")
public class GetAllProjectsImpl implements GetAllProjects {
	@Autowired
	ProjectDetailsDao projectDetailsDao;
	public GetAllProjectsResponse getAllProjects() {
		return projectDetailsDao.getAllProjects();
	}

}
