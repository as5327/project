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
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

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
<script>
	$(document).ready(function() {
		$(".btnLecture").on("click", function() {

		});

		$(".btnDel").on("click", function() {
			var student_id = $(this).parents("tr").find("td:eq(0)").text();
			var student_name = $(this).parents("tr").find("td:eq(1)").text();

			student_name = student_name.slice(0, student_name.indexOf("/"));

			$("#deleteModal #student_id").val(student_id);
			$("#deleteModal #student_name").val(student_name);
		});

		$(".btnUpdate").on("click", function() {
			var student_id = $(this).parents("tr").find("td:eq(0)").text();
			var student_name = $(this).parents("tr").find("td:eq(1)").text();
			var student_phone = $(this).parents("tr").find("td:eq(2)").text();

			student_name = student_name.slice(0, student_name.indexOf("/"));

			$("#updateModal #upstudent_id").val(student_id);
			$("#updateModal #upstudent_name").val(student_name);
			$("#updateModal #upstudent_phone").val(student_phone);
		});
		
		$(".btnPic").on("click", function() {
			$("#studentPictureFile").siblings("label").text("avatar.png");
		});

		$("#inputButton").on("click", function() {
			location.assign("${pageContext.request.contextPath}/admin/student_management/insert.do?student_name=" + $("#sname").val() + "&student_phone=" + $("#sphone").val() + "&student_pw=" + $("#spw").val());
		});

		$("#deleteButton").on("click", function() {
			location.assign("${pageContext.request.contextPath}/admin/student_management/delete.do?student_id=" + $("#student_id").val());
		});

		$("#updateButton").on("click", function() {
			location.assign("${pageContext.request.contextPath}/admin/student_management/update.do?student_name=" + $("#upstudent_name").val() + "&student_phone=" + $("#upstudent_phone").val() + "&student_id=" + $("#upstudent_id").val());
		});

	});
</script>

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
			<li class="nav-item"><a class="nav-link"
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
			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" id="pagesDropdown" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-address-card"></i> <span>수강생 관리</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<a class="dropdown-item active"
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
						<i class="fas fa-table"></i> <a href="#">메인</a> > <a
							href="${pageContext.request.contextPath}/admin/student_management/student_list.do">수강생
							관리 > 수강생 목록</a>
					</div>

					<div class="card-body">
						<div class="table-responsive">
							<!-- 입력버튼 -->
							<div>
								<button type="button" class="btn btn-outline-primary"
									data-toggle="modal" data-target="#inputModal"
									style="margin-bottom: 0.5rem; float: right;">등록</button>
							</div>

							<table class="table table-bordered">
								<thead>
									<tr>
										<th>수강생 번호</th>
										<th>수강생명</th>
										<th>연락처</th>
										<th>등록일</th>
										<th>수강 횟수</th>
										<th>수강 과정 정보</th>
										<th>수정 / 삭제</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="s" items="${list}">
										<tr>
											<td>${s.student_id}</td>
											<td>${s.student_name}
												<button type="button"
													class="btn btn-outline-info btn-sm btnPic"
													style="float: right;" data-toggle="modal"
													data-target="#studentPicture">사진</button>
											</td>
											<td>${s.student_phone}</td>
											<td>${s.student_regDate}</td>
											<td>${s.student_count}</td>
											<td><button type="button"
													class="btn btn-outline-primary btn-sm btnLecture"
													id="openCourse"
													onclick="location.href='${pageContext.request.contextPath}/admin/student_management/student_lectureCourse.do?student_id = ${s.student_id}'">보기</button></td>
											<td>
												<button type="button"
													class="btn btn-outline-info btn-sm btnUpdate"
													data-toggle="modal" data-target="#updateModal"
													value="${s.student_id}">수정</button>
												<button type="button"
													class="btn btn-outline-danger btn-sm btnDel"
													data-toggle="modal" data-target="#deleteModal"
													value="${s.student_id}">삭제</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div>
							<form class="form-inline" role="form" method="post"
								style="float: right">
								<div class="input-group">
									<select class="form-control" id="key" name="key">
										<option>수강생 번호</option>
										<option>수강생명</option>
									</select>
								</div>
								<div class="input-group">
									<input type="text" class="form-control" id="value" name="value"
										placeholder="Search" required="required"
										aria-describedby="basic-addon2">
									<div class="input-group-append">
										<button class="btn btn-outline-secondary" type="button">
											<i class="fas fa-fw fa-search"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<!-- /.content-wrapper -->

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
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/login/logout.do">Logout</a>
				</div>
			</div>
		</div>
	</div>


	<!-- Delete Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">수강생 삭제</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>


				<form
					action="${pageContext.request.contextPath}/admin/student_management/delete.do"
					method="POST" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="card-body">

							<div class="form-group">

								<div class="form-group">
									<label for="student_id">수강생번호</label>
									<div class="form-label-group">

										<input type="text" class="form-control" id="student_id"
											name="student_id" value="" readonly="readonly"
											placeholder="수강생번호">
									</div>
								</div>

								<div class="form-group">
									<label for="student_name">수강생명</label>
									<div class="form-label-group">
										<input type="text" class="form-control" id="student_name"
											name="student_name" value="" readonly="readonly"
											placeholder="수강생이름">
									</div>
									삭제하시겠습니까?
								</div>
							</div>
						</div>
					</div>

					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" type="button"
							data-dismiss="modal" id="deleteButton">Submit</button>
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- Insert Modal -->
	<div class="modal fade" id="inputModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">신규 수강생 등록</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form
					action="${pageContext.request.contextPath}/admin/student_management/insert.do"
					method="POST" enctype="multipart/form-data">
					<div class="modal-body">

						<div class="card-body">
							<div class="form-group">

								<div class="form-group">
									<label for="student_name">수강생명</label> <input type="text"
										class="form-control" name="student_name" id="sname"
										placeholder="수강생 이름">
								</div>

								<div class="form-group">
									<label for="student_phone">연락처</label> <input type="text"
										class="form-control" name="student_phone" id="sphone"
										placeholder="연락처">
								</div>

								<div class="form-group">
									<label for="student_pw">패스워드</label> <input type="password"
										class="form-control" id="spw" name="student_pw"
										placeholder="Password">
								</div>

								<div class="form-label-group">
									<p>등록하시겠습니까?</p>
								</div>

							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" type="button"
							data-dismiss="modal" id="inputButton">Submit</button>
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- 수강생 사진 보기 Modal -->
	<div class="modal fade" id="studentPicture" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">ST001 / 전성표</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form action="" method="POST" enctype="multipart/form-data">
					<div class="modal-body">
						<div style="text-align: center;">
							<img
								src="${pageContext.request.contextPath}/resources/pictures/avatar.png"
								width="100%">
						</div>
					</div>

					<div class="modal-footer">

						<div class="form-group">
							<label for="attendance_points">사진 등록</label>
							<div class="input-group mb-3">
								<div class="custom-file">
									<input type="file" class="custom-file-input"
										id="studentPictureFile"> <label
										class="custom-file-label" for="studentPictureFile"
										aria-describedby="inputGroupFileAddon02">avatar.png</label>
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" type="button"
							data-dismiss="modal">Submit</button>
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- 수정 Modal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">수강생 정보 수정</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form
					action="${pageContext.request.contextPath}/admin/student_management/update.do"
					method="POST" enctype="multipart/form-data">
					<div class="form-group">
						<div class="modal-body">

							<div class="card-body">

								<div class="form-group">
									<label for="student_id">수강생 번호</label> <input type="text"
										class="form-control" id="upstudent_id" name="student_id"
										value="" readonly="readonly" placeholder="수강생번호">
								</div>

								<div class="form-group">
									<label for="student_name">수강생명</label> <input type="text"
										class="form-control" id="upstudent_name" name="student_name"
										value="" placeholder="수강생명">
								</div>


								<div class="form-group">
									<label for="student_phone">연락처</label> <input type="text"
										class="form-control" id="upstudent_phone" name="student_phone"
										value="">
								</div>

								<div class="form-label-group">
									<p>수정하시겠습니까?</p>
								</div>

							</div>
						</div>
					</div>

					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" type="button"
							data-dismiss="modal" id="updateButton">Submit</button>
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
					</div>
				</form>
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

	<!-- some of methods -->
	<script
		src="${pageContext.request.contextPath}/resources/script/util.js"></script>
</body>




</html>