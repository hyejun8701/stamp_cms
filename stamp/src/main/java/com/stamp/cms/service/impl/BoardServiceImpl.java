package com.stamp.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stamp.cms.model.Board;
import com.stamp.cms.repository.BoardRepository;
import com.stamp.cms.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository boardRepository;

	@Override
	public List<Board> selectBoardList() {
		return boardRepository.findAll();
	}
}