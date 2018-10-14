package com.stamp.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stamp.cms.model.User;
import com.stamp.cms.repository.UserRepository;
import com.stamp.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> selectUserList() {
		return userRepository.findAll();
	}

	@Override
	public User selectUser(Long uid) {
		return userRepository.getOne(uid);
	}

	@Override
	public void insertUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(Long uid) {
		userRepository.deleteById(uid);
	}
}