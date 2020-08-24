package com.example.demo.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.response.BoardCommentResponse;
import com.example.demo.board.response.BoardResponse;

@Mapper
public interface BoardDAO {
	
	List<BoardResponse> getBoardList(BoardResponse paramVO);
	
	int getBoardListCnt(BoardResponse paramVO);
	
	int boardWrite(BoardResponse paramVO);
	
	BoardResponse getBoardView(int boardSeq);
	
	int deleteBoard(int boardSeq);
	
	int updateBoard(BoardResponse paramVO);
	
	int increaseBoardView(int boardSeq);
	
	List<BoardCommentResponse> getBoardCommentList(int boardSeq);
	
	int deleteBoardComment(String boardCommSeq);
	
	int insertBoardComment(BoardCommentResponse paramVO);
}
