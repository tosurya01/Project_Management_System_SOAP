package com.evry.fs.payment.pms.srv.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.fs.payment.pms.AddProjectRequestType;
import com.evry.fs.payment.pms.AddProjectResponseType;
import com.evry.fs.payment.pms.DeleteProjectRequestType;
import com.evry.fs.payment.pms.DeleteProjectResponseType;
import com.evry.fs.payment.pms.GetAllProjectsRequestType;
import com.evry.fs.payment.pms.GetAllProjectsResponseType;
import com.evry.fs.payment.pms.GetProjectInfoRequestType;
import com.evry.fs.payment.pms.GetProjectInfoResponseType;
import com.evry.fs.payment.pms.UpdateProjectRequestType;
import com.evry.fs.payment.pms.UpdateProjectResponseType;
import com.evry.fs.payment.pms.services.projectservice_v19_1.ProjectServiceV191;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.service.AddProject;
import com.evry.fs.payment.pms.srv.service.DeleteProject;
import com.evry.fs.payment.pms.srv.service.GetAllProjects;
import com.evry.fs.payment.pms.srv.service.GetProjectInfo;
import com.evry.fs.payment.pms.srv.service.UpdateProject;
import com.evry.fs.payment.pms.srv.service.mapper.ProjectDetailsV19_1WsMapper;

@Service("projectServiceV191")
public class ProjectServiceV191Impl implements ProjectServiceV191 {
	private final AddProject addProject;
	private final GetProjectInfo getProjectInfo;
	private final UpdateProject updateProject;
	private final DeleteProject deleteProject;
	private final GetAllProjects getAllProjects;
	private final ProjectDetailsV19_1WsMapper projectDetailsV19_1WsMapper;

	@Autowired
	public ProjectServiceV191Impl(AddProject addProject, GetProjectInfo getProjectInfo, UpdateProject updateProject,
			DeleteProject deleteProject, GetAllProjects getAllProjects,
			ProjectDetailsV19_1WsMapper projectDetailsV19_1WsMapper) {
		this.addProject = addProject;
		this.getProjectInfo = getProjectInfo;
		this.updateProject = updateProject;
		this.deleteProject = deleteProject;
		this.getAllProjects = getAllProjects;
		this.projectDetailsV19_1WsMapper = projectDetailsV19_1WsMapper;
	}

	@Override
	public AddProjectResponseType addProject(AddProjectRequestType addProjectRequestType) {
		AddProjectRequest addProjectRequest = projectDetailsV19_1WsMapper.fromWsToDomain(addProjectRequestType);
		AddProjectResponse addProjectResponse = addProject.addProject(addProjectRequest);
		return projectDetailsV19_1WsMapper.fromDomainToWs(addProjectResponse);
	}

	@Override
	public GetProjectInfoResponseType getProjectInfo(GetProjectInfoRequestType getProjectInfoRequestType) {

		GetProjectInfoResponse getProjectInfoResponse = getProjectInfo
				.getProjectInfo(projectDetailsV19_1WsMapper.fromWsToDomain(getProjectInfoRequestType));
		GetProjectInfoResponseType resp = projectDetailsV19_1WsMapper.fromDomainToWs(getProjectInfoResponse);
		return resp;
	}

	@Override
	public UpdateProjectResponseType updateProject(UpdateProjectRequestType updateProjectRequestType) {
		return projectDetailsV19_1WsMapper.fromDomainToWs(
				updateProject.updateProject(projectDetailsV19_1WsMapper.fromWsToDomain(updateProjectRequestType)));
	}

	@Override
	public DeleteProjectResponseType deleteProject(DeleteProjectRequestType deleteProjectRequestType) {
		return projectDetailsV19_1WsMapper.fromDomainToWs(
				deleteProject.deleteProject(projectDetailsV19_1WsMapper.fromWsToDomain(deleteProjectRequestType)));
	}

	@Override
	public GetAllProjectsResponseType getAllProjects(GetAllProjectsRequestType getAllProjectsRequestType) {
		GetAllProjectsResponse getAllProjectsResponse = getAllProjects.getAllProjects();
		return projectDetailsV19_1WsMapper.fromDomainToWs(getAllProjectsResponse);
	}

}
