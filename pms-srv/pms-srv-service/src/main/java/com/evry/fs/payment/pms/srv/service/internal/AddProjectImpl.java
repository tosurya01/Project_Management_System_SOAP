package com.evry.fs.payment.pms.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.service.AddProject;
@Component("addProject")
public class AddProjectImpl implements AddProject {
	@Autowired
	ProjectDetailsDao projectDetailsDao;
	public AddProjectResponse addProject(AddProjectRequest addProjectRequest) {
		return projectDetailsDao.addProject(addProjectRequest);
	}

}
