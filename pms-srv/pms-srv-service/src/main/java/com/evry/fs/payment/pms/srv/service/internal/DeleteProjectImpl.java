package com.evry.fs.payment.pms.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.service.DeleteProject;
@Component("deleteProject")
public class DeleteProjectImpl implements DeleteProject {
	@Autowired
	ProjectDetailsDao projectDetailsDao;
	public DeleteProjectResponse deleteProject(DeleteProjectRequest deleteProjectsRequest) {
		return projectDetailsDao.deleteProject(deleteProjectsRequest);
	}

}
