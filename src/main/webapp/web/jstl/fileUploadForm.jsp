<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/25
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파일 업로드</title>
</head>
<body>
<form action="fileUpload" method="post" enctype="multipart/form-data">
  <table>
    <tr>
      <td colspan="2"><H3>파일 업로드 중</H3></td>
    </tr>
    <tr>
      <td> 올린 사람 : </td>
      <td><input type="text" name="name"/> </td>
    </tr>
    <tr>
    <td> 제목 : </td>
    <td><input type="text" name="title"/> </td>
  </tr>
    <tr>
      <td> 파일명 : </td>
      <td><input type="file" name="file" /><!-- 파일 여러개 선택 가능 multiple="multiple"--> </td>
    </tr>
    <tr>
      <td colspan="2"> <input type="submit" value="전송"/> </td>
    </tr>

  </table>
</form>
</body>
</html>
