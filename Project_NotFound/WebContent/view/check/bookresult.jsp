<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/NotFound/script/board.js"></script>
<script type="text/javascript" src="/NotFound/script/popup.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
	   <c:forEach var="i" begin="0" end="${value[5][5]}" step="1">
	   
		<tr>
			<td rowspan="2"><img alt="" src="${value[i][1]}"></td>
			<td><a href="" onclick="book_imp('${value[i][0]}','${value[i][1]}','${value[i][3]}','${value[i][5]}','${value[i][4]}','${value[i][2]}')">제목 : ${value[i][0]}</a></td>
			<td>저자 : ${value[i][3]} </td>
		</tr>
		<tr>
			<td>출판사 :${value[i][5]} </td>
			<td>출판 년도 : ${value[i][4]}</td>
		</tr>
		<tr>
			<td colspan="3">${value[i][2]}</td>
		</tr>
	
    </c:forEach>
		
	</table>
</body>
</html>