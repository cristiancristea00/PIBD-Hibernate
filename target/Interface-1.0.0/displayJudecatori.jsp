<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tabela Judecatori</title>
</head>
<body>
<center>
    <h1>
        Judecatori
    </h1>
</center>

<p align="center">
    <a href="index.html"><b>Home</b></a>
</p>

<table border="1" align="center">
    <tr>
        <th>CNP</th>
        <th>Nume</th>
        <th>Prenume</th>
        <th>Data nasterii</th>
        <th>Specializare</th>
        <th>Preluare mandat</th>
        <th>Expirare mandat</th>
    </tr>
    <%--@elvariable id="judecatorList" type="java.util.List"--%>
    <c:forEach var="JUDECATOR" items="${judecatorList}">
        <tr>
            <td>${JUDECATOR.CNP}</td>
            <td>${JUDECATOR.NUME}</td>
            <td>${JUDECATOR.PRENUME}</td>
            <td>${JUDECATOR.DATA_NASTERII}</td>
            <td>${JUDECATOR.SPECIALIZARE}</td>
            <td>${JUDECATOR.PRELUARE_MANDAT}</td>
            <td>${JUDECATOR.EXPIRARE_MANDAT}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
