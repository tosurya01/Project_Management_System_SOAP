package com.evry.fs.payment.pms.srv.service;

import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;

public interface AddProject {
	/**
	 * 
	 * @param addProjectRequest
	 * @return
	 */
	public AddProjectResponse addProject(final AddProjectRequest addProjectRequest);
}
