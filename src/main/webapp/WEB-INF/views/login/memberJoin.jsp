<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="/WEB-INF/include/scriptFile.jsp" %>
</head>
<script type="text/javascript">
	var memberIdChk = false;

function memberJoin(){
	
		if($("#memberId").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#memberId").focus();
			return false;
		}
		
		if($("#memberPasswd").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#memberPasswd").focus();
			return false;
		}
		
		if($("#memberPasswd2").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#memberPasswd2").focus();
			return false;
		}
		
		if($("#memberName").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#memberName").focus();
			return false;
		}
		
		if($("#email1").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#email1").focus();
			return false;
		}
		
		if($("#email2").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#email2").focus();
			return false;
		}
		
		if($("#memberPhone").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#memberPhone").focus();
			return false;
		}
		
		if($("#birthDt").val()==""){
			alert("필수입력 사항을 모두 입력해주세요.");
			$("#birthDt").focus();
			return false;
		}
		
		if($("#memberPasswd").val()!=$("#memberPasswd2").val()){
			alert("입력하신 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			$("#memberPasswd").focus();
			return false;
		}
		
		if(memberIdChk == true){
			if(confirm("회원가입하시겠습까?") == true){ //확인
				
				var emailVal = $("#email1").val() + $("#email2").val();
				
				var data = {
						memberId : $("#memberId").val()
					,	memberPasswd : $("#memberPasswd").val()
					,	memberName : $("#memberName").val()
					,	memberPhone : $("#memberPhone").val()
					,	birthDt : $("#birthDt").val()
					,	email : emailVal
				};
			
				gfn_ajax_call_data(data, "/memberJoin", "memberJoinSuccess");
			}
			else { // 취소
				return false;
			}
		}else{
			alert("아이디 중복 체크를 진행해주세요. ");
		}
	
}

function memberIdCheck(){
	
	if($("#memberId").val()==""){
		alert("아이디를 입력해주세요.");
		$("#memberId").focus();
		return false;
	}
	
		var data = {
				memberId : $("#memberId").val()
		};
	
	gfn_ajax_call_data(data, "/getMemberIdCheck", "getMemberIdCheckSuccess");

}

function gfn_ajax_callBack(data, type){
	if(data.resultCode == SUCCESS_CODE ){
		if(type == "getMemberIdCheckSuccess"){
			alert(data.attrVal1);
			memberIdChk = true;
			
		}else if(type == "memberJoinSuccess"){
			alert(data.attrVal1);
			location.href="/loginForm";
		}
	}else {
		alert("서버 에러입니다.");
	}
	
}

function goBack(){
	location.href="/loginForm";
}

</script>
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
                                
                                    <a class="text-center" href="index.html"> <h4>도서관 회원가입</h4></a>
        
                                <form class="mt-5 mb-5 login-input">
                                    <div class="form-group">
                                         <input type="text" class="form-control"  placeholder="* 아이디" id="memberId" name="memberId"> <br/><button type="button" class="btn btn-primary" onclick="javascript:memberIdCheck();">아이디 중복 확인</button>
                                    </div>
                                    <div class="form-group">
                                       <input type="password" class="form-control"  placeholder="* 비밀번호" id="memberPasswd" name="memberPasswd">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" placeholder="* 비밀번호 확인"  id="memberPasswd2" name="memberPasswd2">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control"  placeholder="* 이름"  id="memberName" name="memberName">
                                    </div>
                                    <div class="form-group">
                                        <input type="email"   placeholder="* 이메일"  id="emamil1" name="email1">@
                                                <select id="email2" name="email2">
                                                    <option selected="selected">Choose...</option>
                                                    <option value="1">naver.com</option>
                                                    <option value="2">daum.net</option>
                                                    <option value="3">google.com</option>
                                                </select>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control"  placeholder="* 핸드폰번호 000-0000-0000 형식으로 입력하세요. "  id="memberPhone" name="memberPhone">
                                    </div><div class="form-group">
                                        <input type="text" class="form-control"  placeholder="* 생일 YYYY-MM-DD 형식으로 입력하세요. "  id="birthDt" name="birthDt">
                                    </div>
                                	<button type="button" class="btn mb-1 btn-primary" onclick="javascript:memberJoin();">회원가입</button>
                                	<button type="button" class="btn mb-1 btn-primary" onclick="javascript:goBack();">돌아가기</button>
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