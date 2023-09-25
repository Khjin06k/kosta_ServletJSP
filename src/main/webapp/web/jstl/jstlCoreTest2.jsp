<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/25
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="test" begin="1" end="10" step="2">
    <b>${test}</b>
</c:forEach>

<!-- forTokenssms delims의 구분자로 자른 것을 하나씩 담는 것
<c:forTokens var="alphabet" items="a,b,c,d,e,f,g,h,i" delims=",">
    <b>${alphabet}</b>
</c:forTokens>

<c:set var="data" value="홍길동, 김길동, 고길동"/>
<c:forTokens var="varData" items="${data }" delims=",">
    <b>${varData}</b>
</c:forTokens>
</body>
</html>
