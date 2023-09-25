<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/20
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request Test</title>
</head>
<body>
<h1>Request 예제입니다.</h1>
<form action="requestTest1.jsp" method="post">
    <table border="1" width="400">
        <tr>
            <td>이름</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>성별</td>
            <td>
                남<input type="radio" name="gender" value="male">
                여<input type="radio" name="gender" value="female">
            </td>
        </tr>
        <tr>
            <td>취미</td>
            <td>
                <!-- 체크 되어있는 것만 가지고 오고, 1개 이상일 때에는 배열 형태로 가져옴 -->
                독서<input type="checkbox" name="hobby" value="독서">
                게임<input type="checkbox" name="hobby" value="게임">
                TV시청<input type="checkbox" name="hobby" value="TV시청">
                축구<input type="checkbox" name="hobby" value="축구">
                기타<input type="checkbox" name="hobby" value="기타">
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="전송"></td>
        </tr>
    </table>
</form>
</body>
</html>

