<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sungjuk.성적"%>
<!DOCTYPE html>
<html>
<head>
<title>성적 입력 결과</title>
</head>
<body>
	<h2><< 성적입력 처리 결과 >></h2>
	<%
	// 테스트 데이터 설정
	String 교수id = "inha"; // "inha"가 아니면 실패 메시지가 출력됩니다.
	String 학생id = "2026001";
	int 자바 = 95;
	int DB = 88;
	int 보안 = 92;

	성적 score = new 성적();

	// 함수 내부에서 체크와 입력을 동시에 처리
	String result = score.성적입력(교수id, 학생id, 자바, DB, 보안);

	// 결과 메시지 출력
	if (result.equals("교수 인증 실패")) {
		out.println("<p style='color:red;'>" + result + "</p>");
	} else {
		out.println("<p style='color:blue;'>" + result + "</p>");
		session.setAttribute("savedScore", score); // 성공 시 세션 저장
	}
	%>
</body>
</html>