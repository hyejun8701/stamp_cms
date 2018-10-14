package com.stamp.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stamp.cms.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {}