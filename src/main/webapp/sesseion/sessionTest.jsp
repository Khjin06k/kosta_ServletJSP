<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String nickname = (String)session.getAttribute("nickname");
  if(nickname != null){
    nickname = "세션 값 없음";
  }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>세션 테스트</h2>
<input type="button" onclick="location.href='sessionSet.jsp'" value = "세션 값 저장">
<input type="button" onclick="location.href='sessionDel.jsp'" value = "세션 값 삭제">
<input type="button" onclick="location.href='sessionInvalidate.jsp'" value = "세션 값 초기화">
<h3><%=nickname%></h3>
</body>
</html>
