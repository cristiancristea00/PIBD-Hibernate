<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tabela Programări</title>
</head>
<body>
<center>
    <h1>
        Programări
    </h1>
</center>

<p align="center">
    <a href="index.html"><b>Home</b></a>
</p>

<table border="1" align="center">
    <tr>
        <th>Nume</th>
        <th>Prenume</th>
        <th>Număr</th>
        <th>Obiect</th>
        <th>Materie juridică</th>
        <th>Stadiu procesual</th>
        <th>Reclamant</th>
        <th>Pârât</th>
        <th>Oraș</th>
        <th>Locație</th>
        <th>Sala</th>
        <th>Data</th>
        <th>Ora</th>
    </tr>
    <%--@elvariable id="programareList" type="java.util.List"--%>
    <c:forEach var="PROGRAMARE" items="${programareList}">
        <tr>
            <td>${PROGRAMARE.JUDECATOR.NUME}</td>
            <td>${PROGRAMARE.JUDECATOR.PRENUME}</td>
            <td>${PROGRAMARE.PROCES.NUMAR}</td>
            <td>${PROGRAMARE.PROCES.OBIECT}</td>
            <td>${PROGRAMARE.PROCES.MATERIE_JURIDICA}</td>
            <td>${PROGRAMARE.PROCES.STADIU_PROCESUAL}</td>
            <td>${PROGRAMARE.PROCES.RECLAMANT}</td>
            <td>${PROGRAMARE.PROCES.PARAT}</td>
            <td>${PROGRAMARE.ORAS}</td>
            <td>${PROGRAMARE.LOCATIE}</td>
            <td>${PROGRAMARE.SALA}</td>
            <td>${PROGRAMARE.DATA}</td>
            <td>${PROGRAMARE.ORA}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
