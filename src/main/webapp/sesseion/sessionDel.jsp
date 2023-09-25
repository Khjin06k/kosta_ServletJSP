<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 세션에 들어있는 값 중 하나 삭제 --%>
<%session.removeAttribute("nickname");%>
<script>
  location.href="sessionTest.jsp"; // sendRedirect 느낌
</script>
