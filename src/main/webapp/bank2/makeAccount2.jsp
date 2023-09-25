<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width-device-width, initial-scale=1.0">
  <title>계좌개설</title>
  <style>
    h1{text-align: center;}

    .box{
      margin: 0 auto;
      padding : 20px;
      width: 50%;
      border : 2px solid black;
      text-align: center;
      vertical-align: center;
    }

    button{
      background-color: silver;
      border:2px solid black;
      width: 200px;
      height: 30px;
    }
    .in{
      padding:5px;
    }
    table{
      margin : 0 auto;
      text-align: center;
    }

  </style>
  <script>
    $(document).ready(function(){
      $("input[name='type']").change(function(){
        var test = $("input[name='type']:checked").val();
        if(test=='일반'){
          $("select[name=grade]").attr("disabled", true);
          // $('#grade').attr("disabled",true);
        }else {
          $("select[name=grade]").attr("disabled", false);
          //$('#grade').attr("disabled", false);
        }
      })
    });
  </script>
  <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

</head>

<body>
<% pageContext.include("header2.jsp"); %>

<form action="makeAccount2" method="post">
  <h1> 계좌개설 </h1>
  <div class="box" type="text-align:center">
    <table >
      <tr>
        <th>계좌번호</th>
        <td> <input type="text" name = "id"></td>
      </tr>
      <tr>
        <th>이름</th>
        <td> <input type="text" name = "name"></td>
      </tr>
      <tr>
        <th>입금액</th>
        <td> <input type="text" name = "money"></td>
      </tr>
      <tr>
        <th>종류</th>
        <td><input type="radio" name="type" value="일반"> 일반
          <input type="radio" name="type" value="특수"> 특수</td>
      </tr>
      <tr>
        <th>등급</th>
        <td><select id="grade" name = "grade">
          <option value="VIP">VIP</option>
          <option value="GOLD">GOLD</option>
          <option value="SILVER">SILVER</option>
          <option value="NORMAL">NORMAL</option>
        </select></td>
      </tr>

    </table>

    <button type="submit" class="in">개설</button>
  </div>
</form>
</body>

</html>
