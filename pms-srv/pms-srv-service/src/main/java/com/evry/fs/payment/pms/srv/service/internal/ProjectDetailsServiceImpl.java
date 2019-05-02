package com.evry.fs.payment.pms.srv.service.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;
import com.evry.fs.payment.pms.srv.service.ProjectDetailsService;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Service("projectDetailsService")
public class ProjectDetailsServiceImpl {//implements ProjectDetailsService {
	@Autowired
	ProjectDetailsDao projectDetailsDao;

//	public boolean addProject(ProjectDetails projectDetails) {
//		return projectDetailsDao.addProject(projectDetails);
//	}
//
//	public ProjectDetails getProjectInfo(int projectId) {
//		return projectDetailsDao.getProjectInfo(projectId);
//	}
//
//	public boolean updateProject(int projectId, String projectName) {
//		return projectDetailsDao.updateProject(projectId, projectName);
//	}
//
//	public List<ProjectDetails> getAllProjects() {
//		return projectDetailsDao.getAllProjects();
//	}
//
//	public boolean deleteProject(int projectId) {
//		return projectDetailsDao.deleteProject(projectId);
//	}

}
