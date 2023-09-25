<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 세션 자체를 무력화 >> 세션에 있는 모든 값들을 삭제 --%>
<%session.invalidate();%>
<script>
  location.href="sessionTest.jsp"; // sendRedirect 느낌
</script>
