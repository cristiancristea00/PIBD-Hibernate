<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ro">

<head>

    <title>Tabel Programări</title>

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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Readex+Pro" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">


    <script>
        $(document).ready(function ()
        {
            $('#programari_table').DataTable(
                {
                    pageLength: 10,
                    "language": {
                        "decimal": ",",
                        "emptyTable": "Nu există date în tabel",
                        "info": "Se afișează de la _START_ la _END_ din _TOTAL_ programări",
                        "infoEmpty": "Se afișează 0 programări",
                        "infoFiltered": "(selectate dintr-un total de _MAX_)",
                        "infoPostFix": "",
                        "thousands": ".",
                        "lengthMenu": "Afișează _MENU_ de programări/pagină",
                        "loadingRecords": "Se încarcă...",
                        "processing": "Se procesează...",
                        "search": "Căutare:",
                        "zeroRecords": "Nu s-a găsit nicio programare",
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

</head>

<body>

<div class="m-4 title">
    Programări
</div>

<div class="m-2 header">
    <a href="index.html">Home</a>
</div>

<div class="m-5">
    <table id="programari_table" class="table table-striped cell-border">
        <thead>
        <tr class="table-dark text-center align-middle">
            <th scope="col">Număr</th>
            <th scope="col">Nume</th>
            <th scope="col">Telefon</th>
            <th scope="col">Obiect</th>
            <th scope="col">Materie juridică</th>
            <th scope="col">Stadiu procesual</th>
            <th scope="col">Reclamant</th>
            <th scope="col">Pârât</th>
            <th scope="col">Oraș</th>
            <th scope="col">Locație</th>
            <th scope="col">Sala</th>
            <th scope="col">Data</th>
            <th scope="col">Ora</th>
        </tr>
        </thead>

        <tbody>
        <%--@elvariable id="programareList" type="java.util.List"--%>
        <c:forEach var="PROGRAMARE" items="${programareList}">
            <tr class="align-middle">
                <td class="text-center">${PROGRAMARE.PROCES.NUMAR}</td>
                <td class="text-center">${PROGRAMARE.JUDECATOR.PRENUME} ${PROGRAMARE.JUDECATOR.NUME}</td>
                <td class="text-center">${PROGRAMARE.JUDECATOR.TELEFON}</td>
                <td>${PROGRAMARE.PROCES.OBIECT}</td>
                <td class="text-center">${PROGRAMARE.PROCES.MATERIE_JURIDICA}</td>
                <td class="text-center">${PROGRAMARE.PROCES.STADIU_PROCESUAL}</td>
                <td>${PROGRAMARE.PROCES.RECLAMANT}</td>
                <td>${PROGRAMARE.PROCES.PARAT}</td>
                <td>${PROGRAMARE.ORAS}</td>
                <td>${PROGRAMARE.LOCATIE}</td>
                <td class="text-center">${PROGRAMARE.SALA}</td>
                <td class="text-center">${PROGRAMARE.DATA}</td>
                <td class="text-center">${PROGRAMARE.ORA}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>

</html>
