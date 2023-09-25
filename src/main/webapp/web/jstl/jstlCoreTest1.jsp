<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/25
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="test" value="Hello JSTL!!"/> <!-- var는 변수명, value는 실제 값 -->
<h3><c:out value="${test}"/></h3>
<c:remove var="test"/> <!-- 삭제 -->
<h3><c:out value="${test}"/></h3> <!-- 삭제되었으므로 출력 불가-->

<c:catch var="err">
    <%=10/0%>
</c:catch>
<c:out value="${err }"/> <!-- err에서 난 에러가 출력됨 (에러가 발생하지 않으면 아무것도 출력되지 않음-->

<!-- if문 -->
<!-- if문에 else가 없으며, else가 필요할 경우 if문이 아닌 choose를 사용 -->
<c:if test="${5<10}">
    <h3>5는 10보다 작다</h3>
</c:if>

<c:if test="${6+3==9}">
    <h3>3+6은 9이다</h3>
</c:if>

<!--choose문 -->
<c:choose>
    <!-- else를 위한 조건문은 when을 사용한다 -->
    <c:when test="${5+10==50}">
        <h3>5+10은 50이다</h3>
    </c:when>
    <c:otherwise>
        <h3>5+10은 50이 아니다</h3>
    </c:otherwise>
</c:choose>




</body>
</html>
