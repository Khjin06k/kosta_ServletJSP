<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/22
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% session.setAttribute("test", "Session Test"); %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="el_test2.jsp" method="post">
  <table border="1">
    <tr>
      <td>이름 : </td>
      <td><input type="text" name = "name" value = "홍길동"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="입력"/> </td>
    </tr>
  </table>
</form>
</body>
</html>
