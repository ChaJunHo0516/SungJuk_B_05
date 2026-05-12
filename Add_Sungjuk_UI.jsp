<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sungjuk.성적"%>
<!DOCTYPE html>
<html>
<head>
<title>성적 입력 결과</title>
</head>
<body>
    <h2><< 성적입력 처리 결과 >></h2>
    <%
    String 교수id = "inha";
    String 학생id = "2026001";
    int 자바 = 95;
    int DB = 88;
    int 보안 = 92;

    성적 score = new 성적();
    String result = score.성적입력(교수id, 학생id, 자바, DB, 보안);

    if (result.equals("교수 인증 실패")) {
        out.println("<p style='color:red;'>" + result + "</p>");
    } else {
        out.println("<p style='color:blue;'>" + result + "</p>");
        session.setAttribute("savedScore", score); 
    }
    %>
</body>
</html>