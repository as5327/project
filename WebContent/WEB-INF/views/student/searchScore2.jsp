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
			href="${pageContext.request.contextPath}/student/student.do"><img
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
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>전성표
					님
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
				href="${pageContext.request.contextPath}/student/student.do"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>개인 정보 관리</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/student/score1.do"> <i
					class="fas fa-fw fa-chart-area"></i> <span>성적 조회</span></a></li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> 성적 조회 > <a
							href="${pageContext.request.contextPath}/student/score1.do">개설
							과정</a> > <a
							href="${pageContext.request.contextPath}/student/score2.do">개설
							과목</a>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>개설 과정 번호 </th>
										<th>개설 과정명</th>
										<th>개설 과정 시작일</th>
										<th>개설 과정 종료일</th>
										<th>강의실</th>
										<th>수료 상태</th>
										<th>수료 예정(중도 포기)날짜</th>
									</tr>
								</thead>

								<tbody>

									<c:forEach items="${list1}" var="l">

										<tr>
											<td id="oc">${l.open_course_id }</td>
											<td>${l.course_name }</td>
											<td>${l.course_start_date }</td>
											<td>${l.course_end_date }</td>
											<td>${l.class_name }</td>
											<td>${l.status_ }</td>
											<td>${l.status_date }</td>
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
										<th>강사명</th>
										<th>성적 정보</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${list2 }" var="l2">
										<tr>
											<td>${l2.open_subject_id }</td>
											<td>${l2.subject_name }</td>
											<td>${l2.subject_start_date }</td>
											<td>${l2.subject_end_date }</td>
											<td>${l2.book_name }
												<button type="button"
													class="btn btn-outline-info btn-sm btnBook"
													style="float: right;" value="${isbn_number }"
													data-toggle="modal" data-target="#bookModal">교재 보기</button>
											</td>
											<td>${l2.instructor_name }<input type="hidden"
												name="${l2.instructor_id }" value="${l2.instructor_id }" />
												<button type="button"
													class="btn btn-outline-info btn-sm btnPic"
													style="float: right;" value="${l2.instructor_pic }"
													data-toggle="modal" data-target="#picModal">사진 보기</button>
											</td>
											<td><button type="button"
													class="btn btn-outline-primary btn-sm move">보기</button></td>
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
						href="${pageContext.request.contextPath}/login/main.do">Logout</a>
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

	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<script>
		$(document).ready(function() {
			$(".move").on("click", function() {
				var os = $(this).parent().siblings().eq(0).text();
				var oc = $("#oc").text();
				location.assign("${pageContext.request.contextPath}/student/score3.do?os=" + os + "&oc=" + oc);
			});
		});
	</script>

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
