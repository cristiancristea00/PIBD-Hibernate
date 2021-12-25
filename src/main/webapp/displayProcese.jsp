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
                        "lengthMenu": "Afișează _MENU_ procese/pagină",
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
            <button class="btn btn-primary btn-lg m-2 fix-button" onclick="location.href='/';" value="Home">
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

<!-- Proces Update Modal -->
<div class="modal fade" id="procese_update_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="procese_update_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="procese_update_modal_label">Modifică un proces</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Procese" method="GET">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Select_proces_Update" aria-label="Select proces"
                                        id="Select_proces_Update">
                                    <c:forEach items="${procesList}" var="proces">
                                        <option value="${proces.ID_PROCES}">${proces.NUMAR} (${proces.OBIECT})</option>
                                    </c:forEach>
                                </select>
                                <label for="Select_proces_Update">Proces</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Numar_update" placeholder="Număr" aria-label="Număr" id="Numar_update"
                                       maxlength="50" pattern="\d{1,5}\/\d{1,2}\/\d{4}">
                                <label for="Numar_update">Număr</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <textarea type="text" class="form-control" name="Obiect_update" placeholder="Obiect" aria-label="Obiect"
                                          id="Obiect_update" maxlength="100"></textarea>
                                <label for="Obiect_update">Obiect</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Materie_juridica_update" placeholder="Materie juridică"
                                       aria-label="Materie juridică" id="Materie_juridica_update" maxlength="50" pattern="[A-Z]{1}.*">
                                <label for="Materie_juridica_update">Materie juridică</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Stadiu_procesual_update" aria-label="Stadiu procesual"
                                        id="Stadiu_procesual_update">
                                    <option value="" selected></option>
                                    <option value="Apel">Apel</option>
                                    <option value="Fond">Fond</option>
                                    <option value="Recurs">Recurs</option>
                                    <option value="Revizuire">Revizuire</option>
                                    <option value="Contestație">Contestație</option>
                                </select>
                                <label for="Stadiu_procesual_update">Stadiu procesual</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <textarea type="text" class="form-control" name="Reclamant_update" placeholder="Reclamant" aria-label="Reclamant"
                                          id="Reclamant_update" maxlength="100"></textarea>
                                <label for="Reclamant_update">Reclamant</label>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <textarea type="text" class="form-control" name="Parat_update" placeholder="Pârât" aria-label="Pârât"
                                          id="Parat_update" maxlength="100"></textarea>
                                <label for="Parat_update">Pârât</label>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="updateProces">Modifică</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Procese Delete Modal -->
<div class="modal fade" id="procese_delete_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="procese_delete_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="procese_delete_modal_label">Șterge un proces</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Procese" method="GET">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Select_proces_Delete" aria-label="Select proces"
                                        id="Select_proces_Delete">
                                    <%--@elvariable id="procesList" type="java.util.List"--%>
                                    <c:forEach items="${procesList}" var="proces">
                                        <option value="${proces.ID_PROCES}">${proces.NUMAR} (${proces.OBIECT})</option>
                                    </c:forEach>
                                </select>
                                <label for="Select_proces_Delete">Judecător</label>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="deleteProces">Șterge</button>
                </div>
            </form>
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
