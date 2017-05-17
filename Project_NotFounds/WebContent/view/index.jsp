<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>BookClip</title>

	
<!-- facebook -->
<script type="text/javascript" src="/NotFound/resources/js/facebookscript.js"></script>

<!-- Bootstrap Core CSS -->
<link href="/NotFound/resources/css/bootstrap.min.css" rel="stylesheet">

<!--  Custom Js -->
<script type="text/javascript" src="/NotFound/resources/js/index.js"></script>

<!-- Custom CSS -->
<link href="/NotFound/resources/css/landing-page.css" rel="stylesheet">
<link href="/NotFound/resources/css/style.css" rel="stylesheet">

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
				<a class="navbar-brand topnav" href="#">Start Bootstrap</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#about">About</a></li>
					<li><a href="#services">Services</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<!-- Header -->
	<a name="about"></a>
	<div class="intro-header">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="intro-message">
						<h1>Book Clip</h1>
						<h3>보고있는 책을 기록해보세요</h3>
						<hr class="intro-divider">
						<!--  로그인 form -->
						<form class="form-horizontal" action="/NotFound/index.do" method="post" name ="login">
							<input type="hidden" name="action" value="login">
							<ul class="list-inline intro-social-buttons">
								<li>
									<div class="col-sm-14">
										<input type="text" id="userid" name="userid" class="form-control" placeholder="ID" style="min-width: 20em;">
									</div>
								</li>
							</ul>
							<ul class="list-inline intro-social-buttons">
								<li>
									<div class="col-lg-14">
										<input type="password" id="userpd" name="userpd" class="form-control" placeholder="PW" style="min-width: 20em;">
									</div>
								</li>
							</ul>
							<br>
							<ul class="list-inline intro-social-buttons">
								<li>
									<button onclick="submit()" type  ="submit" class="btn btn-default btn-lg box_size" >
										<i class="fa fa-play fa-fw"></i> 
										<span class="network-name">Login</span>
									</button>
									<a class="btn btn-default btn-lg box_size" data-target="#layerpop" data-toggle="modal">
											<i class="fa fa-cog fa-fw"></i> 
											<span class="network-name">Join</span>
									</a>
									<a onclick="checkLoginState();" class="btn btn-default btn-lg box_size">
										<i class="fa fa-facebook fa-fw"></i> 
										<span class="network-name">Facebook</span>
									</a>
								</li>
							</ul>
						</form>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.intro-header -->

	<!-- Page Content -->

	<a name="services"></a>
	<div class="content-section-a">

		<div class="container">
			<div class="row">
				<div class="col-lg-5 col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Death to the Stock Photo:<br>Special Thanks
					</h2>
					<p class="lead">
						A special thanks to <a target="_blank" href="http://join.deathtothestockphoto.com/">Death to the
							Stock Photo</a> for providing the photographs that you see in this
						template. Visit their website to become a member.
					</p>
				</div>
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
					<img class="img-responsive" src="/NotFound/resources/img/ipad.png" alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-a -->

	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						3D Device Mockups<br>by PSDCovers
					</h2>
					<p class="lead">
						Turn your 2D designs into high quality, 3D product shots in
						seconds using free Photoshop actions by <a target="_blank"
							href="http://www.psdcovers.com/">PSDCovers</a>! Visit their
						website to download some of their awesome, free photoshop actions!
					</p>
				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
					<img class="img-responsive" src="/NotFound/resources/img/dog.png" alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-section-b -->

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
				<div class="col-lg-5 col-lg-offset-2 col-sm-6">
					<img class="img-responsive" src="/NotFound/resources/img/phones.png" alt="">
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
    <div class="modal-content">
      <!-- header -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <!-- header title -->
        <h4 class="modal-title">Join</h4>
      </div>
      <!-- body -->
      <div class="modal-body">
		<form class="form-horizontal joinform" id = "join-form" action="/NotFound/index.do" method="post">
			<input type="hidden" name="action" value="join">
			<ul class="list-inline intro-social-buttons">
				<li>
					<div class="col-lg-14 join-input">
						<div class = "join-span">
							<span>Name : </span>
						</div>
						<input type="text"  name="joinname" class="form-control" placeholder="Name" style="min-width: 20em;">
					</div>
				</li>
			</ul>
			<ul class="list-inline intro-social-buttons">
				<li>
					<div class="col-sm-14 join-input">
						<div class = "join-span">
							<span>ID : </span>
						</div>
						<input type="text" id = "joinid" name=joinid class="form-control" placeholder="ID" style="min-width: 20em;">
						<label id="result_id_msg" >5자 이상의 아이디를 입력해주세요.</label>
					</div>
				</li>
			</ul>
			<ul class="list-inline intro-social-buttons">
				<li>
					<div class="col-lg-14 join-input">
						<div class = "join-span">
							<span>PW : </span>
						</div>
						<input type="password"  name="joinpass" id = "pass" class="form-control" placeholder="PW" style="min-width: 20em;">
					</div>
				</li>
			</ul>
			<ul class="list-inline intro-social-buttons">
				<li>
					<div class="col-lg-14 join-input">
						<div class = "join-span">
							<span>Re : </span>
						</div>
						<input type="password" id = "re-pass"  class="form-control" placeholder="PW" style="min-width: 20em;">
						<label id="result_pass_msg" ></label>
					</div>
				</li>
			</ul>
			<br>
		</form>
      </div>
      <!-- Footer -->
      <div class="modal-footer">
       	<button type="button" class="btn btn-default" id = "joinbtn" disabled = "true" >Join</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>




	<!--  jquery-->
	<script src="//code.jquery.com/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/NotFound/resources/js/bootstrap.min.js"></script>

<script>


	$().ready(function(){
		
		
		var idcheck = 0;
		var passcheck= 0;
		var checkAjaxSetTimeout;
		function joinCheck(){
			console.log(idcheck && passcheck);
			if(idcheck && passcheck){
				$("#joinbtn").attr('disabled',false);
			}else{
				$("#joinbtn").attr('disabled',true);
			}
		}
		$('#joinbtn').on('click',function(){
			$('#join-form').submit();
		});
		
		$('#re-pass, #pass').keyup(function(){
			var pass = $('#pass').val();
			var re_pass = $('#re-pass').val();
			if(pass != ''&&pass == re_pass)
			{
			    $("#result_pass_msg").html("비밀번호가 일치합니다.");
                //$("#joinbtn").attr('disabled',false);
                passcheck =1 ;
			}else{
				 $("#result_pass_msg").html("비밀번호가 일치하지않습니다.");
	             //$("#joinbtn").attr('disabled',true);
				 passcheck =0;
			}
			joinCheck();
		});
		
	
		$('#joinid').keyup(function(){
		    clearTimeout(checkAjaxSetTimeout);
		    checkAjaxSetTimeout = setTimeout(function(){
		        if ( $('#joinid').val().length > 4) {
		            var id = $("#joinid").val();
		            $.ajax({
		                type : 'POST',
		                url : '/NotFound/idcheck.do',
		                data:
		                    {
		                        id: id
		                    },
		                success : function(result) {
		                    console.log(result.check);
		                    if ("ok" === result.check) {
		                        $("#result_id_msg").html("사용가능한 아이디입니다.");
		                        idcheck = 1;
		                        //$("#joinbtn").attr('disabled',false);
		                    } else {
		                        $("#result_id_msg").html("사용 불가능한 아이디 입니다.");
		                        idcheck = 0;
		                        //$("#joinbtn").attr('disabled',true);
		                    }
		                    joinCheck();
		                },
		                error : function(request,status,error){
		                    
		                }
		            }); // end ajax
		        }
		    },100);
		}); // end keyup
	});


</script>
</body>
</html>