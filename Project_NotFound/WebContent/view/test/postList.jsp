<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <title>PU-</title>
    <link href="/NotFound/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="/NotFound/css/styles.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" rel="home" href="#">Pu-</a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">


        </ul>
    </div>
</nav>
<!--left-->
<div class="sid_bar">

    <div class="side_bar">
        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
        ${name}  <a href="sessionremove" class="btn btn-Link" >로그아웃</a>
        <hr>


    </div>
</div>
<!--/left-->

<div class="main_table">
    <!--center-->
    <div class="col-sm-8">

        <div class="row" style="margin-top:5%;margin-left: 3%">
            <button type="button" class="btn btn-primary"
                    onclick="location.href='/postCategory?itemCategory=<%=URLEncoder.encode("도서","utf-8")%>' "><span
                    class="
            glyphicon glyphicon-book" aria-hidden="true"></span>도서
            </button>
            <button type="button" class="btn btn-success"
                    onclick="location.href='/postCategory?itemCategory=<%=URLEncoder.encode("전자제품","utf-8")%>' "><span
                    class="glyphicon glyphicon-camera" aria-hidden="true"></span>전자제품
            </button>
            <button type="button" class="btn btn-warning" style="height: 34px;
            " onclick="location.href='/postCategory?itemCategory=<%=URLEncoder.encode("의류","utf-8")%>' "><span
                    class="glyphicon glyphicon-shopping-cart" aria-hidden="true">의류</button>
            <button type="button" class="btn btn-danger" style="
            height: 34px;"
                    onclick="location.href='/postCategory?itemCategory=<%=URLEncoder.encode("가구","utf-8")%>' "><span
                    class="
            glyphicon glyphicon-home" aria-hidden="true">가구</button>
        </div>
        <div class="row" style="margin-top:5%;">
            <div class="col-xs-12">
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <th width="10%" scope="col">번호</th>
                        <th width="15%" scope="col">분류</th>
                        <th width="15%" scope="col">작성자</th>
                        <th width="40%" scope="col">제목</th>
                        <th width="20%" scope="col">등록일</th>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0">
                    <c:forEach var="post" items="${postList}" varStatus="status">
                        <tr>
                            <td width="10%" align="center">${post.postid}</td>
                            <td width="15%" align="center">${post.category}</td>
                            <td width="15%" align="center">${post.maker}</td>
                            <td width="40%">
                                <a href="/postDetail?postId=${post.postid}">${post.title}</a>
                            </td>
                            <td width="20%" align="center">${post.makedate}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" style="text-align: right">
                            <button type="button" class="btn btn-primary"   onclick="layer_open('layer2');return false;">글 등록</button>
                        </td>
                    </tr>
                </table>
                <form action="/postSearchController" method="post" accept-charset="utf-8">
                    <select name="select">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="itemname">물품명</option>
                    </select>
                    <input type="text"  maxlength="30" name="keyword" />
                    <input type="submit" value="검색" />
                </form>
            </div>

        </div>

        <hr>

    </div>
    <!--/center-->
</div>
<!--right-->

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
</body>
</html>