<%--
  Created by IntelliJ IDEA.
  User: gmlwls
  Date: 2023/09/25
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<x:parse var="xmldata">
    <!--파싱해야 할 데이터로 xml 형태로 되어 있음 -->
    <students>
        <student>
            <name> 홍길동 </name>
            <age>18</age>
            <gender>남</gender>
            <phone>010-1111-2222</phone>
        </student>
        <student>
            <name> 김길동 </name>
            <age>25</age>
            <gender>남</gender>
            <phone>010-1111-3333</phone>
        </student>
        <student>
            <name> 고길동 </name>
            <age>30</age>
            <gender>남</gender>
            <phone>010-1111-3333</phone>
        </student>
    </students>
</x:parse>

<!--xmldata의 student를 하나씩 가져 오겠다는 것 -->
<x:forEach select="$xmldata//student">
    <x:out select="./name"/>
    <x:out select="./age"/>
    <x:out select="./gender"/>
    <x:out select="./phone"/>
</x:forEach>
</body>
</html>
