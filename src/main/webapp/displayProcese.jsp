<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ro">

<head>
    <title>Tabel Procese</title>

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
            $('#procese_table').DataTable(
                {
                    pageLength: 10,
                    "language": {
                        "decimal": ",",
                        "emptyTable": "Nu există date în tabel",
                        "info": "Se afișează de la _START_ la _END_ din _TOTAL_ procese",
                        "infoEmpty": "Se afișează 0 procese",
                        "infoFiltered": "(selectate dintr-un total de _MAX_)",
                        "infoPostFix": "",
                        "thousands": ".",
                        "lengthMenu": "Afișează _MENU_ de procese/pagină",
                        "loadingRecords": "Se încarcă...",
                        "processing": "Se procesează...",
                        "search": "Căutare:",
                        "zeroRecords": "Nu s-a găsit niciun proces",
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
    Procese
</div>

<div class="container">
    <div class="row">

        <div class="col-sm text-center">
            <button type="submit" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#procese_update_modal">
                Modifică un proces
            </button>
        </div>

        <div class="col-sm text-center menu">
            <button class="btn btn-primary btn-lg m-2 fix-button" onclick="location.href='index.jsp';" value="Home">
                Home
            </button>
        </div>

        <div class="col-sm text-center">
            <button type="submit" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#procese_delete_modal">
                Șterge un proces
            </button>
        </div>
    </div>
</div>

<div class="m-5">
    <table id="procese_table" class="table table-striped cell-border">
        <thead>
        <tr class="table-dark text-center align-middle">
            <th scope="col">Număr</th>
            <th scope="col">Obiect</th>
            <th scope="col">Materie juridică</th>
            <th scope="col">Stadiu procesual</th>
            <th scope="col">Reclamant</th>
            <th scope="col">Pârât</th>
        </tr>
        </thead>

        <tbody>
        <%--@elvariable id="procesList" type="java.util.List"--%>
        <c:forEach var="PROCES" items="${procesList}">
            <tr class="align-middle">
                <td>${PROCES.NUMAR}</td>
                <td>${PROCES.OBIECT}</td>
                <td class="text-center">${PROCES.MATERIE_JURIDICA}</td>
                <td class="text-center">${PROCES.STADIU_PROCESUAL}</td>
                <td>${PROCES.RECLAMANT}</td>
                <td>${PROCES.PARAT}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>

</html>
