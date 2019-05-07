package com.evry.fs.payment.pms.srv.dao;

import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.REMAINING_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.TRUE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.FALSE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.evry.fs.payment.pms.srv.dao.mapper.ProjectDetailsDaoMapper;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/testApplicationContext.xml" })
public class ProjectDetailsDaoTest {
	@Inject
	ProjectDetailsDao projectDetailsDao;
	@PersistenceContext
	EntityManager entityManager;
	@Inject
	ProjectDetailsDaoMapper projectDetailsDaoMapper;

	@Test
	public void testAddProject() {
//		AddProjectResponse addProjectResponse = projectDetailsDao.addProject(AddProjectRequest.builder()
//				.projectDetails(ProjectDetails.builder().projectId(8975).projectName(PROJECT_NAME)
//						.projectStatus(PROJECT_STATUS).estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS)
//						.remainingHrs(REMAINING_HRS).build())
//				.build());
//		assertThat(addProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testGetProjectInfo() {
		GetProjectInfoResponse getProjectInfoResponse = projectDetailsDao
				.getProjectInfo(GetProjectInfoRequest.builder().projectId(PROJECT_ID).build());
		ProjectDetails projectDetails = getProjectInfoResponse.getProjectDetails();
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testUpdateProject() {
		UpdateProjectResponse updateProjectResponse = projectDetailsDao
				.updateProject(UpdateProjectRequest.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).build());
		assertThat(updateProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testGetAllProjects() {
		GetAllProjectsResponse getAllProjectsResponse = projectDetailsDao.getAllProjects();
		List<ProjectDetails> ProjectDetailsList = getAllProjectsResponse.getProjectDetailsList();
		assertThat(ProjectDetailsList.isEmpty(), is(equalTo(FALSE)));
	}

	@Test
	public void testDeleteProject() {
		DeleteProjectResponse deleteProjectResponse = projectDetailsDao
				.deleteProject(DeleteProjectRequest.builder().projectId(9898).build());
		assertThat(deleteProjectResponse.isFlag(), is(equalTo(FALSE)));
	}

}
