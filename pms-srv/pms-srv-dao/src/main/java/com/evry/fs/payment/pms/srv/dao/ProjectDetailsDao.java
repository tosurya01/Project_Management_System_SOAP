package com.evry.fs.payment.pms.srv.dao;

import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsRequest;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

public interface ProjectDetailsDao {
	/**
	 * 
	 * @param addProjectRequest
	 * @return
	 */
	public AddProjectResponse addProject(final AddProjectRequest addProjectRequest);

	/**
	 * 
	 * @param getProjectInfoRequest
	 * @return
	 */
	public GetProjectInfoResponse getProjectInfo(final GetProjectInfoRequest getProjectInfoRequest);

	/**
	 * 
	 * @param updateProjectRequest
	 * @return
	 */
	public UpdateProjectResponse updateProject(final UpdateProjectRequest updateProjectRequest);

	/**
	 * 
	 * @param getAllProjectsRequest
	 * @return
	 */
	public GetAllProjectsResponse getAllProjects();

	/**
	 * 
	 * @param deleteProjectsRequest
	 * @return
	 */
	public DeleteProjectResponse deleteProject(final DeleteProjectRequest deleteProjectsRequest);
}
