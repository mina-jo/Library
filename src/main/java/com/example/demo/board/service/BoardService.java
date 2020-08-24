package com.example.demo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.dao.BoardDAO;
import com.example.demo.board.response.BoardCommentResponse;
import com.example.demo.board.response.BoardResponse;

@Service
public class BoardService {
	
	@Autowired
    private BoardDAO boardDAO;


    public List<BoardResponse> getBoardList(BoardResponse paramVO) {
        return boardDAO.getBoardList(paramVO);
    }
    
    public int getBoardListCnt(BoardResponse paramVO) {
    	return boardDAO.getBoardListCnt(paramVO);
    }
    
    public int boardWrite(BoardResponse paramVO) {
    	return boardDAO.boardWrite(paramVO);
    }
    
    public BoardResponse getBoardView(int boardSeq) {
    	return boardDAO.getBoardView(boardSeq);
    }
    
    public int deleteBoard(int boardSeq) {
    	return boardDAO.deleteBoard(boardSeq);
    }
    
    public int updateBoard(BoardResponse paramVO) {
    	return boardDAO.updateBoard(paramVO);
    }
    
    public int increaseBoardView(int boardSeq) {
    	return boardDAO.increaseBoardView(boardSeq);
    }
    
    public List<BoardCommentResponse> getBoardCommentList(int boardSeq){
    	return boardDAO.getBoardCommentList(boardSeq);
    }
    
    public int deleteBoardComment(String boardCommSeq) {
    	return boardDAO.deleteBoardComment(boardCommSeq);
    }
    
    public int insertBoardComment(BoardCommentResponse paramVO) {
    	return boardDAO.insertBoardComment(paramVO);
    }

}
