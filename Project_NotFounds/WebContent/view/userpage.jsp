<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
         <!-- ajax -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	  
        <title>UserPage</title>
        <link rel="stylesheet" type="text/css" href="../resources/css/userpage.css">

    </head>
    <body>
        <div class="wrap">
        	<h1 class ="title">
            	<a href = "/Busking">
                	<img class = "logo_img" src="/Busking/resources/img/white_logo.png"></img>
            	</a>
       		</h1>
            <div class ="teaser">
                <div class="teaser_img" style="background-image: url(${background});">
   					
   					<form id="backsubForm" enctype="multipart/form-data">
   						<input type ="text" id ="page_id" value = '${id}' style="display: none"/>
   						<input type="file" id = "input_backimg" capture="camera" accept="image/*" style ="display: none">
                    </form>
                  	<c:if test="${id eq sessionScope.id}">
					   <div class ="user_backimg">
	                        <a class = "back_img">
	                        	<i class="fa fa-camera fa-2x" aria-hidden="true"></i>
	                        </a>
	                   </div>
                   	</c:if>
                </div>
            </div>
            <header class="user_header">
               	<form id="prosubForm" enctype="multipart/form-data">
               		<input type ="text" id ="page_id" value = "${id}" style="display: none"/>
   					<input type="file" id = "input_proimg" capture="camera" accept="image/*" style ="display: none">
                </form>
                <a class="user_img" style="background-image: url(${profile})"></a>               
                <h1 class="user_title">${info[1] }</h1>
                <h2 class="user_subtitle">${info[0] }</h2>
                <div class ="user_sns">
                    <a href = ""><i class="fa fa-facebook fa-1x" aria-hidden="true"></i></a>
                    &nbsp  &nbsp  &nbsp
                    <a href = ""><i class="fa fa-twitter fa-1x" aria-hidden="true"></i></a>
                </div>
	            <div class ="user_paly">
		            <c:if test="${id eq sessionScope.id}">
		            	<c:if test = "${info[2] ==0 }">
		            		<a id ="perform_start"  ><i class="fa fa-play fa-1x" aria-hidden="true"></i>&nbsp &nbsp 공연 시작/예약</a>
		            	</c:if>
		            	<c:if test = "${info[2] ==1 }">
							<a id ="perform_end"  ><i class="fa fa-pause fa-1x" aria-hidden="true"></i>&nbsp &nbsp 공연 정지</a>
		            	</c:if>
		 			</c:if>
	            </div>
            </header>
            <div class="contents">
                <h2>Perform State
                </h2>
                <div class ="line" id="line"> 
                	<div class ="list" id = "recentlist">
		        		<a>
		        			최근 공연 기록이 없습니다.
		        		</a>
		        	</div>
		        	<div class ="list" id = "upcomminglist">
		        		<a>
							예정된 공연이 없습니다.  공연을 등록해주세요
						</a>
		        	</div>
				
    		    </div>
            </div>
            
            <div class="contents">
                <h2>Please Singing ! (count 10) 
	                <c:if test="${id eq sessionScope.id}">
	                	<i style = "cursor: pointer;" id = "sing_edit" class="fa fa-pencil" aria-hidden="true"></i>
	                </c:if>
                </h2>
                <div class ="line" id="line"> 
                	<form style ="display:none;" id = "sing_form">
                		<input type = "text" placeholder = "title" id="song_title"/>
                		<input type = "text" placeholder = "singer" id="sing_singer"/>
                		<input type ="text" id ="song_user" value = "${id}" style="display: none"/>
                		<input type = "button" value="저장" id ="sing_submit"/>
                	</form>
                	<p id = "errormessage"></p>
                	<div id ="song_list">
		                <c:forEach var="item" items="${songlist}" varStatus="status">
			                <a class ="song_idx" onclick = "recom_count(${item.song_idx});">
				                <table>
				                     <tr>
				                         <td class ="music_icon"><i class="fa fa-music" aria-hidden="true"></i></td>
				                         <td class="music_name"><p class ="music_fonts">${item.song_name} </p></td>
				                         <td><p class="music_singer">${item.song_singer}</p></td>
				                     </tr>
				                 </table>
				            </a>
						</c:forEach>
						<c:if test="${fn:length(songlist) eq 0 }">
							<a class ="song_idx">
								등록된 음악이 없습니다. 음악을 등록해주세요  
							</a>
						</c:if>
					</div>
    		    </div>
            </div>
<!--             <div class="contents">
                <h2>Play music (more button) </h2>
                <iframe width="100%" height="166" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/232401489&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false"></iframe>
               <iframe width="100%" height="166" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/94675240&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false"></iframe>
            </div> -->
            
            <div class="contents">
                <h2>poto </h2>
               <section class="thumbnails">
    					<div>
    						<a href="">
    							<img src="/Busking/resources/img/flex_img/flex1.jpg" alt="" />
    							<h3>당황하지 마세요</h3>
    						</a>
    						<a href="">
    							<img src="/Busking/resources/img/flex_img/flex2.jpg" alt="" />
    							<h3>우주를 줄게  </h3>
    						</a>
    					</div>
    					<div>
    						<a href="">
    							<img src="/Busking/resources/img/flex_img/flex3.jpg" alt="" />
    							<h3>팬 페이지</h3>
    						</a>
    						<a href="">
    							<img src="/Busking/resources/img/flex_img/flex4.jpg" alt="" />
    							<h3>심술</h3>
    						</a>
    						<a href="">
    							<img src="/Busking/resources/img/flex_img/flex5.jpg" alt="" />
    							<h3>반지</h3>
    						</a>
    					</div>
    					<div>
    						<a href="">
    							<img src="/Busking/resources/img/flex_img/flex6.jpg" alt="" />
    							<h3>아닙니다</h3>
    						</a>
    						<a href="">
    							<img src="/Busking/resources/img/flex_img/flex1.jpg" alt="" />
    							<h3>singer</h3>
    						</a>
    					</div>
    				</section>
            </div>
            <div class="contents">
                <h2>location </h2>
                daum map
            </div>
            <div class="contents">
                <h2>comment </h2>
                ....?
            </div>
        </div>
        
        
  
            
            
        <!-- script -->
        

	    
	    <!--  userpage script -->
	    <script type="text/javascript" src="../resources/js/userpage.js"></script>
	    
	
		
    </body>
    
</html>