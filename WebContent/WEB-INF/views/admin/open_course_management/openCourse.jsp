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

<script>
	$(document).ready(function() {

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
			<li class="nav-item active"><a class="nav-link"
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
						<i class="fas fa-table"></i> <a
							href="${pageContext.request.contextPath}/admin/admin.do">메인</a> >
						<a
							href="${pageContext.request.contextPath}/admin/open_course_management/openCourse.do">개설
							과정 관리 > 개설 과정</a>
					</div>
					<div class="card-body">
						<div>
							<button type="button" class="btn btn-outline-primary"
								data-toggle="modal" data-target="#inputModal"
								style="margin-bottom: 0.5rem; float: right;">등록</button>
						</div>
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>개설 과정 번호</th>
										<th>개설 과정명</th>
										<th>개설 과정 시작일</th>
										<th>개설 과정 종료일</th>
										<th>강의실명</th>
										<th>개설 과목 등록 수</th>
										<th>수강 인원</th>
										<th>수정/삭제</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="l" items="${list}">
										<tr>
											<td>${l.open_course_id}</td>
											<td>${l.course_name}</td>
											<td>${l.course_start_date}</td>
											<td>${l.course_end_date}</td>
											<td>${l.class_name}</td>
											<td>${l.os_count}</td>
											<td>${l.s_count}</td>
											<td>
												<button type="button"
													class="btn btn-outline-info btn-sm btnModify"
													data-toggle="modal" data-target="#updateModal">수정</button>
												<button type="button"
													class="btn btn-outline-danger btn-sm btnRemove"
													data-toggle="modal" data-target="#deleteModal"
													${l.s_count == 0 ? "":"disabled='disabled'"}>삭제</button>
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
										<option>개설 과정 번호</option>
										<option>개설 과정명</option>
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
					<h5 class="modal-title" id="exampleModalLabel">개설 과정 삭제</h5>
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
									<p>OC001 / 웹 기반 빅데이터 분석 응용 SW 개발자</p>
								</div>
								<div class="form-label-group">
									<p>삭제하시겠습니까?</p>
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

	<!-- Input Modal -->
	<div class="modal fade" id="inputModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">개설 과정 등록</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="card-body">
						<div class="form-group">
							<form>
								<div class="form-group">
									<label for="exampleFormControlSelect1">과정명</label> <select
										class="form-control" id="exampleFormControlSelect1">
										<option>CO001 / 웹기반 빅데이터 분석 응용 SW 개발자</option>
										<option>CO002 / Python과 java 응용 SW 실무개발자 양성과정</option>
										<option>CO003 / 시큐어 코딩과 웹 애플리케이션 응용SW개발자</option>
										<option>CO004 / 클라우드 컴퓨팅 기반의 빅데이터전문가</option>
									</select>
								</div>

								<div class="form-group">
									<label for="exampleFormControlSelect1">강의실</label> <select
										class="form-control" id="exampleFormControlSelect1">
										<option>CL001 / 1강의실 / 20</option>
										<option>CL002 / 2강의실 / 20</option>
										<option>CL003 / 3강의실 / 22</option>
										<option>CL004 / 4강의실 / 20</option>
										<option>CL005 / 5강의실 / 30</option>
										<option>CL006 / 6강의실 / 25</option>
										<option>CL007 / 7강의실 / 30</option>

									</select>
								</div>


								<div class="form-group">
									<label for="OCDateStart">강의 시작일</label> <input type="Date"
										class="form-control" id="OCDateStart2" placeholder="년/월/일">
								</div>

								<div class="form-group">
									<label for="OCDateEnd">강의 종료일</label> <input type="Date"
										class="form-control" id="OCDateEnd2" placeholder="년/월/일">
								</div>
								<div class="form-label-group">
									<p>등록하시겠습니까?</p>
								</div>
							</form>
						</div>
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

	<!-- Update Modal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">개설 과정 수정</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>

				<div class="modal-body">

					<div class="card-body">
						<div class="form-group">
							<form>
								<div class="form-group">
									<label for="opencourse">개설 과정 번호</label> <input type="text"
										class="form-control" id="OCDateStart2" value="OC002"
										readonly="readonly">
								</div>
								<div class="form-group">
									<label for="exampleFormControlSelect1">과정명</label> <select
										class="form-control" id="exampleFormControlSelect1">
										<option>CO001 / 웹기반 빅데이터 분석 응용 SW 개발자</option>
										<option>CO002 / Python과 java 응용 SW 실무개발자 양성과정</option>
										<option>CO003 / 시큐어 코딩과 웹 애플리케이션 응용SW개발자</option>
										<option>CO004 / 클라우드 컴퓨팅 기반의 빅데이터전문가</option>
									</select>
								</div>

								<div class="form-group">
									<label for="exampleFormControlSelect1">강의실</label> <select
										class="form-control" id="exampleFormControlSelect1">
										<option>CL001 / 1강의실 / 20</option>
										<option>CL002 / 2강의실 / 20</option>
										<option>CL003 / 3강의실 / 22</option>
										<option>CL004 / 4강의실 / 20</option>
										<option>CL005 / 5강의실 / 30</option>
										<option>CL006 / 6강의실 / 25</option>
										<option>CL007 / 7강의실 / 30</option>

									</select>
								</div>


								<div class="form-group">
									<label for="OCDateStart">강의 시작일</label> <input type="Date"
										class="form-control" id="OCDateStart2" value="2017-10-15">
								</div>

								<div class="form-group">
									<label for="OCDateEnd">강의 종료일</label> <input type="Date"
										class="form-control" id="OCDateEnd2" value="2018-05-15">
								</div>
								<div class="form-label-group">
									<p>수정하시겠습니까?</p>
								</div>
							</form>
						</div>
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
</body>
</html>