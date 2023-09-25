<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/21
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>포워드된 페이지</title>
</head>
<body>
<h2>포워드 된 페이지(forwoardTest2.jsp)</h2>
<table border="1">
    <tr>
        <td>이름</td>
        <td><%=request.getParameter("name")%></td>
    </tr>
    <tr>
        <td>나이</td>
        <td><%=request.getParameter("age")%></td>
    </tr>
    <tr>
        <td>전화번호</td>
        <td><%=request.getParameter("tel")%></td>
    </tr>
    <tr>
        <td>주소</td>
        <td><%=request.getParameter("address")%></td>
    </tr>
</table>
</body>
</html>
