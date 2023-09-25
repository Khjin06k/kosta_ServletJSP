<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/22
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    request.setAttribute("tes", "홍홍");
    request.setAttribute("nickname", "홍홍");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- session, request의 이름이 동일할 경우에는 명확히 앞에 적어주는 것이 좋으며,
 request는 많이 사용하지 않음-->
<h3><%=session.getAttribute("test")%></h3> <!-- Session Test -->
<h3>${sessionScope.test }</h3> <!-- Session Test -->
<h3>${requestScope.nickname}</h3> <!-- 홍홍 -->
<h3>${test}</h3> <!-- 홍홍 -->
<h3>${nickname}</h3> <!-- Session Test -->
<h3>${param.name}</h3> <!-- 홍길동 -->
</body>
</html>
