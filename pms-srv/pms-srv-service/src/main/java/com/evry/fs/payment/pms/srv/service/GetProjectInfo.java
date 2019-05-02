package com.evry.fs.payment.pms.srv.service;

import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;

public interface GetProjectInfo {
	/**
	 * 
	 * @param getProjectInfoRequest
	 * @return
	 */
	public GetProjectInfoResponse getProjectInfo(final GetProjectInfoRequest getProjectInfoRequest);
}
