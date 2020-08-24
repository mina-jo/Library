package com.example.demo.board.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.response.BoardCommentResponse;
import com.example.demo.board.response.BoardResponse;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.pagination.PaginationInfo;
import com.example.demo.common.vo.BaseBean;
import com.example.demo.sample.BootstrapSampleController;

@Controller
public class BoardController {
	
	@Autowired
    private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BootstrapSampleController.class);

	@RequestMapping(value="/boardList", method = {RequestMethod.GET, RequestMethod.POST})
	public String getBoardList(@ModelAttribute("paramVO") BoardResponse paramVO, ModelMap model, @RequestParam(value="searchCondition", required = false) String searchCondition, 
			@RequestParam(value="searchKeyword", required = false) String searchKeyword) throws Exception{
		logger.info("===== getBoardList START =====");
		
		logger.info("searchKeyword -->"+searchKeyword);
		logger.info("searchCondition -->"+searchCondition);
		
		if(searchKeyword != null)
			paramVO.setSearchKeyword(searchKeyword);
		if(searchCondition != null)
			paramVO.setSearchCondition(searchCondition);
		
		// 글 개수(한페이지에 출력할 )
		paramVO.setPageUnit(10);
		// 페이지 개수(한페이지에 출력할 )
		paramVO.setPageSize(10);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(paramVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(paramVO.getPageUnit());
		paginationInfo.setPageSize(paramVO.getPageSize());

		paramVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		paramVO.setLastIndex(paginationInfo.getLastRecordIndex());
		paramVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		int totCnt = boardService.getBoardListCnt(paramVO);
		List<BoardResponse> list = boardService.getBoardList(paramVO);

		paginationInfo.setTotalRecordCount(totCnt);
		

		model.addAttribute("totCnt",totCnt);
		model.addAttribute("boardList", list);
		model.addAttribute("paginationInfo", paginationInfo);
        
		
		return "board/boardList";
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public String boardWriteForm() {
		logger.info("===== boardWriteForm =====");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/boardWrite", method= RequestMethod.POST)
	public String boardWrite(HttpServletRequest request, @ModelAttribute BoardResponse boardResponse, Model model) throws Exception{
		
		int result = 0;
		
		boardResponse.setMemberSeq("1");
		
		result = boardService.boardWrite(boardResponse);
		
		logger.info("result -->"+result);
		
		if(result == 1) {
			model.addAttribute("msg","글 작성이 완료되었습니다. ");
			model.addAttribute("url","/boardList");
		}else {
			model.addAttribute("msg","글 작성 실패하였습니다.. ");
			model.addAttribute("url","/boardWrite");
		}
		
		return "common/redirectPage";
	}
	
	
	@RequestMapping(value="/boardDetail")
	public String getBoardView(ModelMap model,HttpServletRequest request, @RequestParam(value="boardSeq", required = false) int boardSeq) {
		logger.info("===== getBoardView =====");
		
		logger.info("boardSeq -->"+boardSeq);
		
		//조회수 증가
		boardService.increaseBoardView(boardSeq);
		
		BoardResponse resultVO = boardService.getBoardView(boardSeq);
		List<BoardCommentResponse> commentList = boardService.getBoardCommentList(boardSeq);
		
		model.addAttribute("commentList", commentList);
		model.addAttribute("boardData", resultVO);
		
		return "board/boardDetail";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.GET)
	public String boardUpdateForm(ModelMap model,HttpServletRequest request, @RequestParam(value="boardSeq", required = false) int boardSeq) {
		logger.info("===== boardUpdateForm =====");
		
		logger.info("boardSeq -->"+boardSeq);
		
		BoardResponse resultVO = boardService.getBoardView(boardSeq);
		
		model.addAttribute("boardData", resultVO);
		
		return "board/boardUpdateForm";
	}
	
	@RequestMapping(value="/boardUpdate", method= RequestMethod.POST)
	public String boardUpdate(HttpServletRequest request, @ModelAttribute BoardResponse boardResponse, Model model) throws Exception{
		logger.info("===== boardUpdate =====");
		
		int result = 0;
		
		result = boardService.updateBoard(boardResponse);
		
		
		if(result == 1) {
			model.addAttribute("msg","글 수정 완료되었습니다. ");
			model.addAttribute("url","/boardList");
		}else {
			model.addAttribute("msg","글 수정 실패하였습니다.. ");
			model.addAttribute("url","/boardDetail?boardSeq="+boardResponse.getBoardSeq());
		}
		
		return "common/redirectPage";
	}
	
	@RequestMapping(value="/boardDelete")
	public String deleteBoard(ModelMap model,HttpServletRequest request, @RequestParam(value="boardSeq", required = false) int boardSeq) {	
		logger.info("===== deleteBoard =====");
		
		logger.info("boardSeq -->"+boardSeq);
		
		int resultCnt = 0;
		resultCnt = boardService.deleteBoard(boardSeq);
		
		if(resultCnt == 1) {
			model.addAttribute("msg","글 삭제 완료되었습니다. ");
			model.addAttribute("url","/boardList");
		}else {
			model.addAttribute("msg","글 삭제 실패하였습니다.. ");
			model.addAttribute("url","/boardDetail?boardSeq"+boardSeq);
		}
		
		return "common/redirectPage";
	}
	
	@RequestMapping(value="/insertBoardComment", method = RequestMethod.POST)
	@ResponseBody
	public BaseBean insertBoardComment(HttpServletRequest request,HttpSession session, HttpServletResponse response, Model model) {
		
		logger.info("===== insertBoardComment =====");
		BaseBean baseBean = new BaseBean();
		
		String boardSeq = request.getParameter("boardSeq");
		String boardComment = request.getParameter("boardComment");
		
		logger.info("boardSeq ===> "+boardSeq);
		logger.info("boardComment ===> "+boardComment);
		
		BoardCommentResponse paramVO  = new BoardCommentResponse();
		paramVO.setBoardSeq(boardSeq);
		paramVO.setBoardComment(boardComment);
		paramVO.setMemberSeq("1");
		
		int chk = 0; 
		chk = boardService.insertBoardComment(paramVO);
		
				
		if(chk == 1) {
			baseBean.setAttrVal1("댓글이 등록되었습니다. ");
		}else {
				baseBean.setAttrVal1("댓글 등록 중 오류가 발생하였습니다.");
		}
		
		return baseBean;
	}
	
	
	@RequestMapping(value="/deleteBoardComment", method = RequestMethod.POST)
	@ResponseBody
	public BaseBean deleteBoardComment(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		logger.info("===== deleteBoardComment =====");
		BaseBean baseBean = new BaseBean();
		
		String boardCommSeq = request.getParameter("boardCommSeq");
		
		logger.info("boardCommSeq ===> "+boardCommSeq);
		
		int chk = 0; 
		chk = boardService.deleteBoardComment(boardCommSeq);
		
				
		if(chk == 1) {
			baseBean.setAttrVal1("댓글이 삭제되었습니다. ");
		}else {
				baseBean.setAttrVal1("댓글 삭제 중 오류가 발생하였습니다.");
		}
		
		return baseBean;
	}

}
