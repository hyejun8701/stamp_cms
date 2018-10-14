package com.stamp.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stamp.cms.model.Board;
import com.stamp.cms.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getBoard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/boardList");
		return mv;
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView getBoardList() {
		ModelAndView mv = new ModelAndView();
		List<Board> list = boardService.selectBoardList();
		mv.addObject("list", list);
		mv.setViewName("/board/boardList");
		
		return mv;
	}
}