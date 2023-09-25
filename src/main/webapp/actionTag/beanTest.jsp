<%@ page import="com.example.kosta_test.actionTag.Person" %><%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/21
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String name =request.getParameter("name");
  Integer age = Integer.parseInt(request.getParameter("age"));
  Person person = new Person();
  person.setName(name);
  person.setAge(age);
%>
<jsp:useBean id="person" class="com.example.kosta_test.actionTag.Person">
 <%--  <jsp:setProperty name="person" property="name" param="name1"/>
  <jsp:setProperty name="person" property="age" param="age1"/> --%>
  <%-- property에 *을 넣어줄 경우 이름이 동일하면 위처럼 하나씩 해줄 필요 없이 한 줄로 매칭이 가능함--%>
  <jsp:setProperty name="person" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>beanTest.html에 객체를 생성할 jsp 페이지</title>
</head>
<body>
<%-- <h3> <%=person.getName()%></h3>
<h3> <%=person.getAge()%></h3> --%>
<h3> <jsp:getProperty name="person" property="name1"/></h3>
<h3> <jsp:getProperty name="person" property="age1"/></h3>

</body>
</html>
