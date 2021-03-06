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
			<li class="nav-item active"><a class="nav-link"
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
						<i class="fas fa-table"></i> <a
							href="${pageContext.request.contextPath}/admin/admin.do">메인</a> >
						<a
							href="${pageContext.request.contextPath}/admin/teacher_management/teacherManagement.do">강사
							관리</a> > <a
							href="${pageContext.request.contextPath}/admin/teacher_management/scheduleForEach.do">개설
							과정</a> > <a
							href="${pageContext.request.contextPath}/admin/teacher_management/scheduleForEach2.do">개설
							과목</a>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>강사 번호</th>
										<th>강사명</th>
										<th>연락처</th>
										<th>등록일</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="l" items="${list}">
										<tr>
											<td>${l.instructor_Id}</td>
											<td>${l.instructor_Name}
												<button type="button"
													class="btn btn-outline-info btn-sm btnPic"
													style="float: right;" data-toggle="modal"
													data-target="#picModal">사진 보기</button>
											</td>
											<td>${l.instructor_Phone}</td>
											<td>${l.instructor_regDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>개설 과정 번호</th>
										<th>개설 과정명</th>
										<th>개설 과정 시작일</th>
										<th>개설 과정 종료일</th>
										<th>강의실</th>
										<th>인원</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="oc" items="${ocList}">
										<tr>
											<td>${oc.open_course_id}</td>
											<td>${oc.course_name}</td>
											<td>${oc.course_start_date}</td>
											<td>${oc.course_end_date}</td>
											<td>${oc.class_name}</td>
											<td>${oc.s_count}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<table class="table table-bordered">
								<thead>
									<tr>
										<th>개설 과목 번호</th>
										<th>개설 과목명</th>
										<th>개설 과목 시작일</th>
										<th>개설 과목 종료일</th>
										<th>교재명</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="os" items="${osList}">
										<tr>
											<td>${os.open_subject_id}</td>
											<td>${os.subject_name}</td>
											<td>${os.subject_start_date}</td>
											<td>${os.subject_end_date}</td>
											<td>${os.book_name}
												<button type="button"
													class="btn btn-outline-info btn-sm btnBook"
													style="float: right;" data-toggle="modal"
													data-target="#bookModal"
													value="${os.isbn_number}">교재 보기</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
						data-dismiss="modal">Close</button>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/login/logout.do">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Picture Modal -->
	<div class="modal fade" id="picModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">IS001 / 곽우신</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div style="text-align: center;">
						<img
							src="${pageContext.request.contextPath}/resources/pictures/avatar.png"
							width="100%">
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Book Modal -->
	<div class="modal fade" id="bookModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">오라클 SQL과
						PL/SQL을 다루는 기술</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div style="text-align: center;">
						<img
							src="${pageContext.request.contextPath}/resources/pictures/interpark_sample.png"
							width="100%">
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Close</button>
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
									<p>OS001 / 실무 프로젝트 통합 구현</p>
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
					<h5 class="modal-title" id="exampleModalLabel">개설 과목 등록</h5>
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
									<div class="" id="">[OC001 / Python과 Java 응용 SW 실무 개발자 양성
										과정 / 2017-10-15 / 2018-05-08 / 3 강의실]</div>
									<br> <label for="sel1">과목 선택</label> <select
										class="form-control" id="sel1" name="sel1">
										<option value="" id="">SB001 / 개발환경 설정 및 JAVA 기초</option>
										<option value="" id="">SB002 / ORACLE DBMS</option>
										<option value="" id="">SB003 / JAVA TESTING</option>
										<option value="" id="">SB004 / FRONT END 개발</option>
										<option value="" id="">SB005 / BACK END 개발</option>
									</select>
								</div>

								<div class="form-group">
									<label for="start_">강의 시작일</label> <input type="Date"
										class="form-control" id="start_" name="start_"
										placeholder="년/월/일">
								</div>

								<div class="form-group">
									<label for="end_">강의 종료일</label> <input type="Date"
										class="form-control" id="end_" name="end_" placeholder="년/월/일">
								</div>

								<div class="form-group">
									<label for="sel2">교재</label> <select class="form-control"
										id="sel2" name="sel2">
										<option value="" id="">BO001 / SQL 레벨업</option>
										<option value="" id="">BO002 / 이것이 자바다</option>
										<option value="" id="">BO003 / 코드로 배우는 스프링 웹 프로젝트</option>
										<option value="" id="">BO004 / 점프 투 파이썬</option>
										<option value="" id="">BO005 / JSP 2.3 웹 프로그래밍</option>
									</select>
								</div>

								<div class="form-group">
									<label for="sel2">강사</label> <select class="form-control"
										id="sel2" name="sel2">
										<option value="" id="">IS001 / 곽우신</option>
										<option value="" id="">IS002 / 김동계</option>
										<option value="" id="">IS003 / 황우철</option>
										<option value="" id="">IS004 / 박명신</option>

									</select>
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
