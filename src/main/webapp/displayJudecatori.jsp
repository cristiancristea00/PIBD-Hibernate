<%@ page contentType="text/html;charset=UTF-8" %>
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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Readex+Pro" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">

    <script>
        $(document).ready(function ()
        {
            $('#judecatori_table').DataTable(
                {
                    pageLength: 10,
                    "language": {
                        "decimal": ",",
                        "emptyTable": "Nu există date în tabel",
                        "info": "Se afișează de la _START_ la _END_ din _TOTAL_ judecători",
                        "infoEmpty": "Se afișează 0 judecători",
                        "infoFiltered": "(selectați dintr-un total de _MAX_)",
                        "infoPostFix": "",
                        "thousands": ".",
                        "lengthMenu": "Afișează _MENU_ judecători/pagină",
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

</head>

<body>

<div class="m-4 title">
    Judecători
</div>

<div class="container">
    <div class="row">

        <div class="col-sm text-center">
            <button type="submit" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#judecatori_update_modal">
                Modifică un judecător
            </button>
        </div>

        <div class="col-sm text-center menu">
            <button class="btn btn-primary btn-lg m-2 fix-button" onclick="location.href='/';" value="Home">
                Home
            </button>
        </div>

        <div class="col-sm text-center">
            <button type="submit" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#judecatori_delete_modal">
                Șterge un judecător
            </button>
        </div>
    </div>
</div>

<!-- Judecători Update Modal -->
<div class="modal fade" id="judecatori_update_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="judecatori_update_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="judecatori_update_modal_label">Modifică un judecător</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Judecatori" method="POST">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Select_judecator_Update" aria-label="Select judecator"
                                        id="Select_judecator_Update">
                                    <c:forEach items="${judecatorList}" var="judecator">
                                        <option value="${judecator.ID_JUDECATOR}">${judecator.PRENUME} ${judecator.NUME} (${judecator.CNP})</option>
                                    </c:forEach>
                                </select>
                                <label for="Select_judecator_Update">Judecător</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Prenume_update" placeholder="Prenume" aria-label="Prenume"
                                       id="Prenume_update" maxlength="50" pattern="[A-Za-zăâîțșĂÂÎȚȘ]+(-[A-Za-zăâîțșĂÂÎȚȘ]+)*"
                                       autocomplete="given-name">
                                <label for="Prenume_update">Prenume</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Nume_update" placeholder="Nume" aria-label="Nume" id="Nume_update"
                                       maxlength="50" pattern="[A-Za-zăâîțșĂÂÎȚȘ]+(-[A-Za-zăâîțșĂÂÎȚȘ]+)*" autocomplete="family-name">
                                <label for="Nume_update">Nume</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="CNP_update" placeholder="Cod Numeric Personal (CNP)" aria-label="CNP"
                                       id="CNP_update" maxlength="13" pattern="\d{13}">
                                <label for="CNP_update">Cod Numeric Personal (CNP)</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="tel" class="form-control" name="Telefon_update" placeholder="Telefon" aria-label="Telefon"
                                       id="Telefon_update" autocomplete="tel" maxlength="13" pattern="\+\d{11,12}">
                                <label for="Telefon_update">Telefon</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="email" class="form-control" name="Email_update" placeholder="Email" aria-label="Email" id="Email_update"
                                       autocomplete="email" maxlength="50"
                                       pattern="([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)">
                                <label for="Email_update">Email</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Specializare_update" aria-label="Specializare"
                                        id="Specializare_update">
                                    <option selected value=""></option>
                                    <option value="Cauze militare">Cauze militare</option>
                                    <option value="Cauze comerciale">Cauze comerciale</option>
                                    <option value="Cauze de drept constituțional">Cauze de drept constituțional</option>
                                    <option value="Cauze de contencios administrativ și fiscal">Cauze de contencios administrativ și fiscal</option>
                                    <option value="Cauze în materie de dreptul familiei și minori">Cauze în materie de dreptul familiei și minori
                                    </option>
                                    <option value="Cauze civile și de executare silită în materie civilă">Cauze civile și de executare silită în
                                        materie civilă
                                    </option>
                                    <option value="Cauze în materie de conflicte de muncă și asigurări sociale">Cauze în materie de conflicte de muncă
                                        și asigurări sociale
                                    </option>
                                    <option value="Cauze penale și de punere în executare a hotărârilor pronunțate în materie penală">Cauze penale și
                                        de punere în executare a hotărârilor pronunțate în materie penală
                                    </option>
                                </select>
                                <label for="Specializare_update">Specializare</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="date" class="form-control" name="Preluare_mandat_update" placeholder="Preluare mandat"
                                       aria-label="Preluare mandat" id="Preluare_mandat_update">
                                <label for="Preluare_mandat_update">Preluare mandat</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="date" class="form-control" name="Expirare_mandat_update" placeholder="Expirare mandat"
                                       aria-label="Expirare mandat" id="Expirare_mandat_update">
                                <label for="Expirare_mandat_update">Expirare mandat</label>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="updateJudecator">Modifică</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Judecători Delete Modal -->
<div class="modal fade" id="judecatori_delete_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="judecatori_delete_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="judecatori_delete_modal_label">Șterge un judecător</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Judecatori" method="POST">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Select_judecator_Delete" aria-label="Select judecator"
                                        id="Select_judecator_Delete">
                                    <%--@elvariable id="judecatorList" type="java.util.List"--%>
                                    <c:forEach items="${judecatorList}" var="judecator">
                                        <option value="${judecator.ID_JUDECATOR}">${judecator.PRENUME} ${judecator.NUME} (${judecator.CNP})</option>
                                    </c:forEach>
                                </select>
                                <label for="Select_judecator_Delete">Judecător</label>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="deleteJudecator">Șterge</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="m-5">
    <table id="judecatori_table" class="table table-striped cell-border">
        <thead>
        <tr class="table-dark text-center align-middle">
            <th scope="col">Nume</th>
            <th scope="col">CNP</th>
            <th scope="col">Telefon</th>
            <th scope="col">Email</th>
            <th scope="col">Specializare</th>
            <th scope="col">Preluare mandat</th>
            <th scope="col">Expirare mandat</th>
        </tr>
        </thead>

        <tbody>
        <%--@elvariable id="judecatorList" type="java.util.List"--%>
        <c:forEach var="JUDECATOR" items="${judecatorList}">
            <tr class="align-middle">
                <td>${JUDECATOR.PRENUME} ${JUDECATOR.NUME}</td>
                <td class="text-center">${JUDECATOR.CNP}</td>
                <td class="text-center">${JUDECATOR.TELEFON}</td>
                <td>${JUDECATOR.EMAIL}</td>
                <td>${JUDECATOR.SPECIALIZARE}</td>
                <td class="text-center">${JUDECATOR.PRELUARE_MANDAT}</td>
                <td class="text-center">${JUDECATOR.EXPIRARE_MANDAT}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>

</html>
