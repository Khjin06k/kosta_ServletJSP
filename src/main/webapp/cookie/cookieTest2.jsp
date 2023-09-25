<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String name="";
  String age="";
  String cookie = request.getHeader("Cookie");
  if(cookie != null){
    Cookie[] cookies = request.getCookies();
    for(Cookie c : cookies){
      if(c.getName().equals("name")){
        name=c.getValue();
      }else if(c.getName().equals("age")){
        age = c.getValue();
      }
    }
  }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> 이름 = <%=name%></h2>
<h2> 나이 = <%=age%></h2>
</body>
</html>
