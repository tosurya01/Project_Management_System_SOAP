package com.evry.fs.payment.pms.srv.service.mapper;

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

import com.evry.fs.payment.pms.AddProjectRequestType;
import com.evry.fs.payment.pms.AddProjectResponseType;
import com.evry.fs.payment.pms.DeleteProjectRequestType;
import com.evry.fs.payment.pms.DeleteProjectResponseType;
import com.evry.fs.payment.pms.GetAllProjectsResponseType;
import com.evry.fs.payment.pms.GetProjectInfoRequestType;
import com.evry.fs.payment.pms.ProjectDetailsType;
import com.evry.fs.payment.pms.UpdateProjectRequestType;
import com.evry.fs.payment.pms.UpdateProjectResponseType;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDetailsV19_1WsMapperTest {
	@InjectMocks
	private static ProjectDetailsV19_1WsMapper mapper;

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testFromWsToDomainAddProjectRequestType() {
		AddProjectRequestType addProjectRequestType = new AddProjectRequestType();
		ProjectDetailsType projectDetailsType = new ProjectDetailsType();
		projectDetailsType.setProjectId(PROJECT_ID);
		projectDetailsType.setProjectName(PROJECT_NAME);
		projectDetailsType.setProjectStatus(PROJECT_STATUS);
		projectDetailsType.setEstimatedHrs(ESTIMATED_HRS);
		projectDetailsType.setLoggedHrs(LOGGED_HRS);
		projectDetailsType.setRemainingHrs(REMAINING_HRS);
		addProjectRequestType.setProjectDetailsType(projectDetailsType);
		AddProjectRequest addProjectRequest = mapper.fromWsToDomain(addProjectRequestType);
		ProjectDetails projectDetails = addProjectRequest.getProjectDetails();
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testFromDomainToWsAddProjectResponse() {
		AddProjectResponseType addProjectResponseType = mapper
				.fromDomainToWs(AddProjectResponse.builder().flag(TRUE).build());
		assertThat(addProjectResponseType.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromWsToDomainGetProjectInfoRequestType() {
		GetProjectInfoRequestType getProjectInfoRequestType = new GetProjectInfoRequestType();
		getProjectInfoRequestType.setProjectId(PROJECT_ID);
		GetProjectInfoRequest getProjectInfoRequest = mapper.fromWsToDomain(getProjectInfoRequestType);
		assertThat(getProjectInfoRequest.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testFromDomainToWsGetProjectInfoResponse() {
		AddProjectResponseType addProjectResponseType = mapper
				.fromDomainToWs(AddProjectResponse.builder().flag(TRUE).build());
		assertThat(addProjectResponseType.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromWsToDomainUpdateProjectRequestType() {
		UpdateProjectRequestType updateProjectRequestType = new UpdateProjectRequestType();
		updateProjectRequestType.setProjectId(PROJECT_ID);
		updateProjectRequestType.setProjectName(PROJECT_NAME);
		UpdateProjectRequest updateProjectRequest = mapper.fromWsToDomain(updateProjectRequestType);
		assertThat(updateProjectRequest.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(updateProjectRequest.getProjectName(), is(equalTo(PROJECT_NAME)));
	}

	@Test
	public void testFromDomainToWsUpdateProjectResponse() {
		UpdateProjectResponseType updateProjectResponseType = mapper
				.fromDomainToWs(UpdateProjectResponse.builder().flag(TRUE).build());
		assertThat(updateProjectResponseType.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromWsToDomainDeleteProjectRequestType() {
		DeleteProjectRequestType deleteProjectRequestType = new DeleteProjectRequestType();
		deleteProjectRequestType.setProjectId(PROJECT_ID);
		DeleteProjectRequest deleteProjectRequest = mapper.fromWsToDomain(deleteProjectRequestType);
		assertThat(deleteProjectRequest.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testFromDomainToWsDeleteProjectResponse() {
		DeleteProjectResponseType deleteProjectResponseType = mapper
				.fromDomainToWs(DeleteProjectResponse.builder().flag(TRUE).build());
		assertThat(deleteProjectResponseType.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromDomainToWsGetAllProjectsResponse() {
		List<ProjectDetails> projectDetailsList = new ArrayList<ProjectDetails>();
		projectDetailsList.add(
				ProjectDetails.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
						.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build());
		GetAllProjectsResponseType getAllProjectsResponseType = mapper
				.fromDomainToWs(GetAllProjectsResponse.builder().projectDetailsList(projectDetailsList).build());
		List<ProjectDetailsType> ProjectDetailsTypeList = getAllProjectsResponseType.getProjectDetailsType();
		ProjectDetailsType projectDetails = ProjectDetailsTypeList.get(0);
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

}
