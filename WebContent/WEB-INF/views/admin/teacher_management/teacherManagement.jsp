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
			href="${pageContext.request.contextPath}/teacher/teacherInfo.do"><img
			src="${pageContext.request.contextPath}/resources/img/sist_logo_reverse.png"></a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle">
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
							관리</a>
					</div>
					<div class="card-body">
						<div>
							<button type="button" class="btn btn-outline-primary btnInsert"
								data-toggle="modal" data-target="#inputModal"
								style="margin-bottom: 0.5rem; float: right;">등록</button>
						</div>
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>강사 번호</th>
										<th>강사명</th>
										<th>연락처</th>
										<th>등록일</th>
										<th>강의 스케줄</th>
										<th>강의 가능 과목</th>
										<th>수정/삭제</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="i" items="${list}">
										<tr>
											<td>${i.instructor_Id }</td>
											<td>${i.instructor_Name} /
												<button type="button"
													class="btn btn-outline-info btn-sm btnPic"
													style="float: right;" data-toggle="modal"
													data-target="#picModal">사진</button>
											</td>
											<td>${i.instructor_Phone}</td>
											<td>${i.instructor_regDate}</td>
											<td><a
												href="${pageContext.request.contextPath}/admin/teacher_management/scheduleForEach.do">
													<button type="button" class="btn btn-outline-primary btn-sm">
														보기<span class="badge badge-dark">${i.schedule_count}</span>
													</button>
											</a></td>
											<td><button type="button"
													class="btn btn-outline-primary btn-sm btnSubList"
													data-toggle="modal" data-target="#subListModal">
													보기<span class="badge badge-dark">${i.possible_count}</span>
												</button></td>
											<td>
												<button type="button"
													class="btn btn-outline-info btn-sm btnModify"
													data-toggle="modal" data-target="#updateModal">수정</button>
												<button type="button"
													class="btn btn-outline-danger btn-sm btnRemove"
													data-toggle="modal" data-target="#deleteModal"
													${i.instructorDel == 0 ? "":"disabled='disabled'"}>삭제</button>
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
					<h5 class="modal-title" id="exampleModalLabel">IS001 / 김강사</h5>
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
									<input type="file" class="custom-file-input" id="picutreFile">
									<label class="custom-file-label" for="picutreFile"
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

	<!-- Delete Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">강사 계정 삭제</h5>
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
									<p>IS001 / 이강사</p>
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
					<h5 class="modal-title" id="exampleModalLabel">신규 강사 등록</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form
						action="${pageContext.request.contextPath}/admin/teacher_management/insert.do"
						method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<div class="form-group">
								<label for="instructor_Name">강사명</label> <input type="text"
									class="form-control" id="instructor_Name"
									name="instructor_Name" placeholder="강사명">
							</div>

							<div class="form-group">
								<label for="instructor_Phone">연락처</label> <input type="text"
									class="form-control" id="instructor_Phone"
									name="instructor_Phone" placeholder="연락처">
							</div>

							<div class="form-group">
								<label for="instructor_pw">패스워드(전화번호 뒤 네 자리)</label> <input
									type="password" class="form-control" id="instructor_pw"
									name="instructor_pw" placeholder="Password">
							</div>
							
							<div class="form-group" id="subListShow"></div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="checkbox"
									id="i" value="option2"> <label
									class="form-check-label" for="inlineCheckbox2_mod">UI 설계
									및 구현</label>
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

	<!-- Update Modal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">강사 정보 수정</h5>
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
									<div class="form-group">
										<label for="ins_id_mod">강사번호</label> <input type="text"
											class="form-control" id="ins_id_mod" name="ins_id_mod"
											placeholder="강사번호" readonly="readonly" value="IS001">
									</div>
									<div class="form-group">
										<label for="ins_name_mod">강사명</label> <input type="text"
											class="form-control" id="ins_name_mod" name="ins_name_mod"
											placeholder="강사명" value="이강사">
									</div>

									<div class="form-group">
										<label for="ins_phone_mod">연락처</label> <input type="text"
											class="form-control" id="ins_phone_mod" name="ins_phone_mod"
											placeholder="연락처" value="010-8594-2351">
									</div>

									<div class="form-group">
										<label for="ins_pw_mod">패스워드(전화번호 뒤 네 자리)</label> <input
											type="password" class="form-control" id="ins_pw_mod"
											name="ins_pw_mod" placeholder="Password" value="1234">
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox1_mod" value="option1"> <label
											class="form-check-label" for="inlineCheckbox1_mod">JAVA
											TESTING</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox2_mod" value="option2"> <label
											class="form-check-label" for="inlineCheckbox2_mod">UI 설계
											및 구현</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox3_mod" value="option3"> <label
											class="form-check-label" for="inlineCheckbox3_mod">개발 환경
											설정 및 JAVA 기초</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox4_mod" value="option4"> <label
											class="form-check-label" for="inlineCheckbox4_mod">Oracle
											DBMS</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox5_mod" value="option5"> <label
											class="form-check-label" for="inlineCheckbox5_mod">빅데이터
											분석</label>
									</div>

									<div class="form-label-group">
										<p>수정 하시겠습니까?</p>
									</div>
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

	<!-- 강의 가능 목록 Modal -->
	<div class="modal fade" id="subListModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="psListLabel">강의 가능 목록[IS001
						/ 이강사]</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="card-body">
						<form>
							<div class="form-group">
								<div class="form-label-group" id="psListShow"></div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
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

	<!-- some of methods -->
	<script
		src="${pageContext.request.contextPath}/resources/script/util.js"></script>

	<script>
		$(document).ready(function() {
			$("#picutreFile").on("change", function() {
				var st = $(this).val().split('\\');
				var stl = st[st.length - 1];
				$(this).siblings("label").text(stl);
	
			});
	
			$(".btnPic").on("click", function() {
				$("#picutreFile").siblings("label").text("avatar.png");
			});
			
			$(".btnSubList").on("click", function() {
				var instructor_id = $(this).parents("tr").find("td:eq(0)").text();
				var name = $(this).parents("tr").find("td:eq(1)").text();
				name = name.slice(0,name.indexOf("/"));
				$("#psListLabel").text("강의 가능 목록[" + instructor_id + "/" + name + "]");
				psList(instructor_id);
			});
			
			$(".btnInsert").on("click", function() {
				subList();
			});
		});
		
		function psList(instructor_id) {
			$.ajax({
				url: "${pageContext.request.contextPath}/admin/teacher_management/psList.do"
				,data: {instructor_Id:instructor_id}
				,success: function(data_) {
					var psList = "";
					for (var a=0; a<data_.length; ++a) {
						psList += data_[a].subject_name + "<br>";
					}
					
					$("#psListShow").html(psList);
			}});
		}
		
		function subList() {
			$.ajax({
				url: "${pageContext.request.contextPath}/admin/teacher_management/subList.do"
				,success: function(data_) {
					var subList = "";
					for (var a=0; a<data_.length; ++a) {
						if (a != 0) {
						}
							subList += "<div class='form-check form-check-inline'>";							
						subList += "<input class='form-check-input' type='checkbox' value=";
						subList += data_[a].subject_id + ">";
						subList += "<label class='form-check-label'>" + data_[a].subject_name + "</label>";
						subList += "</div>";
						
					}
					
					$("#subListShow").html(subList);
			}});
		}
	</script>
</body>

</html>
