package com.evry.fs.payment.pms.srv.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddProjectRequest {
	private ProjectDetails projectDetails;
}
