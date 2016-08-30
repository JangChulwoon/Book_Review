
function layer_open(el) {

	var temp = $('#' + el);
	var bg = temp.prev().hasClass('bg'); // dimmed 레이어를 감지하기 위한 boolean 변수

	if (bg) {
		$('.layer').fadeIn(); // 'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다.
	} else {
		temp.fadeIn();
	}

	// 화면의 중앙에 레이어를 띄운다.
	if (temp.outerHeight() < $(document).height())
		temp.css('margin-top', '-' + temp.outerHeight() / 2 + 'px');
	else
		temp.css('top', '0px');
	if (temp.outerWidth() < $(document).width())
		temp.css('margin-left', '-' + temp.outerWidth() / 2 + 'px');
	else
		temp.css('left', '0px');

	temp.find('a.btn').click(function(e) {
		if (bg) {
			$('.layer').fadeOut(); // 'bg' 클래스가 존재하면 레이어를 사라지게 한다.
		} else {
			temp.fadeOut();
		}
		e.preventDefault();
	});

	$('.layer .bg').click(function(e) { // 배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
		$('.layer').fadeOut();
		e.preventDefault();
	});

}
function fadelayer() {
	$('.layer').fadeOut();
	e.preventDefault();
}

function insert_Clear() {
	var userId = document.insertUser.joinid.value;
	var idcheck =  document.getElementById('joinid');
	var check_Id = /^[a-zA-Z0-9]*$/;
	var pwd = document.insertUser.joinpass.value;
	var userName = document.insertUser.joinname.value;
	if (!userId) {
		alert("아이디를 입력해주세요");
	} else if (!pwd) {
		alert("비밀번호를 입력해주세요");
	} else if (!userName) {
		alert("사용자 이름을 입력해주세요");
	} else if (!idcheck.readOnly) {
		alert('중복확인을 해주세요');
	} else {
		document.insertUser.submit();
	}

}
/**
 * 패스워드 체크 스크립트
 */
function pass_Check() {
	var pwd1 = document.insertUser.joinpass.value;
	var pwd2 = document.insertUser.joinrepass.value;

	if (pwd1 != pwd2) {
		document.insertUser.pwdCheck.value = "비밀번호가 일치하지 않습니다.";
	} else {
		document.insertUser.pwdCheck.value = "";
	}
	return;
}
/**
 * 여기부터 아이디체크 부분 스크립트 
 * @param id
 */

function checkID(id) {
	if (id.length == 0) {
		alert("아이디를 정확히 입력해주세요");
	} else {
		var url = "/NotFound/idcheck.do?id=" + id;
		window
				.open(url, "get",
						"height = 240, width = 320, resizable=no, location=no, resizable=no");
	}
}

function sendMeData(){
	
	  var id = document.getElementById('joinid') ;
	  id.readOnly = true ;
}

function useid(){
  window.opener.sendMeData()
  window.close();
}
/**
 * 북 검색 부분 스크립트  
 * @param id
 */

function booksearch() {
		var url = "/NotFound/view/check/booksearch.jsp";
		window
				.open(url, "get",
						"height = 240, width = 1000, resizable=no, location=no, resizable=no");
}

function sendMeDatabook(title,img,author,publisher,year,description){
	
	document.getElementById('bookname').value=title;
	document.getElementById('bookname').readOnly = true;
	document.getElementById('book_img').value=img;
	document.getElementById('author').value=author;
	document.getElementById('author').readOnly = true;
	document.getElementById('publisher').value=publisher;
	document.getElementById('publication_date').value=year;
	document.getElementById('description').value=description;
	
}

function book_imp(title,img,author,publisher,year,description){
	window.opener.sendMeDatabook(title,img,author,publisher,year,description)
	window.close();

}