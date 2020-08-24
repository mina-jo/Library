<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
 <%@ include file="/WEB-INF/include/scriptFile.jsp" %>
 <script type="text/javascript">
 
 function goBoardDelete(boardSeq){
	 location.href="/boardDelete?boardSeq="+boardSeq;
 }
 
 function goBoardUpdate(boardSeq){
	 location.href="/boardUpdate?boardSeq="+boardSeq;
 }
 
 function goBoardCommentInsert(){
	 
	 if($("#boardComment").val()==""){
			alert("댓글을 입력해주세요.");
			$("#boardComment").focus();
			return false;
		}
	 
	 var data = {
			 boardComment : $("#boardComment").val()
			 ,	boardSeq : $("#boardSeq").val()
		};
	
	gfn_ajax_call_data(data, "/insertBoardComment", "insertBoardCommenSuccess");
 }
 
 function goBoardCommentDelete(boardCommSeq){
	 if(confirm("삭제하시겠습니까?") == true){ //확인
			
			var data = {
					boardCommSeq : boardCommSeq
			};
		
			gfn_ajax_call_data(data, "/deleteBoardComment", "deleteBoardCommenSuccess");
		}
		else { // 취소
			return false;
		}
 }
 
 function gfn_ajax_callBack(data, type){
		if(data.resultCode == SUCCESS_CODE ){
			if(type == "deleteBoardCommenSuccess"){
				alert(data.attrVal1);
				location.reload(true);
			}else if(type == "insertBoardCommenSuccess"){
				alert(data.attrVal1);
				location.reload(true);
			}
		}else {
			alert("서버 에러입니다.");
		}
		
	}

 function goBack(){
		location.href="/boardList";
}
 
 </script>
</head>
<body>
<form method="post" id="boardViewForm" name="boardViewForm">
    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

    
    <!--**********************************
        Main wrapper start
    ***********************************-->
    <div id="main-wrapper">

         <%@ include file="/WEB-INF/include/header.jsp" %>
        <%@ include file="/WEB-INF/include/sidebar.jsp" %>
        
        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">
        <br/><br/>
			<div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">자유게시판 글 자세히 보기</h4>
                                <div class="basic-form">
                                    <form>
                                    <input type="hidden" id="boardSeq" name="boardSeq" value="${boardData.boardSeq}"/>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>제목 : </label>
                                                ${boardData.boardTitle}
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>글쓴이 : </label>
                                            ${boardData.memberName}
                                        </div>
                                        <div class="form-group">
                                            <label>내용 : </label>
                                            ${boardData.boardContent}
                                        </div>
                                        <button type="button" class="btn btn-dark" onclick="javascirpt:goBoardUpdate(${boardData.boardSeq});">수정하기</button>
                                        &nbsp;<button type="button" class="btn btn-dark" onclick="javascirpt:goBoardDelete(${boardData.boardSeq});">삭제하기</button>
                                        &nbsp;<button type="button" class="btn btn-dark" onclick="javascirpt:goBack();">돌아가기</button>
                                        
                                     </form>
                                </div>
                            <br/><br/>
                            <h4 class="card-title">자유게시판 댓글</h4>
                            	<label>내용</label>
                                <textarea class="form-control" id="boardComment" name="boardComment" rows="2"></textarea><br/>
                                <button type="button" class="btn btn-dark" onclick="javascirpt:goBoardCommentInsert();">댓글달기</button>
                             <br/><br/>
                             <div class="basic-form">
	                              	<table class="table table-striped table-bordered zero-configuration">
	                                        <tbody>
	                                           <c:forEach var="data" items="${commentList}" varStatus="status">
													<tr>
														<td>내용 : ${data.boardComment}</td>
														<td>작성자 : ${data.memberName}</td>
														<td>작성일 : ${data.createDate}</td>
														<td><button type="button" class="btn btn-dark" onclick="javascirpt:goBoardCommentDelete(${data.boardCommSeq});">삭제하기</button></td>
													</tr>
												</c:forEach>
	                                        </tbody>
	                                    </table>
                             </div>
                            </div>
                        </div>
                    </div>
           
           
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
        
        
        <!--**********************************
            Footer start
        ***********************************-->
        <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
            </div>
        </div>
        <!--**********************************
            Footer end
        ***********************************-->
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

</form>
</body>
</html>