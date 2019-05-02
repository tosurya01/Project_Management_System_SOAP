package com.evry.fs.payment.pms.srv.service;

import java.util.List;

import com.evry.fs.payment.pms.srv.model.ProjectDetails;

/**
 * 
 * @author venkata.kuppili
 *
 */
public interface ProjectDetailsService {
	/**
	 * 
	 * @param projectDetails
	 * @return
	 */
	public boolean addProject(ProjectDetails projectDetails);

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectDetails getProjectInfo(int projectId);

	/**
	 * 
	 * @param projectId
	 * @param projectName
	 * @return
	 */
	public boolean updateProject(int projectId, String projectName);

	/**
	 * 
	 * @return
	 */
	public List<ProjectDetails> getAllProjects();

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public boolean deleteProject(int projectId);
}
