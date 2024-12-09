<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://cdn.jsdelivr.net/npm/apextree"></script>
<style>
#organiTree {
	position: relative; /* 또는 absolute */
	display: flex;
	justify-content: center;
	position: relative;
	align-items: center;
	z-index: 10; /* sidebar보다 높은 값 */
	border: 1px solid black;
	width: 1325px;
	height: 700px;
	background-color: #f6f6f6;
/* 	margin: 0 auto; /* 화면 가운데 정렬 */ 
	margin-bottom : 140px;
	overflow: hidden;
}

</style>


<div id="searchName">
		<input type="text" id="empName" name="empName" placeholder="사원명 검색" style="margin-left:160px;"/>
		<button class="btn btn-primary">검색</button>
</div>

<div id="searchEmployeeModal" class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel">직원 조회 결과</h3>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div id="searchModalBody" class="modal-body">
       
      </div>
    </div>
  </div>
</div>


	

<!-- <h4>조직도</h4> -->
<div class="d-flex justify-content-center align-items-center"
	style="height: 100vh;">
		
	
	<div id="organiTree"></div>   <!--  조직도 자리  -->
</div>
   	<!-- 직원 정보가 모달로 띄워짐 -->
<div id="employeeModal" class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel">직원 상세 정보</h3>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div id="modalBody" class="modal-body">
        <!-- 비동기로 내용이 채워질 영역 -->
      </div>
    </div>
  </div>
</div>

   
   
<div class="employee-data-container">
    <table id="employeeList" class="table table-striped table-hover" style="width: 100%; text-align: center;">
        <!-- 직원 데이터가 동적으로 렌더링됩니다 -->
        <thead class="innerTh"></thead>
        <tbody class="innerTbody"></tbody>
    </table> <!--  조직도의 아래에 위치하는 팀 소속 직원 -->
</div>



<script> 

document.addEventListener("DOMContentLoaded", () => {
    // 서버에서 전달받은 DEPARTMENT 데이터를 JavaScript 객체 배열로 변환
    const departmentList = [
        <c:forEach items="${organiList}" var="dept" varStatus="status">
            {
                id: "${dept.departCode}",      // 부서 코드
                name: "${dept.departName}",    // 부서 이름
                parentId: "${dept.departParentcode}" // 상위 부서 코드
            }<c:if test="${!status.last}">,</c:if>
        </c:forEach>
    ];

    /**
     * 부서 데이터를 트리 구조로 변환하는 함수
     * - 최상위 부서를 기준으로 하위 부서를 연결
     */
    function createTree(data) {
        const tree = [];   // 최상위 노드를 담을 배열
        const map = {};    // 모든 노드를 ID를 키로 저장

        // 모든 부서 데이터를 map 객체에 저장
        data.forEach(dept => {
            map[dept.id] = { ...dept, children: [] }; // 초기 children 배열 추가
        });

        // 상위 부서에 자식 노드 연결
        data.forEach(dept => {
            if (dept.parentId) {
                // parentId가 있는 경우 상위 부서의 children에 현재 노드 추가
                map[dept.parentId].children.push(map[dept.id]);
            } else {
                // 최상위 노드 (parentId가 null)
                tree.push(map[dept.id]);
            }
        });

        return tree;
    }

    // 트리 구조 생성
    const treeData = createTree(departmentList);  // createTree 는 무조건 최상의노드가 null 이어야 함. 
	console.log("부서리스트 :",departmentList);
	console.log("트리데이터 :",treeData);
    // 트리 렌더링 옵션
    const options = {
        width: 1325,            // 트리의 너비
        height: 700,            // 트리의 높이
        nodeWidth: 150,         // 각 노드의 너비
        nodeHeight: 90,        // 각 노드의 높이
        childrenSpacing: 50,    // 부모와 자식 간의 간격
        siblingSpacing: 40,     // 형제 노드 간의 간격
        direction: 'top'        // 트리 방향: 위에서 아래로
    };

    // 트리 렌더링
    const tree = new ApexTree(document.getElementById('organiTree'), options);
    tree.render(treeData[0]); // 최상위 노드를 기준으로 렌더링
});
</script>

<script>const companyId = "${companyId}"
		const contextPath = "${pageContext.request.contextPath}";
</script>

<script src="${pageContext.request.contextPath }/resources/js/organi/organiTree.js"></script>
