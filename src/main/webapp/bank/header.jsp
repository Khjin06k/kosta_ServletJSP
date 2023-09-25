<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String id = (String)session.getAttribute("id"); %>
<!-- main에 header를 포함시킬 것이기 때문에 <html>~</html> 없이 내용만 작성하면 됨 -->
<style>
    *{margin: 0 auto}
    a {text-decoration: none}
    .outerDiv{
        width: 100%;
        height: 100px;
        background-color: orange;
    }
</style>

<div class="outerDiv">
    <i><h1 style="text-align: center">kosta bank</h1></i><br>
    <div class="innerDiv">
        <div style="float: left; margin-right:10px;">
            <!-- 각 역할을 할 페이지 연결 진행 -->
            <!-- 해당 jsp 자체 페이지로 이동하는 것이 아니라 main에서 헤더를 유지한 채 그 아래에 각 페이지를 나타내고 싶은 것 -->
            <!-- url 매핑이 main(Main 서블릿)이고 a 태그니까 doGet 함수의 request에 파라미터 값으로 page 값을 가져가는 것(name은 page, value는 makeAccount2.jsp)
            page를 사용하는 것이 아닌 request.getRequestDispatcher를 사용하여 main.jsp에게 위힘
            forward 시켜서 main.jsp에 넘김
            include한 페이지에서도 가져다 쓸 수 있음-->
            <a href="main?page=makeAccount"> 계좌개설 </a>
            <a href="main?page=deposit"> 입금 </a>
            <a href="main?page=withdraw"> 출금 </a>
            <a href="main?page=accountInfoFrom"> 계좌조회 </a>
            <a href="allAccountInfo"> 전체계좌조회 </a>
        </div>
        <div style="float: right; margin-right:10px">
            <% if(id==null) {%>
            <a href="main?page=login"> 로그인 </a>
            <%}else{ %>
            <%=id %> 님 환영합니다. <a href="logOut"> 로그아웃 </a>
            <% } %>
            <a href="main?page=signup"> 회원가입 </a>
        </div>
    </div>
</div>
