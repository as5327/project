<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- jstl-1.2.jar 파일 필요 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>쌍용교육센터</title>

<!-- Bootstrap core CSS-->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath}/css/sb-admin.css"
	rel="stylesheet">

<style>
tr, th, td {
	text-align: center;
}
</style>

</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1"
			href="${pageContext.request.contextPath}/admin/admin.do"><img
			src="${pageContext.request.contextPath}/resources/img/sist_logo_reverse.png"></a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
				${sessionScope.login.admin_name}
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/admin_information/adminManagement.do">
					<i class="fas fa-fw fa-user-alt"></i> <span>관리자 정보 관리</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="pagesDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-fw fa-book"></i> <span>기초 정보 관리</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/basicInfo_management/subjectManagement.do">과목관리</a>
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/basicInfo_management/courseManagement.do">과정관리</a>
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/basicInfo_management/classManagement.do">강의실관리</a>
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/basicInfo_management/bookManagement.do">교재관리</a>
				</div></li>
			<li class="nav-item "><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/teacher_management/teacherManagement.do">
					<i class="fas fa-fw fa-user-alt"></i> <span>강사 관리</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/open_course_management/openCourse.do">
					<i class="fas fa-fw fa-paste"></i> <span>개설 과정 관리</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/open_subject_management/openSubject.do">
					<i class="fas fa-fw fa-paste"></i> <span>개설 과목 관리</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="pagesDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-address-card"></i> <span>수강생 관리</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/student_management/student_list.do">수강생
						목록</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/student_management/student_course.do">수강생
						과정 관리</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-list-alt"></i> <span>성적
						조회</span></a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/score_management/score_for_each_subject.do">개설과목별
						성적 조회</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/score_management/score_for_each_student.do">수강생별
						성적 조회</a>
				</div></li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> 관리자 정보 관리
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<c:if test="${param.result=='success'}">
								<div class="alert alert-success alert-dismissible fade show" role="alert"
									style="padding-top: 5px; padding-bottom: 5px; margin-top: 5px; margin-bottom: 5px;">
									<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
									<strong>Success!</strong> 요청한 작업이 처리되었습니다.
								</div>
							</c:if>
							<c:if test="${param.result=='fail'}">
								<div class="alert alert-danger alert-dismissible fade show" role="alert"
									style="padding-top: 5px; padding-bottom: 5px; margin-top: 5px; margin-bottom: 5px;">
									<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
									<strong>Fail!</strong> 요청한 작업이 처리되지 못했습니다.
								</div>
							</c:if>
							<div>
								<button type="button" class="btn btn-outline-primary"
									data-toggle="modal" data-target="#inputModal"
									style="margin-bottom: 0.5rem; float: right;">계정 추가</button>
							</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>등급</th>
										<th>아이디</th>
										<th>이름</th>
										<th>연락처</th>
										<th>등록일</th>
										<th>계정 잠금 상태</th>
										<th>패스워드 초기화</th>
										<th>계정 잠금</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="l" items="${list}">
										<tr
											${l.locking == 1 ? "style='background-color:LightGrey;'":""}>
											<c:choose>
												<c:when test="${l.grade == 0}">
													<td>Master</td>
												</c:when>
												<c:when test="${l.grade == 1}">
													<td>Manager</td>
												</c:when>
											</c:choose>
											<td>${l.admin_id}</td>
											<td>${l.admin_name}</td>
											<td>${l.admin_phone}</td>
											<td>${l.regDate}</td>
											<c:choose>
												<c:when test="${l.locking == 0}">
													<td>Unlocked</td>
												</c:when>
												<c:when test="${l.locking == 1}">
													<td>Locked</td>
												</c:when>
											</c:choose>
											<td><button type="button"
													class="btn btn-outline-secondary btn-sm btnReset"
													data-toggle="modal" data-target="#PasswordModal">패스워드
													초기화</button></td>
											<td><c:if test="${l.grade == 1}">
													<div class="btn-group">
														<button type="button"
															class="btn btn-outline-secondary btn-sm btnLockOn"
															data-toggle="modal" data-target="#lockModal"
															${l.locking==1 ? "disabled='disabled'":""}>On</button>
														<button type="button"
															class="btn btn-outline-secondary btn-sm btnLockOff"
															data-toggle="modal" data-target="#lockModal"
															${l.locking==1 ? "":"disabled='disabled'"}>Off</button>
													</div>
												</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<nav aria-label="Page navigation example" style="float: right;">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2018</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Close</button>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/login/logout.do">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Input Modal -->
	<div class="modal fade" id="inputModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">신규 관리자 등록</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/admin/admin_information/insert.do" method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<div class="form-group">
								<label for="admin_id">아이디</label> <input type="text"
									class="form-control" id="admin_id" name="admin_id"
									placeholder="아이디">
							</div>
							<div class="form-group">
								<label for="student_pw">패스워드</label> <input type="password"
									class="form-control" id="admin_pw" name="admin_pw"
									placeholder="패스워드">
							</div>
							<div class="form-group">
								<label for="admin_name">이름</label> <input type="text"
									class="form-control" id="admin_name" name="admin_name"
									placeholder="이름">
							</div>
							<div class="form-group">
								<label for="admin_phone">연락처</label> <input type="text"
									class="form-control" id="admin_phone" name="admin_phone"
									placeholder="연락처">
							</div>
							<div class="form-group" style="float: right;">
								<button type="submit" class="btn btn-primary">Submit</button>
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 패스워드 초기화 Modal -->
	<div class="modal fade" id="PasswordModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">패스워드 초기화</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="card-body">
						<form>
							<div class="form-group">
								<div class="form-label-group">
									<p id="resetInfo">'king / manager'</p> 
									<p>패스워드를 초기화하시겠습니까?</p>
								</div>
							</div>
							<div class="form-group">
								<div class="form-label-group">
									<input type="password" id="inputOldPassword"
										class="form-control" placeholder="현재 비밀번호" required="required">
									<label for="inputOldPassword">비밀번호(연락처 뒷 4자리)</label>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" type="button"
						data-dismiss="modal">Submit</button>
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 계정 잠금 ON Modal -->
	<div class="modal fade" id="lockModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">계정 잠금</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="card-body">
						<form>
							<div class="form-group">
								<div class="form-label-group">
									<p id="lockModalLabel">'king / manager' </p>
									<p>계정 잠금 설정을 바꾸시겠습니까?</p>
								</div>
							</div>

						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btnBlind" data-dismiss="modal">Submit</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script
		src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
     -->

	<!-- some of methods -->
	<script
		src="${pageContext.request.contextPath}/resources/script/util.js"></script>
	<script>
		$(document).ready(function() {
			var id_;
			var name_;
			$(".btnLockOn").on("click", function() {
				id_ = $(this).parents("tr").find("td:eq(1)").text();
				name_ = $(this).parents("tr").find("td:eq(2)").text();
				$("#lockModalLabel").text(id_ + "/" + name_);
				$(".btnBlind").val("1");
			});
			
			$(".btnLockOff").on("click", function() {
				id_ = $(this).parents("tr").find("td:eq(1)").text();
				name_ = $(this).parents("tr").find("td:eq(2)").text();
				$("#lockModalLabel").text(id_ + "/" + name_);
				$(".btnBlind").val("0");
			});
			
			$(".btnBlind").on("click", function() {
				var admin_id = id_;
				var locking = $(this).val();
				window.location.assign("${pageContext.request.contextPath}/admin/admin_information/lockUpdate.do?admin_id="+admin_id+"&locking="+locking);
			});
		});
	</script>
	<script>
		new Chart(document.getElementById("horizontalBar"),
				{
					"type" : "horizontalBar",
					"data" : {
						"labels" : [ "1강의실", "2강의실", "3강의실", "4강의실", "5강의실",
								"6강의실" ],
						"datasets" : [
								{
									"label" : "전체 정원(명)",
									"data" : [ 20, 20, 22, 20, 30, 25 ],
									"fill" : false,
									"backgroundColor" : [ "#EFADAD", "#EFADAD",
											"#EFADAD", "#EFADAD", "#EFADAD",
											"#EFADAD" ],
									"borderColor" : [ "#8D1010", "#8D1010",
											"#8D1010", "#8D1010", "#8D1010",
											"#8D1010" ],
									"borderWidth" : 1

								},

								{
									"label" : "수강 인원(명)",
									"data" : [ 15, 18, 22, 19, 29, 24 ],
									"fill" : false,
									"backgroundColor" : [ "#CCF2FB", "#CCF2FB",
											"#CCF2FB", "#CCF2FB", "#CCF2FB",
											"#CCF2FB" ],
									"borderColor" : [ "#1772B2", "#1772B2",
											"#1772B2", "#1772B2", "#1772B2",
											"#1772B2" ],
									"borderWidth" : 1

								},

								{
									"label" : "중도 포기(명)",
									"data" : [ 0, 1, 0, 0, 3, 0 ],
									"fill" : false,
									"backgroundColor" : [ "#EDFECC", "#EDFECC",
											"#EDFECC", "#EDFECC", "#EDFECC",
											"#EDFECC" ],
									"borderColor" : [ "#33AB1D", "#33AB1D",
											"#33AB1D", "#33AB1D", "#33AB1D",
											"#33AB1D" ],
									"borderWidth" : 1

								}

						],

					},
					"options" : {
						"scales" : {
							"yAxes" : [ {

								"ticks" : {
									"beginAtZero" : true
								}
							} ]
						}
					}
				});
	</script>
</body>

</html>
