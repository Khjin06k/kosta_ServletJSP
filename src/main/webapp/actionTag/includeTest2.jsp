<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/21
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>includeTest에 포함</title>
</head>
<body>
<%-- includeTest에서 요청한 것의 name을 받아서 출력 --%>
<b><%=request.getParameter("name")%></b>
</body>
</html>
