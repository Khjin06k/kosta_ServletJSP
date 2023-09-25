<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body{
        position : relative;
        height: 800px;
    }
</style>
<head>
  <title>Title</title>
</head>
<body>
<% String ipage = (String)request.getAttribute("page"); %>

<table style="width: 100%">
    <thead>
      <tr>
          <td>
             <%-- 아래와 동일 <%@ include file="header.jsp" %>--%>
                 <%--아래처럼 인클루드 액션 태그를 이용할 수 있음 <% pageContext.include("header.jsp"); %>--%>
                 <jsp:include page="header.jsp"/>
          </td>
      </tr>
    </thead>
    <%if(ipage!=null){%>
    <tbody>

      <tr>
        <td>
            <!-- 페이지가 아닌 get으로 가져온 코드를 가지고 오고 싶다면
            자바 코드이기 때문에 <%--<%@ include file="파일명"%>--%> 으로 작성해줄 수 없음 -->
            <%-- ipage로 가지고 온 page가 비어있을 수 있기 때문에 해당 부분에 대한 if문 작성 --%>
            <%--
                if(ipage != null){
                    pageContext.include(ipage+".jsp");
                }
            --%>
            <jsp:include page="<%=ipage%>"/>
        </td>
      </tr>
      <%-- footer.jsp를 인클루드 액션을 통해 가져옴 --%>
      <td><jsp:include page="footer.jsp"/></td>
    </tbody>
    <%}%>
</table>
</body>
</html>
