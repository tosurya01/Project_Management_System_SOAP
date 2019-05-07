package com.evry.fs.payment.pms.srv.dao.mapper;

import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.REMAINING_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.TRUE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDetailsDaoMapperTest {
	@InjectMocks
	private static ProjectDetailsDaoMapper mapper;

	@Test
	public void testFromModelToEntity() {
		ProjectDetailsEntity projectDetailsEntity = mapper.fromModelToEntity(AddProjectRequest.builder()
				.projectDetails(ProjectDetails.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME)
						.projectStatus(PROJECT_STATUS).estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS)
						.remainingHrs(REMAINING_HRS).build())
				.build());
		assertThat(projectDetailsEntity.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetailsEntity.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetailsEntity.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetailsEntity.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetailsEntity.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetailsEntity.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testAddProjectResponse() {
		AddProjectResponse addProjectResponse = mapper.addProjectResponse(TRUE);
		assertThat(addProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromEntityToModel() {
		ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
		projectDetailsEntity.setProjectId(PROJECT_ID);
		projectDetailsEntity.setProjectName(PROJECT_NAME);
		projectDetailsEntity.setProjectStatus(PROJECT_STATUS);
		projectDetailsEntity.setEstimatedHrs(ESTIMATED_HRS);
		projectDetailsEntity.setLoggedHrs(LOGGED_HRS);
		projectDetailsEntity.setRemainingHrs(REMAINING_HRS);
		GetProjectInfoResponse getProjectInfoResponse = mapper.fromEntityToModel(projectDetailsEntity);
		ProjectDetails projectDetails = getProjectInfoResponse.getProjectDetails();
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testUpdateProjectResponse() {
		UpdateProjectResponse updateProjectResponse = mapper.updateProjectResponse(TRUE);
		assertThat(updateProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testProjectDetailsEntityListToProjectDetailsList() {
		List<ProjectDetailsEntity> projectDetailsEntityList = new ArrayList<ProjectDetailsEntity>();
		ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
		projectDetailsEntity.setProjectId(PROJECT_ID);
		projectDetailsEntity.setProjectName(PROJECT_NAME);
		projectDetailsEntity.setProjectStatus(PROJECT_STATUS);
		projectDetailsEntity.setEstimatedHrs(ESTIMATED_HRS);
		projectDetailsEntity.setLoggedHrs(LOGGED_HRS);
		projectDetailsEntity.setRemainingHrs(REMAINING_HRS);
		projectDetailsEntityList.add(projectDetailsEntity);
		GetAllProjectsResponse getAllProjectsResponse = mapper
				.projectDetailsEntityListToProjectDetailsList(projectDetailsEntityList);
		ProjectDetails projectDetails = getAllProjectsResponse.getProjectDetailsList().get(0);
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testFromEntityToModel2() {
		ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
		projectDetailsEntity.setProjectId(PROJECT_ID);
		projectDetailsEntity.setProjectName(PROJECT_NAME);
		projectDetailsEntity.setProjectStatus(PROJECT_STATUS);
		projectDetailsEntity.setEstimatedHrs(ESTIMATED_HRS);
		projectDetailsEntity.setLoggedHrs(LOGGED_HRS);
		projectDetailsEntity.setRemainingHrs(REMAINING_HRS);
		ProjectDetails projectDetails = mapper.fromEntityToModel2(projectDetailsEntity);
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testDeleteProjectResponse() {

		DeleteProjectResponse deleteProjectResponse = mapper.deleteProjectResponse(TRUE);
		assertThat(deleteProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

}
