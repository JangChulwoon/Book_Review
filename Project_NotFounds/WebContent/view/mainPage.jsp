<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>BookClip</title>


<!-- Bootstrap Core CSS -->
<link href="/NotFound/resources/css/bootstrap.min.css" rel="stylesheet">


<!--  jquery ui  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<!--  Custom Js -->
<script type="text/javascript" src="/NotFound/resources/js/index.js"></script>

<!-- Custom CSS -->
<link href="/NotFound/resources/css/landing-page.css" rel="stylesheet">
<link href="/NotFound/resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/NotFound/resources/css/userpage.css">

<!-- Custom Fonts -->
<link href="/NotFound/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">



</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container topnav">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand topnav" href="./">BookClip</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#services">Boarder</a></li>
					<li><a href="#contact">myPage</a></li>
					<li><a href="#" onclick="location.href='index.do?action=logout';">logout</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Header -->
	<div class ="teaser">
		<div class="teaser_img" style="background-image: url(/NotFound/resources/img/googleimg_cafe.jpg);">
		
		</div>
	</div>
    <header class="user_header">
       	<form id="prosubForm" enctype="multipart/form-data">
			<input type ="text" id ="page_id" value = "${id}" style="display: none"/>
			<input type="file" id = "input_proimg" capture="camera" accept="image/*" style ="display: none">
        </form>
        <a class="user_img" style="background-image: url(/NotFound/resources/img/dog.png)"></a>     
        <h1 class="user_title">${name}</h1>
        <h2 class="user_subtitle">${id}</h2>
    	<hr style="width: 300px; border-top: 2px solid #d6d3d3;"> 
    </header>
	<div class="content-section-a">
		<div class="container">
			<div class = "book-btn">
				<a class="btn btn-default"  data-target="#layerpop" data-toggle="modal">책 등록</a>
			</div>
			<div class="row">
				<div class="col-lg-12  col-lg-offset-1">
					<table class="table table-hover">
						<tr>
							<th width="50%" scope="col">책제목</th>
							<th width="25%" scope="col">상태</th>
							<th width="25%" scope="col">날짜</th>
						</tr>
						<c:choose>
							<c:when test="${fn:length(clip) == 0}">
								<tr>
									<td colspan="3">
										<p>읽고싶은, 읽고있는, 읽은 책을 기록하세요.</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="i" begin="0" end="${fn:length(clip)-1}"
									step="1">
									<tr>
										<td align="center"><a class = "bookTitle" data-target="#memo-modal" data-toggle="modal" data-index = '${clip[i].idx}'>${clip[i].title}</a></td>
										<td align="center">${clip[i].state}</td>
										<td align="center">${clip[i].date}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
							
						</c:choose>
						<%-- <tr>
							<td colspan="4" align="center"><c:choose>
								<c:when test="${ 1 eq page}">
								</c:when>
								<c:otherwise>
									<a href="/NotFound/main.do?current_page=${page-1}"
										class="btn btn-default">이전페이지</a>
								</c:otherwise>
								</c:choose> ${page} 
								<c:choose>
									<c:when test="${ page eq size}">
									</c:when>
									<c:otherwise>
										<a href="/NotFound/main.do?current_page=${page+1}"
											class="btn btn-default">다음페이지</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr> --%>
					</table>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->

	<div class="content-section-a">
		<div class="container">
			<div class="row">
				<div class="col-lg-5 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Google Web Fonts and<br>Font Awesome Icons
					</h2>
					<p class="lead">
						This template features the 'Lato' font, part of the <a
							target="_blank" href="http://www.google.com/fonts">Google Web
							Font library</a>, as well as <a target="_blank"
							href="http://fontawesome.io">icons from Font Awesome</a>.
					</p>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->

	<a name="contact"></a>
	<div class="banner">

		<div class="container">

			<div class="row">
				<div class="col-lg-6">
					<h2>Connect to Start Bootstrap:</h2>
				</div>
				<div class="col-lg-6">
					<ul class="list-inline banner-social-buttons">
						<li><a href="https://twitter.com/SBootstrap"
							class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i>
								<span class="network-name">Twitter</span></a></li>
						<li><a
							href="https://github.com/IronSummitMedia/startbootstrap"
							class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i>
								<span class="network-name">Github</span></a></li>
						<li><a href="#" class="btn btn-default btn-lg"><i
								class="fa fa-linkedin fa-fw"></i> <span class="network-name">Linkedin</span></a>
						</li>
					</ul>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.banner -->

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="list-inline">
						<li><a href="#">Home</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#about">About</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#services">Services</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="#contact">Contact</a></li>
					</ul>
					<p class="copyright text-muted small">Copyright &copy; Your
						Company 2014. All Rights Reserved</p>
				</div>
			</div>
		</div>
	</footer>

<div class="modal fade" id="layerpop" >
  <div class="modal-dialog">
    <div class="modal-content" id = "contents-pop">
      <!-- header -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <!-- header title -->
        <h4 class="modal-title">Book Clip</h4>
      </div>
      <!-- body -->
      <div class="modal-body">
		<form class="form-horizontal joinform" id = "book-form" action="/NotFound/main.do" method="post">
			<input type="hidden" name="action" value="record">
			<ul class="list-inline intro-social-buttons">
				<li>
					<div class="col-sm-14 join-input">
						<div class = "join-span">
							<span>state : </span>
						</div>
						<select class="form-control" style="min-width: 20em;" name = "state">
							<option selected="selected">상태를 선택해주세요</option>
							<option value = "HOPE">읽고싶은 책 </option>
							<option value = "ING">읽고 있는 책 </option>
							<option value = "END">다 읽은 책 </option>
						</select>
					</div>
				</li>
			</ul>
			<ul class="list-inline intro-social-buttons">
				<li>
					<div class="col-lg-14 join-input">
						<div class = "join-span">
							<span>Book Title : </span>
						</div>
						<input type="text"  id = "book_title" name="book_title" class="form-control" placeholder="Title" style="min-width: 20em;">
						
					</div>
				</li>
			</ul>
			<br>
		</form>
      </div>
      <!-- Footer -->
      <div class="modal-footer">
       	<button type="button" class="btn btn-default" id = "record" disabled = "true" >record</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="memo-modal" >
  <div class="modal-dialog">
    <div class="modal-content" id = "contents-pop">
      <!-- header -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <!-- header title -->
        <h4 class="modal-title" id = "seleted-book"></h4>
      </div>
      <!-- body -->
      <div class="modal-body">
      	<div class = "memo-reple">
	      	<ul class="list-inline intro-social-buttons memo">
				<li class = "memo-contents">
					
				</li>
			</ul>
		</div>
		<form class="form-horizontal joinform" id = "memo-form" action="/NotFound/main.do" method="post">
			<input type="hidden" name="action" value="memo">
			<input type="hidden"  name="index" >	
			<ul class="list-inline intro-social-buttons">
				<li>
					<div class="col-lg-14 join-input">
						<div class = "join-span">
							<span>Memo : </span>
						</div>
						<div class = "form-inline">
							<input type="text"  id = "memo" name="memo" class="form-control" placeholder="Memo" style="min-width: 30rem;">
							<button type="button" id = "memo-record"class="btn btn-default">Record</button>
						</div>
					</div>
				</li>
			</ul>
			<br>
		</form>
      </div>
      <!-- Footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


	<!--  jquery-->
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="/NotFound/resources/js/bootstrap.min.js"></script>
	
	<script>
	$(function(){
		// 북 제목 입력시 record 버튼 활성화
		$("#book_title").keyup(function(){
			if($("#book_title").val() !=''){
				$("#record").attr('disabled',false);
			}else{
				$("#record").attr('disabled',true);
			}
		});
		
		
		// jquery ui 를 이용하여 자동완성
	    $( "#book_title" ).autocomplete({
	        source : function( request, response ) {
	             $.ajax({
	                    type: 'get',
	                    url: "daumsearch.do?booksearch="+$('#book_title').val(),
	                    dataType: "json",
	                    success: function(data) {
	                        response(
	                            $.map(data, function(item) {
                                	return {
                                		label  : item.title,
                                		value : item.title
                                	}
                                	
	                            })
	                        );
	                    }
	               });
	            },
	        //조회를 위한 최소글자수
	        minLength: 2,
	        select: function( event, ui ) {
	        	$("#record").attr('disabled',false);
	        }
	    });
	    
	    // 해당 form 에 추가함 . 
	    $( "#book_title" ).autocomplete( "option", "appendTo", "#book-form" );
	    $("#record").on("click",function(){
	    	$('#book-form').submit();
	    	
	    });
	    
	    // submit memo
	    $("#memo-record").on("click",function(){
	    	$('#memo-form').submit();
	    });
	    
	    //seleted-book
	    //bookTitle
	    $(".bookTitle").on("click",function(){
	    	var index = $(this).data('index');
	    	$("#seleted-book").text($(this).text());
	    	$("input[name=index]").attr("value",index);
	    	$(".memo > .memo-contents").remove();
	    	// ajax로 가쟈오는 부분
	        $.ajax({
                type: 'get',
                url: "memo.do?num="+index,
                dataType: "json",
                success: function(data) {
                	if(data.length == 0){
                		$(".memo-reple").append('<ul class="list-inline intro-social-buttons memo">'
            					+'<li class = "memo-contents">책에 대한 메모를 남길 수 있습니다.</li>'
            				+'</ul>');
                	}else{
                		for(obj in data){
                			$(".memo-reple").append('<ul class="list-inline intro-social-buttons memo">'
                					+'<li class = "memo-contents">'
                						+data[0].content 
                					+'</li>'
                					+'<li class = "memo-contents">'
                						+data[0].date 
                					+'</li>'
                				+'</ul>');
                		}
                	}
                }
           });
	    	
	    });
	});
	</script>


</body>
</html>