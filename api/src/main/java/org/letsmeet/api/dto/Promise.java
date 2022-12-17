package org.letsmeet.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Promise {
	private int id;
	private String name;
	private String date;
	private String location;
	private String description;
	private String groupId;
}
