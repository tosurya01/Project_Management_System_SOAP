package com.evry.fs.payment.pms.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;
import com.evry.fs.payment.pms.srv.service.UpdateProject;
@Component("updateProject")
public class UpdateProjectImpl implements UpdateProject {
	@Autowired
	ProjectDetailsDao projectDetailsDao;
	public UpdateProjectResponse updateProject(UpdateProjectRequest updateProjectRequest) {
		return projectDetailsDao.updateProject(updateProjectRequest);
	}

}
