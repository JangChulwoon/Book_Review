<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="/NotFound/script/popup.js"></script>
<title>id check</title>
</head>
<body>
	<c:choose>
		<c:when test="${check == 1}"> ID Ok.<br>
		<form action="#" id="myform" name="myform"></form>
			<input type="button" value="use" id="sender" name="sender"
				onclick="useid();" />
	
		 </c:when>
		<c:otherwise> ID already... </c:otherwise>
	</c:choose>

</body>
</html>