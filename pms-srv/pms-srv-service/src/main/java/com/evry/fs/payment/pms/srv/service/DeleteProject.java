package com.evry.fs.payment.pms.srv.service;

import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;

public interface DeleteProject {
	/**
	 * 
	 * @param addProjectRequest
	 * @return
	 */
	public DeleteProjectResponse deleteProject(final DeleteProjectRequest deleteProjectsRequest);
}
