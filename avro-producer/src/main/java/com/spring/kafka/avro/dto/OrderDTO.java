package com.spring.kafka.avro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private String eventId;
	private String eventType;
	private long eventTimestamp;
	private String id;
	private String userId;
	private String product;
	private Double price;
	private long createdOn;
	private long updatedOn;
}
