<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/21
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%>
<%-- forwardPage로 포워드 시키라는 의미, page를 request에서 "forwardPage를 파람스로 가지는 페이지를 포워딩 하라는 것으로,
 forwardTest에서 request이면서 forwardPage인 것인 forwardTest2를 포워딩 --%>
<jsp:forward page='<%=request.getParameter("forwardPage")%>'>
    <jsp:param name="tel" value="010-1111-2222"/>
</jsp:forward>
