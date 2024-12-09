/**
 * 
 */

document.addEventListener("DOMContentLoaded", ()=>{
	const editBtn = document.getElementById("editBtn");
	const delBtn = document.getElementById("delBtn");
	
	editBtn.addEventListener("click", () => {
	    const dataSrcPath = editBtn.getAttribute("data-src-path");
	        window.location.href = dataSrcPath; // 해당 URL로 이동
	});
	
	delBtn.addEventListener("click", ()=>{
		const dataDelPath = delBtn.getAttribute("data-del-path");
		fetch(dataDelPath, "delete");
	});
	
});