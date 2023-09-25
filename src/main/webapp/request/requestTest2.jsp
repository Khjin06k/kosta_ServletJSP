<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>URL/URI, 요청 방식에 관련된 정보 예제</title>
</head>
<body>
<h1>URL/URI, 요청 방식에 관련된 정보 예제</h1>
<table border="1">
    <tr>
        <td>쿠키정보</td>
        <%
            Cookie[] cookie = request.getCookies();
            if(cookie==null) {
        %>
        <td>쿠기 정보가 없습니다.</td>
        <%
        } else {
            for(Cookie c : cookie) {
        %>
        <td><%=c.getName() %>(<%=c.getValue() %>)</td>
        <%
                }
            }
        %>
    </tr>
    <tr>
        <td>서버 도메인명</td>
        <td><%=request.getServerName() %></td>
    </tr>
    <tr>
        <td>요청 URL</td>
        <td><%=request.getRequestURL()%></td>
    </tr>
    <tr>
        <td>요청 URI</td>
        <td><%=request.getRequestURI()%></td>
    </tr>
    <tr>
        <td>요청 쿼리</td>
        <td><%=request.getQueryString()%></td>
    </tr>
    <tr>
        <td>클라이언트 호스트명</td>
        <td><%=request.getRemoteHost()%></td>
    </tr>
    <tr>
        <td>클라이언트 IP 주소</td>
        <td><%=request.getRemoteAddr()%></td>
    </tr>
    <tr>
        <td>프로토콜</td>
        <td><%=request.getProtocol()%></td>
    </tr>
    <tr>
        <td>요청방식</td>
        <td><%=request.getMethod()%></td>
    </tr>
    <tr>
        <td>컨택스트 경로</td>
        <td><%=request.getContextPath()%></td>
    </tr>
</table>
</body>
</html>
