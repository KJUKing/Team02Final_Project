<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Navbar -->

          <nav id="layout-navbar" class="layout-navbar container-xxl navbar navbar-expand-xl ">
<!--             class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme" -->
<!--             id="layout-navbar"> -->
          
<!--             <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none"> -->
<!--               <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)"> -->
<!--                 <i class="bx bx-menu bx-sm"></i> -->
<!--               </a> -->
<!--             </div> -->

            <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
<!--               Search -->
              <div class="navbar-nav align-items-center">
                <div class="nav-item d-flex align-items-center">
                  <i class="bx bx-search fs-4 lh-0"></i>
                  <input
                    type="text"
                    class="form-control border-0 shadow-none"
                    placeholder="Search..."
                    aria-label="Search..."
                  />
                </div>
              </div>
<!--               /Search -->

		

              <ul class="navbar-nav flex-row align-items-center ms-auto">
<!--                 Place this tag where you want the button to render. -->
			
		
			<!--  알림 벨-->
			
			<li class="nav-item drop-down position-relative">
			    <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
			        <i class="bx bx-bell bx-tada-hover "></i>
			        <span class="badge bg-primary badge-number">4</span>
			    </a>
			
			<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications"> <!--  js 실행 안됨. 점검 해볼 것 . -->
            <li class="dropdown-header">
              n개의 새로운 알림이 있습니다.
              <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
				<!-- 알림 드롭다운 후 들어갈 내용.  -->
					<li class="notification-item d-flex align-items-center"><i
						class="bx bx-info-circle bx-md me-3"></i> <!-- 아이콘 왼쪽 정렬 -->
						<div>
							<h6 class="mb-1">Lorem Ipsum</h6>
							<p class="mb-0 text-muted">Quae dolorem earum veritatis
								oditseno</p>
							<small class="text-muted">30 min. ago</small>
						</div></li>

					<li>
						<hr class="dropdown-divider">
					</li>

					<li class="notification-item d-flex align-items-center"><i
						class="bx bx-x-circle bx-md text-danger me-3"></i> <!-- 아이콘 왼쪽 정렬 -->
						<div>
							<h6 class="mb-1">Atque rerum nesciunt</h6>
							<p class="mb-0 text-muted">Error autem adipisci est
								praesentium</p>
							<small class="text-muted">1 hr. ago</small>
						</div></li>


				</ul>
			
			
			
			
             </li>   
             <!--  알림 벨 끝 -->  
                
<!-- 				nav 의 dropdown 옵션  메뉴  -->
                <li class="nav-item navbar-dropdown dropdown-user dropdown">
                
                  <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                    <div class="avatar avatar-online">
                      <img src="${pageContext.request.contextPath}/resources/sneat-1.0.0/assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
                    </div>
                  </a>
                  <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                      <a class="dropdown-item" href="#">
                        <div class="d-flex">
                          <div class="flex-shrink-0 me-3">
                            <div class="avatar avatar-online">
                            <!-- 로그인한 사용자의 사진이 들어가야함. -->
                              <img src="${pageContext.request.contextPath}/resources/sneat-1.0.0/assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
                            </div>
                          </div>
                          <div class="flex-grow-1">
                            <span class="fw-semibold d-block">John Doe</span> <!-- 이름  -->
                            <small class="text-muted">Admin</small> <!-- 직책  -->
                          </div>
                        </div>
                      </a>
                    </li>
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        <i class="bx bx-user me-2"></i>
                        <span class="align-middle">My Profile</span>
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        <i class="bx bx-cog me-2"></i>
                        <span class="align-middle">Settings</span>
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        <span class="d-flex align-items-center align-middle">
                          <i class="flex-shrink-0 bx bx-credit-card me-2"></i>
                          <span class="flex-grow-1 align-middle">Billing</span>
                          <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a class="dropdown-item" href="auth-login-basic.html">
                        <i class="bx bx-power-off me-2"></i>
                        <span class="align-middle">Log Out</span>
                      </a>
                    </li>
                  </ul>
                </li>
<!--                 / User -->
              </ul>
            </div>
          </nav>

          <!-- / Navbar -->