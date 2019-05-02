package com.evry.fs.payment.pms.srv.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Component("projectDetailsDaoMapper")
public class ProjectDetailsDaoMapper {

	public ProjectDetailsEntity fromModelToEntity(AddProjectRequest addProjectRequest) {
		ProjectDetails projectDetails = addProjectRequest.getProjectDetails();
		ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
		projectDetailsEntity.setProjectId(projectDetails.getProjectId());
		projectDetailsEntity.setProjectName(projectDetails.getProjectName());
		projectDetailsEntity.setProjectStatus(projectDetails.getProjectStatus());
		projectDetailsEntity.setEstimatedHrs(projectDetails.getEstimatedHrs());
		projectDetailsEntity.setLoggedHrs(projectDetails.getLoggedHrs());
		projectDetailsEntity.setRemainingHrs(projectDetails.getRemainingHrs());
		return projectDetailsEntity;
	}

	public AddProjectResponse addProjectResponse(boolean flag) {
		return AddProjectResponse.builder().flag(flag).build();
	}

	public GetProjectInfoResponse fromEntityToModel(ProjectDetailsEntity projectDetailsEntity) {
		ProjectDetails projectDetails = ProjectDetails.builder().projectId(projectDetailsEntity.getProjectId())
				.projectName(projectDetailsEntity.getProjectName())
				.projectStatus(projectDetailsEntity.getProjectStatus())
				.estimatedHrs(projectDetailsEntity.getEstimatedHrs()).loggedHrs(projectDetailsEntity.getLoggedHrs())
				.remainingHrs(projectDetailsEntity.getRemainingHrs()).build();
		GetProjectInfoResponse response = GetProjectInfoResponse.builder().projectDetails(projectDetails).build();
		return response;
	}

	public UpdateProjectResponse updateProjectResponse(boolean flag) {
		return UpdateProjectResponse.builder().flag(flag).build();
	}

	public GetAllProjectsResponse projectDetailsEntityListToProjectDetailsList(
			List<ProjectDetailsEntity> projectDetailsEntityList) {
		List<ProjectDetails> projectDetailsList = new ArrayList<ProjectDetails>();
		for (ProjectDetailsEntity ProjectDetailsEntity : projectDetailsEntityList) {
			projectDetailsList.add(fromEntityToModel2(ProjectDetailsEntity));
		}
		return GetAllProjectsResponse.builder().projectDetailsList(projectDetailsList).build();
	}

	public ProjectDetails fromEntityToModel2(ProjectDetailsEntity projectDetailsEntity) {
		return ProjectDetails.builder().projectId(projectDetailsEntity.getProjectId())
				.projectName(projectDetailsEntity.getProjectName())
				.projectStatus(projectDetailsEntity.getProjectStatus())
				.estimatedHrs(projectDetailsEntity.getEstimatedHrs()).loggedHrs(projectDetailsEntity.getLoggedHrs())
				.remainingHrs(projectDetailsEntity.getRemainingHrs()).build();
	}

	public DeleteProjectResponse deleteProjectResponse(boolean flag) {
		return DeleteProjectResponse.builder().flag(flag).build();
	}
}
