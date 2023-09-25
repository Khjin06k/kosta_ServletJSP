<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/25
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
      <th>아이디</th>
      <th>이름</th>
      <th>주소</th>
      <th>이메일</th>
    </tr>
  <c:forEach var="user" items="${userList}">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.address}</td>
      <td>${user.email}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
