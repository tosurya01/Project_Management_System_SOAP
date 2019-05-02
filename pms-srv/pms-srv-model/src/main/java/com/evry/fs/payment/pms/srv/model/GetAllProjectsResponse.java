package com.evry.fs.payment.pms.srv.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetAllProjectsResponse {
	private List<ProjectDetails> projectDetailsList;
}
