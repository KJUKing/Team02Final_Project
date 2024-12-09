/**
 * 
 */


const myJoinModal = new bootstrap.Modal('#joinModal');
const myFindPassModal = new bootstrap.Modal('#passFindModal');

function openJoinModal() {
	myJoinModal.show();
}

function openFindPassModal() {
	myFindPassModal.show();
}

document.addEventListener("DOMContentLoaded", () => {
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

	// 비밀번호 찾기 요청 form 태그
	const findPassModalForm = document.querySelector('#find-modal-form');

	// 회원가입 시 이메일 등록되어있는지 확인하는 form 태그의 submit 핸들러
	joinModalForm.addEventListener("submit", e => {
		e.preventDefault();
		let url = `${contextPath}/${companyId}/mailCheck`;
		joinModalForm.action = url;
		joinModalForm.submit();
	});

	findPassModalForm.addEventListener("submit", async (e) => {
		e.preventDefault();
		let url = `${contextPath}/${companyId}/findPW`;
		let resp = await fetch(url, {
			method: "post",
			body: new URLSearchParams(new FormData(findPassModalForm))
		});

		if (resp.ok) {
			Swal.fire({
				title: "임시비밀번호가 발송 완료",
				text: "입력하신 이메일로 임시 비밀번호가 발송되었습니다. 확인해주세요!",
				icon: "success"
			});

		} else {
			let message = await resp.text();
			Swal.fire({
				title: "실패",
				text: message,
				icon: "error"
			});
		}

	})

})