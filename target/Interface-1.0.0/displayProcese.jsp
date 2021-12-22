<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tabela Procese</title>
</head>
<body>
<center>
    <h1>
        Procese
    </h1>
</center>

<p align="center">
    <a href="index.html"><b>Home</b></a>
</p>

<table border="1" align="center">
    <tr>
        <th>Număr</th>
        <th>Obiect</th>
        <th>Materie juridică</th>
        <th>Stadiu procesual</th>
        <th>Reclamant</th>
        <th>Pârât</th>
    </tr>
    <%--@elvariable id="procesList" type="java.util.List"--%>
    <c:forEach var="PROCES" items="${procesList}">
        <tr>
            <td>${PROCES.NUMAR}</td>
            <td>${PROCES.OBIECT}</td>
            <td>${PROCES.MATERIE_JURIDICA}</td>
            <td>${PROCES.STADIU_PROCESUAL}</td>
            <td>${PROCES.RECLAMANT}</td>
            <td>${PROCES.PARAT}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
