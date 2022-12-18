package org.letsmeet.api.dto;

import lombok.Getter;

@Getter
public class PromiseRequest {
	private String name;
	private String date;
	private String location;
	private String description;
	private String groupId;
}
