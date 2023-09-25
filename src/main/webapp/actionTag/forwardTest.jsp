<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/21
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>액션 태그 - forward 액션 태그 테스트</title>
</head>
<body>
    <form action="forwardTest1.jsp" method="post">
      <input  type="hidden" name="forwardPage" value="forwardTest2.jsp">
      <table>
        <tr>
          <td>이름</td>
          <td><input type="text" name = "name"></td>
        </tr>
        <tr>
          <td>나이</td>
          <td><input type="text" name = "age"></td>
        </tr>
        <tr>
          <td>주소</td>
          <td><input type="text" name = "address"></td>
        </tr>
        <tr><td></td><td><input type="submit" value="전송"></td></tr>
      </table>
    </form>
</body>
</html>
