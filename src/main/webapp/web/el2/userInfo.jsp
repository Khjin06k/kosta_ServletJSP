<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/25
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> ${sessionScope.id}님 환영홥니다.</h3> <!-- 세션에 있는 id -->
<table>
    <tr>
        <th>아이디</th>
        <td>${requestScope.user.id}</td> <!-- user은 앞에 있는 키를 의미하며, requestScope는 생략이 가능함. 이전 페이지에서 request에 저장한 값을 el 표기법으로 가져옴 -->
    </tr>
    <tr>
        <th>이름</th>
        <td>${user.name}</td>
    </tr>
    <tr>
        <th>주소</th>
        <td>${user.address}</td>
    </tr>
    <tr>
        <th>이메일</th>
        <td>${user.email}</td>
    </tr>
</table>
</body>
</html>
