package com.stamp.cms.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stamp.cms.model.ApiResponseMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="HelloController", description="Çï·Î")
public class HelloController {
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ApiOperation(value="Hello, World API", notes="Å×½ºÆ®")
	public ResponseEntity<ApiResponseMessage> HelloWorld() {
		ApiResponseMessage message = ApiResponseMessage.builder()
				.status("Authentification Error")
				.message("Hello, World")
				.errorCode("")
				.errorMessage("")
				.build();
		return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.UNAUTHORIZED);
	}
}
