<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ro">

<head>

    <title>Tabel Judecători</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>

    <script>
        $(document).ready(function ()
        {
            $('#judecatori_table').DataTable(
                {
                    pageLength: 25,
                    "language": {
                        "decimal": ",",
                        "emptyTable": "Nu există date în tabel",
                        "info": "Se afișează de la _START_ la _END_ din _TOTAL_ judecători",
                        "infoEmpty": "Se afișează 0 judecători",
                        "infoFiltered": "(selectați dintr-un total de _MAX_)",
                        "infoPostFix": "",
                        "thousands": ".",
                        "lengthMenu": "Afișează _MENU_ de judecători/pagină",
                        "loadingRecords": "Se încarcă...",
                        "processing": "Se procesează...",
                        "search": "Căutare:",
                        "zeroRecords": "Nu s-a găsit niciun judecător",
                        "paginate": {
                            "first": "Prima",
                            "last": "Ultima",
                            "next": "Înainte",
                            "previous": "Înapoi"
                        }
                    }
                }
            );
        });
    </script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Readex+Pro" rel="stylesheet">

    <style>
        *
        {
            font-family : 'Readex Pro', sans-serif;
        }

        .dataTables_filter
        {
            margin-bottom : 6px;
        }
    </style>

    <script>
        $(document).ready(function ()
        {
            $("#deleteJudecator").hide();
            $("#updateJudecator").hide();

            $("#update").click(function ()
            {
                $("#updateJudecator").show();
                $("#deleteJudecator").hide();
            });
            $("#delete").click(function ()
            {
                $("#deleteJudecator").show();
                $("#updateJudecator").hide();
            });
        });
    </script>

</head>

<body>

<div class="m-4" style="text-align: center;">
    <h1>
        Judecători
    </h1>
</div>

<p style="text-align: center;">
    <a href="index.html"><b>Home</b></a>
</p>

<div class="m-5">
    <table id="judecatori_table" class="table table-striped table-bordered">
        <thead>
        <tr class="table-dark text-center align-middle">
            <th scope="col">Nume</th>
            <th scope="col">CNP</th>
            <th scope="col">Data nasterii</th>
            <th scope="col">Specializare</th>
            <th scope="col">Preluare mandat</th>
            <th scope="col">Expirare mandat</th>
        </tr>
        </thead>

        <tbody>
        <%--@elvariable id="judecatorList" type="java.util.List"--%>
        <c:forEach var="JUDECATOR" items="${judecatorList}">
            <tr class="align-middle">
                <td>${JUDECATOR.NUME} ${JUDECATOR.PRENUME}</td>
                <td class="text-center">${JUDECATOR.CNP}</td>
                <td class="text-center">${JUDECATOR.DATA_NASTERII}</td>
                <td>${JUDECATOR.SPECIALIZARE}</td>
                <td class="text-center">${JUDECATOR.PRELUARE_MANDAT}</td>
                <td class="text-center">${JUDECATOR.EXPIRARE_MANDAT}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<form action="JudecatorController" method="POST">
    <p align="center">
        Modifică: <input type="checkbox" id="update">
        Șterge: <input type="checkbox" id="delete" onclick="document.getElementById('CNP').disabled = this.checked;">
        <br><br>
        <select name="ID_JUDECATOR">
            <c:forEach items="${judecatorList}" var="JUDECATOR">
                <option value="${JUDECATOR.ID_JUDECATOR}">${JUDECATOR.NUME} ${JUDECATOR.PRENUME}</option>
            </c:forEach>
        </select>
        <br><br>
        CNP: <input id="CNP" type="text" name="CNP">
        <br><br>
        <button type="submit" id="updateJudecator" name="modificaPacient"> Modifică</button>
        <button type="submit" id="deleteJudecator" name="stergePacient"> Șterge</button>
    </p>
</form>

</body>

</html>
