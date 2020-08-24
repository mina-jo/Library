<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/include/scriptFile.jsp" %>
<script type="text/javascript">

function findId(){
	
	if($("#memberName").val()==""){
		alert("이름을 입력하세요");
		return false;
	}
	
	if($("#memberPhone").val()==""){
		alert("핸드폰번호를 입력하세요");
		return false;
	}
	
	var data = {
				memberName : $("#memberName").val()
			,	memberPhone : $("#memberPhone").val()
	};
	
	gfn_ajax_call_data(data, "/findId", "findIdSuccess");
	
}

function gfn_ajax_callBack(data, type){
	if(data.resultCode == SUCCESS_CODE ){
		if(type == "findIdSuccess"){
			alert("아이디는 "+data.attrVal1+"입니다");
			location.href="/loginForm";
		}
	}else {
		alert("존재하지 않는 회원입니다.");
	}
	
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
                                <a class="text-center"> <h4>아이디 찾기</h4></a>
        
                                <form class="mt-5 mb-5 login-input" id="login">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="이름" id="memberName" name="memberName">
                                    </div>
                                    <div class="form-group">
                                         <input type="text" class="form-control" placeholder="핸드폰번호" id="memberPhone" name="memberPhone">
                                    </div>
                                    <div class="form-group">
                                    <button class="btn login-form__btn submit w-100" onclick="javascript:findId()">아이디 찾기</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

    

    
</body>
</html>