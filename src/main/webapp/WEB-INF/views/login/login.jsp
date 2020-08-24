<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/include/scriptFile.jsp" %>
<script type="text/javascript">

$(document).ready(function(){
    var userInputId = getCookie("memberId");
    
    $("#memberId").val(userInputId); 
    
     
    if($("#memberId").val() != ""){ 
    	$("#idSave").attr("checked", true); 
    } 
    
});

function login(){
	
	var chkBoxVal = "off";
	
	if($("#memberId").val()==""){
		alert("아이디를 입력하세요");
		return false;
	}
	
	if($("#memberPasswd").val()==""){
		alert("비밀번호를 입력하세요");
		return false;
	}
	
	if ( $("input:checkbox[id='idSave']").is(":checked") ) {
		chkBoxVal = "on";
	}
	
	var data = {
				memberId : $("#memberId").val()
			,	memberPasswd : $("#memberPasswd").val()
			,	idSave	: chkBoxVal
	};
	
	gfn_ajax_call_data(data, "/login", "loginSuccess");
	
}

function gfn_ajax_callBack(data, type){
	if(data.resultCode == SUCCESS_CODE ){
		if(type == "loginSuccess"){
			location.href = "/main";	
		}
	}else if(data.resultCode == "10001"){
		alert("탈퇴한 회원입니다.");
		return false;
	}else {
		alert("존재하지 않는 회원입니다.");
	}
	
}


function goMemberJoinForm(){
	location.href="/memberJoinForm";
}

</script>
</head>
<body class="h-100">
    
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

    



    <div class="login-form-bg h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100">
                <div class="col-xl-6">
                    <div class="form-input-content">
                        <div class="card login-form mb-0">
                            <div class="card-body pt-5">
                                <a class="text-center" href="index.html"> <h4>도서관</h4></a>
        
                                <form class="mt-5 mb-5 login-input" id="login">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="ID" id="memberId" name="memberId">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" placeholder="PASSWORD" id="memberPasswd" name="memberPasswd">
                                    </div>
                                    <div class="form-check mb-3">
                                                <label class="form-check-label">
                                                    <input type="checkbox" class="form-check-input" id="idSave" name="idSave">아이디 저장</label>
                                    </div>
                                    <div class="form-group">
                                    <button class="btn login-form__btn submit w-100" onclick="javascript:login()">로그인</button>
                                    </div>
                                    <div class="form-group">
                                    <button type="button" class="btn mb-1 btn-primary" onclick="javascript:goMemberJoinForm();">회원가입</button>
                                    </div>
                                </form>
                                <p class="mt-5 login-form__footer">
                                <a href="/findIdForm" class="text-primary">아이디 찾기</a>        
                                <a href="/findPasswdForm" class="text-primary">비밀번호 찾기</a></p>
                            	
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

    

    
</body>
</html>