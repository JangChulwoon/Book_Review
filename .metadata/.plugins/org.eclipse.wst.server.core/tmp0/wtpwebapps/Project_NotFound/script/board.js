/**
 * 
 */
// 여기서 작성중 빈 부분이 있나 확인 ..
function writeCheck() {
	var form = document.writeFrom;

	if (!form.subject.value) {
		alert("제목을 입력해 주세요!");
		form.subject.focus();
		return;
	}

	if (!form.bookname.value) {
		alert("책 제목을 입력해 주세요!");
		form.bookname.focus();
		return;
	}

	if (!form.contents.value) {
		alert("내용을 입력해 주세요!");
		form.contents.focus();
		return;
	}

	form.submit();
}

function delet(dbid, sessionid, num) {
	if (dbid == sessionid) {
		location.href("/");
	}
	console.log(dbid);

}

/**
 * 업데이트 창을 띄우기위해 긁어옴 ..
 */

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