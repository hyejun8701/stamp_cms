package com.stamp.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stamp.cms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}