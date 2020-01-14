/**
 * 정규표현식에 의한 데이터 검색
 */

//js 패턴 객체
var title_RegEx = /^.{4,100}$/;
var content_RegEx = /^.{4,1000}$/;
var writer_RegEx = /^.{2,10}$/;

// 오류메시지
var title_err_msg = "제목은 4글자 이상 100글자 이내로 작성하셔야 합니다.";
var content_err_msg = "내용은 4글자 이상 1000글자 이내로 작성하셔야 합니다.";
var writer_err_msg = "작성자는 2글자 이상 10글자 이내로 작성하셔야 합니다.";

//데이터를 검사하는 함수
function inputDataCheck(reg, data, err_msg){
	//data 체크
	// 앞뒤공백제거
	//reg:정규표현식, data : 입력란의 id, err_msg:오류 메세지
	$(data).val($(data).val().trim());
//		alert("["+$("#title").val()+"]");
	if(!reg.test($(data).val())){
		//경고창을 띄운다.
		alert(err_msg);
		//다시 제목을 입력할 수 있도록 제목 입력란에 커서를 위치시킨다.
		$(data).focus();
		return false;
	}
	//위에 데이터에 오류가 있는 경우처리, 아래 데이터가 유효함으로 true를 리턴하게 한다.
	return true;
}
