<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%--value값은 띄어쓰기 포함할 수 없음 --%>
<%
  Cookie cookie = new Cookie("name", "honggildong");
  cookie.setMaxAge(600);
  response.addCookie(cookie);
    Cookie cookie2 = new Cookie("age", "30");
    cookie.setMaxAge(600);
    response.addCookie(cookie2);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><%=cookie.getName()%></h2>
<h2><%=cookie.getValue()%></h2>
<h2><%=cookie.getMaxAge()%></h2>
<h2><%=cookie2.getName()%></h2>
<h2><%=cookie2.getValue()%></h2>
<h2><%=cookie2.getMaxAge()%></h2>
<a href="cookieTest2.jsp">쿠키 값 불러오기</a>
</body>
</html>
