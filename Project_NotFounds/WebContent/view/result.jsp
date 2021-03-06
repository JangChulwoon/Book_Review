<%@ page language="java" contentType="text/html;"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/NotFound/css/bootstrap.min.css" rel="stylesheet">
<script type="text/JavaScript"
	src="http://code.jquery.com/jquery-1.7.min.js"></script>
<link href="/NotFound/css/style.css" rel="stylesheet">
<script type="text/javascript" src="/NotFound/script/board.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
	<div class="sid_bar">
		<div class="col-lg-6">
			<h2 style="">&nbsp;Editor</h2>
		</div>
		<div class="side_bar" style="color: black">
			<label for="exampleInputEmail1">Name : ${name}</label> <br> <label
				for="exampleInputEmail1">ID : ${id}</label>
			<button type="button" class="btn btn-default btn-sm"
				aria-label="Left Align"
				onclick="location.href='index.do?action=logout';">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			</button>

			<hr>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation"><a href="/NotFound/main.do">Home</a></li>

			</ul>
			<hr>
		</div>
	</div>
	</header>
	<!-- 여기서부터  -->
	<div class="main_table">
		<!--center-->
		<div class="col-sm-8">
			<div class="row" style="margin-top: 5%;">
				<div class="col-xs-12">
					<table class="table table-hover" style="max-width: 593;">
						<tr>
							<td width="100px">제목</td>
							<td colspan="3">${board[0].subject}</td>
						</tr>
						<tr>
							<td width="100px">작성자</td>
							<td>${board[0].writer}</td>
							<td width="100px">출판일자</td>
							<td>${board[0].publication_date}</td>
						</tr>
						<tr>
							<td>책이름</td>
							<td colspan="3">${board[0].bookname}</td>
						</tr>
						<tr>
							<td>작가</td>
							<td>${board[0].author}</td>
							<td>출판사</td>
							<td>${board[0].publisher}</td>
						</tr>
						<tr>
							<td colspan="4" style="text-align: center;"><br> <img
								src="${board[0].book_img}" width="30%"> <br> <br>
								<b>${board[0].descriptions}</b> <br> <br>${board[0].content}</td>

						</tr>
					</table>
					<c:choose>
						<c:when test="${board[0].writer eq sessionScope.id}">
									`<input type="button" value="수정/삭제" class="btn btn-link"
								onclick="layer_open('layer2');return false;">
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
					<!-- 여기 -->
					<table class="table table-hover">
						<c:choose>
							<c:when test="${fn:length(reple) == 0}">
							</c:when>
							<c:otherwise>
								<c:forEach var="i" begin="0" end="${fn:length(reple)-1}"
									step="1">
									<tr>
										<td colspan="2">${reple[i].id}</td>
									</tr>
									<tr class="info">
										<td>${reple[i].date}</td>
										<td style="max-width: 400px">${reple[i].contents}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<tr>
							<form method="post" action="/NotFound/main.do"
								class="form-inline">
								<td style="vertical-align: middle;"><input type="hidden"
									name="main_action" id="main_action" value="reply"> <label
									for="exampleInputEmail1">댓글 </label> <input type="hidden"
									name="num" id="num" value="${board[0].num}"> <input
									type="hidden" name="id" id="id"
									value="<%=session.getAttribute("id")%>"></td>
								<td>
									<div class="form-group">
										<textarea class="form-control" name="context" id="context"></textarea>
										<input type="submit" value="전송" class="btn btn-default">
									</div>

								</td>
							</form>
						</tr>
					</table>
				</div>
			</div>
			<hr>
		</div>
		<!--/center-->
	</div>
	<!-- 여기까지 -->
	<div class="layer">
		<div class="bg"></div>
		<div id="layer2" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts">
					<form name="writeFrom" method="post" action="/NotFound/main.do">
						<!--enctype="multipart/form-data" 이게 뭐지-->
						<input type="hidden" name="main_action" value="board_update">
						<input type="hidden" name="id"
							value="<%=session.getAttribute("id")%>"> <input
							type="hidden" name="num" id="num" value="${board[0].num}">
						<input type="hidden" name="publisher" id="publisher"
							value="${board[0].publisher}"> <input type="hidden"
							name="publication_date" id="publication_date"
							value="${board[0].publication_date}"> <input
							type="hidden" name="book_img" id="book_img"
							value="${board[0].book_img}"> <input type="hidden"
							name="description" id="description"
							value="${board[0].descriptions}">
						<table width="100%" border="1" align="center" cellspacing="0"
							cellpadding="3">
							<tr>
								<th scope="row" height="10%">제목</th>
								<td><input name="subject" id="subject" type="text"
									value="${board[0].subject}"></td>
							</tr>
							<tr>
								<th scope="row" height="10%">책 제목</th>
								<td><input type="text" value="${board[0].bookname}"
									name="bookname" id="bookname"> <input type="button"
									value="검색" onclick="booksearch();" /></td>
							</tr>
							<tr>
								<th scope="row">저자</th>
								<td><input type="text" name="author" id="author"
									value="${board[0].author}"></input></td>
							</tr>
							<tr>
								<th scope="row">글 내용</th>
								<td><textarea name="contents" cols="45"
										rows="10
                            ">${board[0].content}</textarea></td>
							</tr>
							<tr>
								<th colspan="2" scope="row"><input type="button" value="등록"
									onclick="writeCheck();"> <input type="button"
									value="삭제"
									onClick="location.href='main.do?main_action=board_delete&num=${board[0].num}';">
									<input type="button" value="취소" onclick="fadelayer();"></th>
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