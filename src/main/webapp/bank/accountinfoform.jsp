<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
    body {
      margin: 0 auto;

    }

    .container {
      padding: 10px;
      border: 1px solid;
      width: 280px;
    }

    .header {
      height: 40px;
    }

    .row {
      height: 30px;
    }

    .title {
      width: 70px;
      float: left;
      font-weight: bold;
    }

    .input {
      float: left;
    }

    input[type='submit'] {
      font-weight: bold;
      width: 120px;
      background-color: lightgrey;
    }
  </style>
</head>
<body>
<center>
  <div class="header">
    <h3>계좌조회</h3>
  </div>
  <div class="container" id='query'>
    <form action="accountInfo" method="post" id='form'>
      <div class="row">
        <div class="title">계좌번호</div>
        <div class="input"><input type="text" name="id"></div>
      </div>
      <div class="button">
        <input type="submit" value="조 회">
      </div>
    </form>
  </div>
</center>
</body>
</html>