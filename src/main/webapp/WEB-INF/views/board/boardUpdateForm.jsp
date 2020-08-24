<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
 <%@ include file="/WEB-INF/include/scriptFile.jsp" %>
 <script type="text/javascript">

 function goBack(){
		location.href="/boardList";
}
 
 </script>
</head>
<body>
<form method="post" id="boardWriteForm" name="boardWriteForm">
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
                                <h4 class="card-title">자유게시판 글쓰기</h4>
                                <div class="basic-form">
                                    <form>
                                    <input type="hidden" name="boardSeq" id="boardSeq" value="${boardData.boardSeq}"/>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>제목 </label>
                                                <input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${boardData.boardTitle}">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>글쓴이 :</label>
                                                ${boardData.memberName}
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea class="form-control" id="boardContent" name="boardContent" >${boardData.boardContent}</textarea>
                                        </div>
                                        <button type="submit" class="btn btn-dark">수정하기</button>
                                        <button type="button" class="btn btn-dark" onclick="javascirpt:goBack();">돌아가기</button>
                                    </form>
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