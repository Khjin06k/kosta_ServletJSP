<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- request.getParmeter로 가지고 올 때 한글이 깨지지 않도록 하기 위한 설정 -->
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Request 예제입니다</h1>
<table border="1" style="width: 400px">
    <tr>
      <td>이름</td>
      <td>
        <!-- =이 붙은 것이 출력 -->
        <%=  request.getParameter("name") %>
      </td>
    </tr>
  <tr>
    <td>성별</td>
    <td>
      <!-- 자바코드이기 때문에 <%-- <% %> --%>로 묶어줘야 함 -->
      <%
        String gender = request.getParameter("gender");
        if(gender.equals("male")){
      %>
      남
      <%  }
        else
      %>
      여
    </td>
  </tr>
  <tr>
    <td>취미</td>
    <td>
      <%
      String[] hobby = request.getParameterValues("hobby");
      for(String h : hobby){
      %>
      <!-- 변수의 값을 출력해야 하므로 %=을 사용해 변수를 넣음 -->
        <%= h+ " " %>
      <%
        }
      %>
    </td>
  </tr>

</table>
</body>
</html>
