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
                        "lengthMenu": "Afișează _MENU_ programări/pagină",
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

<div class="container">
    <div class="row">

        <div class="col-sm text-center">
            <button type="submit" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#programari_update_modal">
                Modifică o programare
            </button>
        </div>

        <div class="col-sm text-center menu">
            <button class="btn btn-primary btn-lg m-2 fix-button" onclick="location.href='/';" value="Home">
                Home
            </button>
        </div>

        <div class="col-sm text-center">
            <button type="submit" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#programari_delete_modal">
                Șterge o programare
            </button>
        </div>
    </div>
</div>

<!-- Programări Update Modal -->
<div class="modal fade" id="programari_update_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="programari_update_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="programari_update_modal_label">Modifică o programare</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Programari" method="GET">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Select_programare_Update" aria-label="Programare"
                                        id="Select_programare_Update">
                                    <%--@elvariable id="programareList" type="java.util.List"--%>
                                    <c:forEach var="programare" items="${programareList}">
                                        <option value="${programare.ID_PROGRAMARE}">${programare.PROCES.NUMAR}
                                            - ${programare.JUDECATOR.PRENUME} ${programare.JUDECATOR.NUME} (${programare.JUDECATOR.CNP})
                                        </option>
                                    </c:forEach>
                                </select>
                                <label for="Select_programare_Update">Programare</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Oras_update" placeholder="Oraș" aria-label="Oraș" id="Oras_update"
                                       maxlength="20" pattern="[A-Z]{1}.*">
                                <label for="Oras_update">Oraș</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Locatie_update" placeholder="Locație" aria-label="Locație"
                                       id="Locatie_update" maxlength="50" pattern="[A-Z]{1}.*">
                                <label for="Locatie_update">Locație</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Sala_update" placeholder="Sala" aria-label="Sala" id="Sala_update"
                                       maxlength="10" pattern="[A-Z]{1}.*">
                                <label for="Sala_update">Sala</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="date" class="form-control" name="Data_update" placeholder="Data" aria-label="Data" id="Data_update">
                                <label for="Data_update">Data</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="time" class="form-control" name="Ora_update" placeholder="Ora" aria-label="Ora" id="Ora_update">
                                <label for="Ora_update">Ora</label>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="updateProgramare">Modifică</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Programări Delete Modal -->
<div class="modal fade" id="programari_delete_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="programari_delete_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="programari_delete_modal_label">Șterge o programare</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Programari" method="GET">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Select_programare_Delete" aria-label="Select programare"
                                        id="Select_programare_Delete">
                                    <%--@elvariable id="programareList" type="java.util.List"--%>
                                    <c:forEach var="programare" items="${programareList}">
                                        <option value="${programare.ID_PROGRAMARE}">${programare.PROCES.NUMAR}
                                            - ${programare.JUDECATOR.PRENUME} ${programare.JUDECATOR.NUME} (${programare.JUDECATOR.CNP})
                                        </option>
                                    </c:forEach>
                                </select>
                                <label for="Select_programare_Delete">Programare</label>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="deleteProgramare">Șterge</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="m-5">
    <table id="programari_table" class="table table-striped cell-border">
        <thead>
        <tr class="table-dark text-center align-middle">
            <th scope="col">Număr</th>
            <th scope="col">Materie juridică</th>
            <th scope="col">Stadiu procesual</th>
            <th scope="col">Obiect</th>
            <th scope="col">Nume</th>
            <th scope="col">Email</th>
            <th scope="col">Telefon</th>
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
                <td class="text-center">${PROGRAMARE.PROCES.MATERIE_JURIDICA}</td>
                <td class="text-center">${PROGRAMARE.PROCES.STADIU_PROCESUAL}</td>
                <td>${PROGRAMARE.PROCES.OBIECT}</td>
                <td class="text-center">${PROGRAMARE.JUDECATOR.PRENUME} ${PROGRAMARE.JUDECATOR.NUME}</td>
                <td class="text-center">${PROGRAMARE.JUDECATOR.EMAIL}</td>
                <td class="text-center">${PROGRAMARE.JUDECATOR.TELEFON}</td>
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
