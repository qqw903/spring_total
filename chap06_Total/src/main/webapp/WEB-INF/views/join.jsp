<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center">
	<form action="/join/add" method="post">
		<p>
			<b>아이디</b><br /> <input type="text" name="id" required id="id">
			<br/><span id="irst"></span>
		</p>
		<p>
			<b>비밀번호</b><br /> <input type="password" name="pw" required />
		</p>
		<p>
			<b>이메일</b><br /> <input type="email" name="em" id="em" required />
			<br/><span id="erst"></span>
		</p>
		<button type="submit" id="sbt">가입하기</button>
		<input type="reset" value="다시작성">
	</form>
</div>

<script>
	document.getElementById("id").onkeyup = function() {
		var id = document.getElementById("id").value;
		if(id.length != 0){
				var xhr = new XMLHttpRequest();
				xhr.open("post", "/join/signup_check/"+id, true);
				xhr.send();
		
				xhr.onreadystatechange = function() {
					if (this.readyState == 4) {
						var obj = this.responseText;
						document.getElementById("irst").innerHTML = obj;
					}
				}
		}else{
			document.getElementById("irst").innerHTML = "";
		}
	}

	document.getElementById("em").onchange = function() {
		var email = document.getElementById("em").value;
		if(email.legth != 0){
			var xhr = new XMLHttpRequest();
			xhr.open("post", "/join/signup_check2/"+email, true);
			xhr.send();

			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					var obj = this.responseText;
					document.getElementById("erst").innerHTML = obj;
				}
			}
		}else{
			document.getElementById("erst").innerHTML = "";
		}
	}
</script>
