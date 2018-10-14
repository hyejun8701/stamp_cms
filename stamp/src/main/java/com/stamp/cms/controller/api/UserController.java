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
@Api(value = "UserController", description = "����� ���� API", basePath = "/user")
public class UserController {
	
	@Autowired
    UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation(value = "����� ��� ��ȸ", notes = "����� ����� ��ȸ�ϴ� API.")
	public List<User> getUserList() {
		return userService.selectUserList();
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	@ApiOperation(value = "����� ���� ��ȸ", notes = "������� ������ ��ȸ�ϴ� API. User entity Ŭ������ uid���� �������� �����͸� �����´�.")
	public User getUser(@PathVariable("uid") Long uid) {
		return userService.selectUser(uid);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ApiOperation(value = "����� ���� ���", notes = "����� ������ �����ϴ� API. User entity Ŭ������ �����͸� �����Ѵ�.")
	public ResponseEntity<ApiResponseMessage> insertUser(User user) {
		ApiResponseMessage message = ApiResponseMessage.builder()
				.status("Success")
				.message("��ϵǾ����ϴ�.")
				.errorCode("")
				.errorMessage("")
				.build();
		ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

		try {
            userService.insertUser(user);
        } catch(Exception ex){
            message = ApiResponseMessage.builder()
    				.status("Failed")
    				.message("����� ��Ͽ� �����Ͽ����ϴ�.")
    				.errorCode("ERR01")
    				.errorMessage("Fail to registration for user information.")
    				.build();
            
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		return response;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ApiOperation(value = "����� ���� ����", notes = "����� ������ �����ϴ� API. User entity Ŭ������ �����͸� �����Ѵ�.<br>�̶��� ������ ����� ���ʹ� �ٸ��� uid ���� �Ա� ��������Ѵ�.")
	public ResponseEntity<ApiResponseMessage> updateUser(User user) {
		ApiResponseMessage message = ApiResponseMessage.builder()
				.status("Success")
				.message("�����Ǿ����ϴ�.")
				.errorCode("")
				.errorMessage("")
				.build();
		ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

		try {
            userService.updateUser(user);
        } catch(Exception ex){
            message = ApiResponseMessage.builder()
			.status("Failed")
			.message("����� ���� ������ �����Ͽ����ϴ�.")
			.errorCode("ERR02")
			.errorMessage("Fail to update for user information.")
			.build();
            
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		return response;
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
	@ApiOperation(value = "����� ���� ����", notes = "����� ������ �����ϴ� API. User entity Ŭ������ uid ������ �����͸� �����Ѵ�.")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable("uid") Long uid) {
		ApiResponseMessage message = ApiResponseMessage.builder()
				.status("Success")
				.message("�����Ǿ����ϴ�.")
				.errorCode("")
				.errorMessage("")
				.build();
		ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

		try {
            userService.deleteUser(uid);
        } catch(Exception ex){
        	message = ApiResponseMessage.builder()
        			.status("Failed")
        			.message("����� ���� ������ �����Ͽ����ϴ�.")
        			.errorCode("ERR03")
        			.errorMessage("Fail to remove for user information.")
        			.build();
        	
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	
		return response;
	}
}
