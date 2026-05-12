<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sungjuk.성적"%>
<!DOCTYPE html>
<html>
<head>
<title>학점 조회 결과</title>
</head>
<body>
	<h2><< 학점조회 처리 결과 >></h2>
	<%
	// 테스트 데이터 설정
	String 교수id = "inha";
	String 학생id = "2026001";

	// 세션에서 저장된 성적 객체 가져오기
	성적 score = (성적) session.getAttribute("savedScore");

	if (score != null) {
		// 함수 내부에서 교수체크와 학점조회를 동시에 처리
		String result = score.학점조회(교수id, 학생id);

		if (result.equals("교수 인증 실패")) {
			out.println("<p style='color:red;'>" + result + "</p>");
		} else {
			out.println("<p>학생ID [" + 학생id + "]의 부여된 학점: <b>" + result + "</b></p>");
		}
	} else {
		out.println("<p>조회 가능한 데이터가 없습니다. 먼저 성적 입력을 진행해 주세요.</p>");
	}
	%>
</body>
</html>