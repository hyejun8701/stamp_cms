package com.stamp.cms.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stamp.cms.model.ApiResponseMessage;
import com.stamp.cms.model.User;
import com.stamp.cms.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/user")
@Api(value = "UserController", description = "사용자 관련 API", basePath = "/user")
public class UserController {
	
	@Autowired
    UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation(value = "사용자 목록 조회", notes = "사용자 목록을 조회하는 API.")
	public List<User> getUserList() {
		return userService.selectUserList();
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	@ApiOperation(value = "사용자 정보 조회", notes = "사용자의 정보를 조회하는 API. User entity 클래스의 uid값을 기준으로 데이터를 가져온다.")
	public User getUser(@PathVariable("uid") Long uid) {
		return userService.selectUser(uid);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ApiOperation(value = "사용자 정보 등록", notes = "사용자 정보를 저장하는 API. User entity 클래스로 데이터를 저장한다.")
	public ResponseEntity<ApiResponseMessage> insertUser(User user) {
		ApiResponseMessage message = ApiResponseMessage.builder()
				.status("Success")
				.message("등록되었습니다.")
				.errorCode("")
				.errorMessage("")
				.build();
		ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

		try {
            userService.insertUser(user);
        } catch(Exception ex){
            message = ApiResponseMessage.builder()
    				.status("Failed")
    				.message("사용자 등록에 실패하였습니다.")
    				.errorCode("ERR01")
    				.errorMessage("Fail to registration for user information.")
    				.build();
            
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		return response;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ApiOperation(value = "사용자 정보 수정", notes = "사용자 정보를 수정하는 API. User entity 클래스로 데이터를 수정한다.<br>이때엔 정보를 등록할 때와는 다르게 uid 값을 함깨 보내줘야한다.")
	public ResponseEntity<ApiResponseMessage> updateUser(User user) {
		ApiResponseMessage message = ApiResponseMessage.builder()
				.status("Success")
				.message("수정되었습니다.")
				.errorCode("")
				.errorMessage("")
				.build();
		ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

		try {
            userService.updateUser(user);
        } catch(Exception ex){
            message = ApiResponseMessage.builder()
			.status("Failed")
			.message("사용자 정보 수정에 실패하였습니다.")
			.errorCode("ERR02")
			.errorMessage("Fail to update for user information.")
			.build();
            
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		return response;
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
	@ApiOperation(value = "사용자 정보 삭제", notes = "사용자 정보를 삭제하는 API. User entity 클래스의 uid 값으로 데이터를 삭제한다.")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable("uid") Long uid) {
		ApiResponseMessage message = ApiResponseMessage.builder()
				.status("Success")
				.message("삭제되었습니다.")
				.errorCode("")
				.errorMessage("")
				.build();
		ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

		try {
            userService.deleteUser(uid);
        } catch(Exception ex){
        	message = ApiResponseMessage.builder()
        			.status("Failed")
        			.message("사용자 정보 삭제에 실패하였습니다.")
        			.errorCode("ERR03")
        			.errorMessage("Fail to remove for user information.")
        			.build();
        	
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	
		return response;
	}
}
