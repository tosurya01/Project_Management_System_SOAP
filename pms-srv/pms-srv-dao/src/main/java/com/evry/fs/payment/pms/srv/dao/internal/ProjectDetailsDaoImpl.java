package com.evry.fs.payment.pms.srv.dao.internal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.dao.mapper.ProjectDetailsDaoMapper;
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

/**
 * 
 * @author venkata.kuppili
 *
 */
@Repository("projectDetailsDao")
public class ProjectDetailsDaoImpl implements ProjectDetailsDao {
	@PersistenceContext
	EntityManager entityManager;
	private final ProjectDetailsDaoMapper projectDetailsDaoMapper;

	/**
	 * 
	 * @param projectDetailsDaoMapper
	 */
	@Autowired
	public ProjectDetailsDaoImpl(final ProjectDetailsDaoMapper projectDetailsDaoMapper) {
		this.projectDetailsDaoMapper = projectDetailsDaoMapper;
	}

	@Transactional
	public AddProjectResponse addProject(AddProjectRequest addProjectRequest) {
		boolean flag = false;
		ProjectDetailsEntity projectDetailsEntity = projectDetailsDaoMapper.fromModelToEntity(addProjectRequest);
		if (!entityManager.contains(projectDetailsEntity)) {
			entityManager.persist(projectDetailsEntity);
			flag = true;
		}
		return projectDetailsDaoMapper.addProjectResponse(flag);
	}

	public GetProjectInfoResponse getProjectInfo(GetProjectInfoRequest getProjectInfoRequest) {
		ProjectDetailsEntity projectDetailsEntity = entityManager.find(ProjectDetailsEntity.class,
				getProjectInfoRequest.getProjectId());
		return projectDetailsDaoMapper.fromEntityToModel(projectDetailsEntity);
	}

	@Transactional
	public UpdateProjectResponse updateProject(UpdateProjectRequest updateProjectRequest) {
		boolean flag = false;
		ProjectDetailsEntity projectDetailsEntity = entityManager.find(ProjectDetailsEntity.class,
				updateProjectRequest.getProjectId());
		if (null != projectDetailsEntity) {
			projectDetailsEntity.setProjectName(updateProjectRequest.getProjectName());
			entityManager.merge(projectDetailsEntity);
			flag = true;
		}
		return projectDetailsDaoMapper.updateProjectResponse(flag);
	}

	public GetAllProjectsResponse getAllProjects() {
		Query query = entityManager.createQuery("FROM ProjectDetailsEntity");
		return projectDetailsDaoMapper.projectDetailsEntityListToProjectDetailsList(query.getResultList());
	}

	@Transactional
	public DeleteProjectResponse deleteProject(final DeleteProjectRequest deleteProjectRequest) {
		boolean flag = false;
		ProjectDetailsEntity projectDetailsEntity = entityManager.find(ProjectDetailsEntity.class,
				deleteProjectRequest.getProjectId());
		if (null != projectDetailsEntity) {
			entityManager.remove(projectDetailsEntity);
			flag = true;
		}
		return projectDetailsDaoMapper.deleteProjectResponse(flag);
	}

}
