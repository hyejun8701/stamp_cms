package com.stamp.cms.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class ApiResponseMessage {
	// HttpStatus
    private String status;
    // Http Default Message
    private String message;
    // Error Message to USER
    private String errorMessage;
    // Error Code
    private String errorCode;
}
