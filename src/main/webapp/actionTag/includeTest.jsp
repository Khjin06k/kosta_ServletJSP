<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/21
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include 액션 태그 테스트</title>
</head>
<body>
<h2>include 액션 테스트</h2>
<%--
바로 넘길 때에는 따로 닫는 태그를 추가하지 않고 바로 닫아도 됨
<jsp:include page="includeTest2.jsp"/>
--%>
<%-- includeTest 페이지에 includeTest2를 포함시키는 것으로 includeTest2에 값을 전달하여 해당 값을 가진채로 includeTest2를 출력--%>
<jsp:include page="includeTest2.jsp">
    <jsp:param name="name" value="honggildong"/>
</jsp:include>
</body>
</html>
