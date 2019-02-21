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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>쌍용교육센터</title>

<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">
    
<style>
	tr, th, td {text-align: center;}
</style>
	
<script>
	$(document).ready(function() {
		
	});
</script>

</head>

<body id="page-top">

	  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="${pageContext.request.contextPath}/instructor/instructor.do">
      <img src="${pageContext.request.contextPath}/resources/img/sist_logo_reverse.png"></a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <!-- <div class="input-group">
          <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div> -->
      </form>
      

      <!-- Navbar -->
      
      <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>이강사 님
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
      	<li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/instructor/instructor.do">
            <i class="fas fa-fw fa-user-alt"></i>
            <span>개인 정보 관리</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/instructor/course_schedule/courseSchedule.do">
            <i class="fas fa-fw fa-address-book"></i>
            <span>강의 스케줄 조회</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/instructor/distribution_management/distribution_1_openCourse.do">
            <i class="fas fa-fw fa-edit"></i>
            <span>배점 관리</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="${pageContext.request.contextPath}/instructor/score_management/score_1_openCourse.do">
            <i class="fas fa-fw fa-paste"></i>
            <span>성적 관리</span></a>
        </li>
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header" style="font-size: large;">
              <i class="fas fa-table"></i>
	              <a href="${pageContext.request.contextPath}/views/teacher/score_management/score_1_openCourse.do">성적관리</a>
	              >
	              <a href="${pageContext.request.contextPath}/views/teacher/score_management/score_1_openCourse.do">개설과정</a>
            	  >
            	  <a href="${pageContext.request.contextPath}/views/teacher/score_management/score_2_openSubject.do">개설과목</a>
            	  >
            	  <a href="${pageContext.request.contextPath}/views/teacher/score_management/score_3_exam.do">시험정보</a>
            </div>
            <div class="card-body">
              <div class="table-responsive">
              	<!-- 선택 개설과정 테이블 내용 -->
                <!-- 개설과정번호/개설과정명/개설과정시작일/개설과정종료일/강의실/등록인원/개설과목정보 -->
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th>개설과정번호</th>
                      <th>개설과정명</th>
                      <th>개설과정시작일</th>
                      <th>개설과정종료일</th>
                      <th>강의실</th>
                      <th>등록인원</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                  <c:forEach items="${list1}" var="l">
                    	<tr>
                    		<td>${l.open_course_id }</td>
                  			<td>${l.course_name }</td>
                  			<td>${l.course_start_date }</td>
                  			<td>${l.course_end_date }</td>
                  			<td>${l.class_name }</td>
                  			<td>${l.s_count }</td>
                    	</tr>
                  	</c:forEach>
                  </tbody>
                </table>
                
                <!-- 선택 개설과목 테이블 내용 -->
                <!-- 개설과목번호/개설과목명/개설과목시작일/개설과목종료일/교재명/시험정보 -->
                <!-- 교재명 : 교재모달 연동(bookModal) -->
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th>개설과목번호</th>
                      <th>개설과목명</th>
                      <th>개설과목시작일</th>
                      <th>개설과목종료일</th>
                      <th>교재명</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                  <c:forEach items="${list2 }" var="l2">
                    <tr>
                    	<td>${l2.open_subject_id }</td>
                    	<!-- <button type="button" class="btn btn-outline-info btn-sm btnPic" style="float:right;" data-toggle="modal" data-target="#picModal">사진 보기</button> -->
                    	<td>${l2.subject_name }</td>
                    	<td>${l2.subject_start_date }</td>
                    	<td>${l2.subject_end_date }</td>
                    	<td>${l2.book_name }
                    	<button type="button" class="btn btn-outline-info btn-sm btnBook" style="float:right;" value="${isbn_number }" data-toggle="modal" data-target="#bookModal">교재 보기</button>
                    	</td>   
                    </tr>
                    </c:forEach>
                  </tbody>  
                </table>
                
                <!-- 시험정보 테이블 내용 -->
                <!-- 시험번호/시험문제/시험날짜/출결배점/필기배점/실기배점 -->
                <!-- 삭제 : 삭제모달 연동(deleteModal) -->
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th>시험번호</th>
                      <th>시험문제</th>
                      <th>시험날짜</th>
                      <th>출결배점</th>
                      <th>필기배점</th>
                      <th>실기배점</th>
                      <th>학생정보</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                  	<c:forEach items="${list3 }" var="l3">
                    <tr>
                    	<td>${l3.exam_id }</td>
                    	<td>${l3.exam_question_file }
                    	<button type="button" class="btn btn-outline-info btn-sm btndownload" style="float:right;">다운로드</button>
                    	</td>
                    	<td>${l3.exam_date }</td>
                    	<td>${l3.attendance_distribution }</td>
                    	<td>${l3.written_distribution }</td>
                    	<td>${l3.performance_distribution }</td>
                    	<td>	
                    		<button type="button" class="btn btn-outline-primary btn-sm move">보기</button>
                    	</td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
                
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
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
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Close</button>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/views/login/login.do">Logout</a>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Book Modal -->
    <!-- 교재정보 모달 : 교재명/교재내용(인터파트openAPI) -->
    <div class="modal fade" id="bookModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">오라클 SQL과 PL/SQL을 다루는 기술</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">
            <div style="text-align: center;">
				<img src="${pageContext.request.contextPath}/resources/pictures/interpark_sample.png" width="100%">
			</div>
          </div>
          <div class="modal-footer">
                  <button class="btn btn-secondary" type="button" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- student Modal -->
    <!-- 학생정보 모달 : 학생번호/학생이름 -->
    <div class="modal fade" id="studentModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">ST001/권모씨</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">
            <div style="text-align: center;">
				<img src="${pageContext.request.contextPath}/resources/pictures/avatar.png" width="100%">
			</div>
          </div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    
     <!-- add Modal -->
     <!-- 성적 추가 모달 : 학생번호/학생이름/출결점수/필기점수/실기점수 -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
       <div class="modal-dialog modal-md">
            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
               	  <h4 class="modal-title">성적등록[ST001/권모씨]</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
               </div>
               <div class="modal-body">
               	  <div class="form-group">
                     <label for="attendance_points">출결점수</label> <input type="number"
                        class="form-control" id="attendance_points" name="attendance_points"
                        max="20" value="" required>
                  </div>
                  <div class="form-group">
                     <label for="written_points">필기점수</label> <input type="number"
                        class="form-control" id="written_points" name="written_points"
                        value="" required>
                  </div>
                  <div class="form-group">
                     <label for="written_points">실기점수</label> <input type="number"
                        class="form-control" id="written_points" name="written_points"
                        value="" required>
                  </div>                 
               </div>
               <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" type="button" data-dismiss="modal">Submit</button>
					<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
               </div>
            </div>
         </div>
    </div>
    
    <!-- delete Modal -->
    <!-- 성적 삭제 모달 : 학생번호/학생이름 -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-md">
            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
               	  <h4 class="modal-title">성적삭제[ST001/권모씨]</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
               </div>
               <div class="modal-body">
                  현재 선택한 성적 정보를 삭제할까요?
               </div>
               <div class="modal-footer">
                     <button type="submit" class="btn btn-primary" type="button" data-dismiss="modal">Submit</button>
					 <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
               </div>
            </div>
         </div>
    </div>
    
    <!-- download Modal -->
    <!-- 성적 삭제 모달 : 학생번호/학생이름 -->
    <!-- <div class="modal fade" id="downloadModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-md">
            Modal content
            <div class="modal-content">
               <div class="modal-header">
               	  <h4 class="modal-title">시험문제[EX002/EXAM002.zip]</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
               </div>
               <div class="modal-body">
                  현재 선택한 시험 정보를 다운로드할까요?
               </div>
               <div class="modal-footer">
                     <button type="submit" class="btn btn-primary" type="button" data-dismiss="modal">Submit</button>
					 <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
               </div>
            </div>
         </div>
    </div> -->
    
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
    
    <script>
    	$(document).ready(function(){
    		$(".move").on("click",function(){
    			var os='${param.os}'
    			var oc='${param.oc}'
    			var ex=$(this).parent().siblings().eq(0).text();
    			location.assign("${pageContext.request.contextPath}/instructor/score_management/score_4_student.do?os="+os+"&oc="+oc+"&ex="+ex);
    		});
    	});
    </script>
    
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <%-- <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
    <script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script> --%>
    
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <!-- 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
     -->

	<!-- some of methods -->    
    <script src="${pageContext.request.contextPath}/resources/script/util.js"></script>

</body>
</html>