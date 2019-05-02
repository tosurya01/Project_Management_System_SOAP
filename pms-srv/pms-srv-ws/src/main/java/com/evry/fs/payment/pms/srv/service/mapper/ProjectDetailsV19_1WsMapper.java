package com.evry.fs.payment.pms.srv.service.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.AddProjectRequestType;
import com.evry.fs.payment.pms.AddProjectResponseType;
import com.evry.fs.payment.pms.DeleteProjectRequestType;
import com.evry.fs.payment.pms.DeleteProjectResponseType;
import com.evry.fs.payment.pms.GetAllProjectsRequestType;
import com.evry.fs.payment.pms.GetAllProjectsResponseType;
import com.evry.fs.payment.pms.GetProjectInfoRequestType;
import com.evry.fs.payment.pms.GetProjectInfoResponseType;
import com.evry.fs.payment.pms.ProjectDetailsType;
import com.evry.fs.payment.pms.UpdateProjectRequestType;
import com.evry.fs.payment.pms.UpdateProjectResponseType;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsRequest;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Component("projectDetailsV19_1WsMapper")
public class ProjectDetailsV19_1WsMapper {

	public AddProjectRequest fromWsToDomain(AddProjectRequestType addProjectRequestType) {
		ProjectDetailsType projectDetailsType = addProjectRequestType.getProjectDetailsType();
		return AddProjectRequest.builder().projectDetails(projectDetailsTypeToProjectDetails(projectDetailsType))
				.build();
	}

	private ProjectDetails projectDetailsTypeToProjectDetails(ProjectDetailsType projectDetailsType) {
		return ProjectDetails.builder().projectId(projectDetailsType.getProjectId())
				.projectName(projectDetailsType.getProjectName()).projectStatus(projectDetailsType.getProjectStatus())
				.estimatedHrs(projectDetailsType.getEstimatedHrs()).loggedHrs(projectDetailsType.getLoggedHrs())
				.remainingHrs(projectDetailsType.getRemainingHrs()).build();
	}

	public AddProjectResponseType fromDomainToWs(AddProjectResponse addProjectResponse) {
		AddProjectResponseType addProjectResponseType = new AddProjectResponseType();
		addProjectResponseType.setFlag(addProjectResponse.isFlag());
		return addProjectResponseType;
	}

	public GetProjectInfoRequest fromWsToDomain(GetProjectInfoRequestType getProjectInfoRequestType) {

		return GetProjectInfoRequest.builder().projectId(getProjectInfoRequestType.getProjectId()).build();
	}

	public GetProjectInfoResponseType fromDomainToWs(GetProjectInfoResponse getProjectInfoResponse) {
		GetProjectInfoResponseType getProjectInfoResponseType = new GetProjectInfoResponseType();
		getProjectInfoResponseType
				.setProjectDetailsType(projectDetailsToProjectDetailsType(getProjectInfoResponse.getProjectDetails()));
		return getProjectInfoResponseType;
	}

	private ProjectDetailsType projectDetailsToProjectDetailsType(ProjectDetails projectDetails) {
		ProjectDetailsType projectDetailsType = new ProjectDetailsType();
		projectDetailsType.setProjectId(projectDetails.getProjectId());
		projectDetailsType.setProjectName(projectDetails.getProjectName());
		projectDetailsType.setProjectStatus(projectDetails.getProjectStatus());
		projectDetailsType.setEstimatedHrs(projectDetails.getEstimatedHrs());
		projectDetailsType.setLoggedHrs(projectDetails.getLoggedHrs());
		projectDetailsType.setRemainingHrs(projectDetails.getRemainingHrs());
		return projectDetailsType;
	}

	public UpdateProjectRequest fromWsToDomain(UpdateProjectRequestType updateProjectRequestType) {
		return UpdateProjectRequest.builder().projectId(updateProjectRequestType.getProjectId())
				.projectName(updateProjectRequestType.getProjectName()).build();
	}

	public UpdateProjectResponseType fromDomainToWs(UpdateProjectResponse updateProjectResponse) {
		UpdateProjectResponseType updateProjectResponseType = new UpdateProjectResponseType();
		updateProjectResponseType.setFlag(updateProjectResponse.isFlag());
		return updateProjectResponseType;
	}

	public DeleteProjectRequest fromWsToDomain(DeleteProjectRequestType deleteProjectRequestType) {

		return DeleteProjectRequest.builder().projectId(deleteProjectRequestType.getProjectId()).build();
	}

	public DeleteProjectResponseType fromDomainToWs(DeleteProjectResponse deleteProjectResponse) {
		DeleteProjectResponseType deleteProjectResponseType = new DeleteProjectResponseType();
		deleteProjectResponseType.setFlag(deleteProjectResponse.isFlag());
		return deleteProjectResponseType;
	}

//	public GetAllProjectsRequest fromWsToDomain(GetAllProjectsRequestType getAllProjectsRequestType) {
//		return null;
//	}

	public GetAllProjectsResponseType fromDomainToWs(GetAllProjectsResponse getAllProjectsResponse) {
		List<ProjectDetails> projectDetailsList = getAllProjectsResponse.getProjectDetailsList();
		GetAllProjectsResponseType getAllProjectsResponseType = new GetAllProjectsResponseType();
		List<ProjectDetailsType> ProjectDetailsTypeList = getAllProjectsResponseType.getProjectDetailsType();
		for (ProjectDetails projectDetails : projectDetailsList) {
			ProjectDetailsTypeList.add(projectDetailsToProjectDetailsType(projectDetails));
		}

		return getAllProjectsResponseType;
	}
}
