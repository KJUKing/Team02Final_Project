/**
 * 
 */


const myJoinModal = new bootstrap.Modal('#joinModal');
const myFindPassModal = new bootstrap.Modal('#passFindModal');
const mySmsModal = new bootstrap.Modal('#smsModal');

function openJoinModal() {
	myJoinModal.show();
}

function openFindPassModal() {
	myFindPassModal.show();
}

function openSmsModel() {
	mySmsModal.show();
}

document.addEventListener("DOMContentLoaded", () => {
	mySmsModal.show();
	const contextPath = document.body.dataset.contextpath;
	const pathName = window.location.pathname; // /work2gether/a001/login 이런식으로 들어옴
	const regex = /\/work2gether\/([^/]+)/i;	// 정규식 /work2gether/{여기의 값을 꺼내옴}/이후 뎁스
	const match = pathName.match(regex);
	let companyId;
	if (match && match[1]) {
		companyId = match[1];
	} else {
		console.log("No match found");
	}


	// 회원가입 시 이메일 등록되어있는지 확인하는 form 태그
	const joinModalForm = document.querySelector('#join-modal-form');
	// 문자인증 문자 요청 form 태그
	const smsModalsModalForm = document.querySelector('#sms-modal-formm');
	// 문자인증 확인 form 태그
	const authCheckForm = document.querySelector('#auth-check-form');
	// 비밀번호 찾기 요청 form 태그
	const findPassModalForm = document.querySelector('#find-modal-form');


	// 회원가입 시 이메일 등록되어있는지 확인하는 form 태그의 submit 핸들러
	joinModalForm.addEventListener("submit", e => {
		e.preventDefault();
		let url = `${contextPath}/${companyId}/mailCheck`;
		joinModalForm.action = url;
		joinModalForm.submit();
	});

	// 문자인증 문자 요청 form 태그의 submit 핸들러
	smsModalsModalForm.addEventListener("submit", e => {
		e.preventDefault();
		let url = `${contextPath}/${companyId}/login/sendAuthCode`;

		// 비동기 요청으로 form 태그에 작성된 정보들을 controller로 전송
		// controller에서는 해당 정보를 가지고 data base의 값과 비교
		//   ==> data base에 있는 정보면 문자 전송 / 아니면 return redirect
		



	})




})