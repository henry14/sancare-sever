<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%-- <link type="text/css" rel="stylesheet" href="static/css/custom-theme/jquery-ui-1.8.15.custom.css" />
<link type="text/css" rel="stylesheet" href="${baseUrl }/static/css/sacco.css" />

<script type="text/javascript" src="static/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="static/js/jquery-ui-1.8.15.custom.min.js"></script> --%>
<script type="text/javascript">
$(".sbcredentials").hide();
</script>
</head>
<body style="height: auto;">
	<div class="loginPageBody">
    <div class="divTable">
    <div class="divRow">
        <div class="login_face_right">
            <div class="login-left-panel">
                <span class="login-img"></span>
            </div>
         </div>
         <div class="login_face_right">
		<div class="login-right-panel">
			<form name="loginForm" class="loginForm" action="${baseUrl }/j_spring_security_check" method="post">
				<div class="error" style="margin-left: 50px; height: 30px;">
					<c:if test="${param.error !=null}">
						<div>Invalid username or password</div>
					</c:if>
				</div>
				<div>
					<label class="uiLabel">Username:</label>
					<input name="j_username" id="j_username" type="text" class="uiTextbox" />
				</div>
				<div>
					<label id="passwordLabel" class="uiLabel">Password:</label>
					<input name="j_password" id="j_password" type="password" class="uiTextbox" />
				</div>
				<div style="padding-left: 130px;">
					<input name="btnSubmit" id="btnSubmit" type="submit" value="Sign In" class="uiButton" />
				</div>
			</form>
			
			</div>
            </div>
		</div>
        <div class="divRow" style="margin-top:10%; padding:100px; color:#000;">
        
        </div>
    </div>	
		
	</div>
	
</body>
</html>