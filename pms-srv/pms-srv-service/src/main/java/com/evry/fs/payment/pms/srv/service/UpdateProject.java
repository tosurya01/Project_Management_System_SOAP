package com.evry.fs.payment.pms.srv.service;

import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

public interface UpdateProject {
	public UpdateProjectResponse updateProject(final UpdateProjectRequest updateProjectRequest);
}
