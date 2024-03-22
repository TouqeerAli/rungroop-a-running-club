package com.rungroup.web.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDTO {

	private Long id;
	private String title;
	private String photoUrl;
	private String content;
	private LocalDateTime createdOn;
	private LocalDateTime updateOn;
}
