<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  부트 부분 -->
<!-- BOOTSTRAP CORE CSS -->
<link href="/NotFound/css/bootstrap.css" rel="stylesheet" />
<!-- FONT AWESOME ICONS STYLES -->
<link href="/NotFound/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM CSS -->
<link href="/NotFound/css/styles.css" rel="stylesheet" />
<!--  jauery를 사용하기위해선 이걸 작성해줘야함 ..  -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="/NotFound/script/facebookscript.js"></script>
<script type="text/javascript" src="/NotFound/script/popup.js"></script>
<link href="/NotFound/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="home">
		<div class="overlay">
			<header id="header">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<h2>Editor</h2>
					</div>
				</div>
			</div>
			</header>
			<div class="container topcontainer">
				<div class="row scroll-me">
					<div class="col-lg-6">
						<h4>
							내 하루를 한 장 한 장 넘기는 순간을 떠올려 보세요. <br>내 이야기를 만질 수 있는 것<br>
							내 하루들을 펼쳐보는 일이 가능할지 모르죠. <br>
						</h4>
						<a href="#about" class="btn btn-custom btn-two">Start </a> <a
							href="#clients" class="btn btn-custom btn-one"
							onclick="layer_open('layer2');return false;">Join</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<h2 class="head-line">My Editor ?</h2>
				<br> <br>
				<p>
					앞으로의 일정과 지난 일정을 담아놓는 공간입니다. <br> 얄라 얄라 얄라셩 얄라리 얄라 <br>
					이런들 어떠하고 저런들 어떠하리 ...<br> 한줄만 더 만들어놓으렴 <br>
				</p>
				<div class="row text-center"></div>
			</div>
			<div class="col-lg-6 text-center">
				<h2 class="head-line">Start</h2>
				<br>
				<form class="form-horizontal" action="/NotFound/index.do"
					method="post">
					<input type="hidden" name="action" value="login">
					<div class="form-group">
						<label class="col-sm-2 control-label">ID</label>
						<div class="col-sm-10">
							<input type="text" id="userid" name="userid" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" id="userpd" name="userpd"
								class="form-control">
						</div>
					</div>
					<br>
					<div class="buttonalign">
						<input type="submit" value="전송" class="btn btn-info">
						<fb:login-button = onlogin="checkLoginState();"></fb:login-button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<!-- 여기부터 로그인 부분의 div -->

	<div class="layer">
		<div class="bg"></div>
		<div id="layer2" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts" style="margin-left: 20%; margin-top: 10%">
					<form method="post" name="insertUser" action="/NotFound/index.do"
						class="form-inline">
						<label for="control-label" style="font-size: 20px">회원가입</label>
						<br><br>
						<input type="hidden" name="action" id="action" value="join">
						<table name="joincss">
							<tr class="form-group" style="width: 80%; margin-top: 5%;">
								<td width="100px"><label for="control-label">Name</label></td>
								<td ><input type="text" name="joinname" class="form-control"></td>
							</tr>
							
							<tr class="form-group"  style="width: 80%; margin-top: 5%; ">
								<td width="100px"><label for="control-label">아이디</label></td>
								<td><input type="text" name="joinid" id="joinid" class="form-control"> 
								<input type="button" value="idcheck" class="btn btn-info" onclick="checkID(insertUser.joinid.value)"></td>
							</tr>

							<tr class="form-group"  style="width: 80%; margin-top: 5%; ">
								<td width="100px"><label for="control-label">비밀번호</label></td>
								<td><input type="password" name="joinpass" class="form-control"></td>
							</tr>

							<tr class="form-group"  style="width: 80%; margin-top: 5%; " >
								<td width="100px" colspan="2"><label for="control-label">확인</label></td>
								<td><input type="password" name="joinrepass" onBlur="pass_Check()" class="form-control">&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<td><input type="text" name="pwdCheck" id="pwdCheck" size="30" style="border-width: 0px" readonly></td>
							</tr>
							<tr  style="width: 80%;">
								<td colspan="2">
								<input type="button" value="가입하기" class="btn btn-info" onclick="insert_Clear();">&nbsp;
								<input type="button" value="취소" class="btn btn-info" onclick="fadelayer();">
								</td>
							</tr>
						</table>
					</form>
					<!--// content-->
				</div>
			</div>
		</div>
	</div>
</body>
</html>