<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- Chartist -->
    <%@ include file="/WEB-INF/include/scriptFile.jsp" %>
</head>
<body>
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <div id="main-wrapper">
        <%@ include file="/WEB-INF/include/header.jsp" %>
        <%@ include file="/WEB-INF/include/sidebar.jsp" %>

        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">
            
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
        
        <%@ include file="/WEB-INF/include/footer.jsp" %>
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    
</body>
</html>