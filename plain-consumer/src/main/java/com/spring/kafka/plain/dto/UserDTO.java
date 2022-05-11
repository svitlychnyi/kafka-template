package com.spring.kafka.plain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String eventId;
	private String eventType;
	private long eventTimestamp;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String city;
	private String country;
	private long createdOn;
	private long updatedOn;
}
