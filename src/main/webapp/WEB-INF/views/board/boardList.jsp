<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
 <%@ include file="/WEB-INF/include/scriptFile.jsp" %>
 <script type="text/javascript">
 function fn_boardWrite(){
	 location.href="/boardWrite";
 }
 
function fn_pagination(idx){
	document.boardListForm.pageIndex.value = idx;
	document.boardListForm.action = "/boardList";
   	document.boardListForm.submit();
}
 </script>
</head>
<body>
<form method="post" id="boardListForm" name="boardListForm">
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

           
            <!-- row -->

            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">자유게시판</h4>
                                		<div class="basic-form">
                                			<select class="form-control" id="searchCondition" name="searchCondition">
                                			  	<option>검색 조건</option>
                                                <option value="searchBoardTitle">제목</option>
                                                <option value="searchBoardContent">내용</option>
                                                <option value="searchWriten">글쓴이</option>
                                            </select><br/>
                                            <input type="text" class="form-control input-default" id="searchKeyword" name="searchKeyword"><br/>
                                			<button type="submit" class="btn mb-1 btn-primary" >검색</button>
                                		</div>
                                    		<br/><br/>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered zero-configuration">
                                        <thead>
                                            <tr>
                                                <th>글 번호</th>
                                                <th>제목</th>
                                                <th>글쓴이</th>
                                                <th>작성일</th>
                                                <th>조회수</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <c:forEach var="data" items="${boardList}" varStatus="status">
												<tr>
													<td>${data.boardSeq}</td>
													<td onclick="location.href='/boardDetail?boardSeq=${data.boardSeq}'">${data.boardTitle}</td>
													<td>${data.memberName}</td>
													<td>${data.createDate}</td>
													<td>${data.views}</td>
												</tr>
											</c:forEach>
                                        </tbody>
                                    </table>
            <!-- 페이징 영역 S. -->
        	<div id="paginationBox">
        		<input type="hidden" id="pageIndex" name="pageIndex" value="${paramVO.pageIndex}"/>
				<ul class="pagination">
					<c:forEach begin="${paginationInfo.firstPageNoOnPageList}" end="${paginationInfo.lastPageNoOnPageList}" var="idx">
						<li class="page-item <c:out value="${paginationInfo.currentPageNo == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}')"> ${idx} </a></li>
					</c:forEach>				</ul>
			</div>
        	<!-- 페이징 영역 E. -->
        	<button type="button" class="btn mb-1 btn-primary" onclick="javascript:fn_boardWrite();">글쓰기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #/ container -->
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