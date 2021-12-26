<%@ page import="DAOImplement.JudecatorDAOImpl" %>
<%@ page import="DAOImplement.ProcesDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="JavaBean.Judecator" %>
<%@ page import="JavaBean.Proces" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ro">

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Readex+Pro" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">

    <title>IJR</title>

</head>

<body>

<%
    JudecatorDAOImpl judecatorDAO = new JudecatorDAOImpl();
    ProcesDAOImpl procesDAO = new ProcesDAOImpl();
    List<Judecator> judecatorList = judecatorDAO.displayJudecatori();
    List<Proces> procesList = procesDAO.displayProcese();
    request.setAttribute("judecatorList", judecatorList);
    request.setAttribute("procesList", procesList);
%>

<div class="m-4 title">
    Institutul Juridic Român
</div>

<div class="container">
    <div class="row">
        <div class="col-sm text-center">
            <div class="m-3 header">
                Judecători
            </div>

            <div class="span2">
                <form role="form" action="Judecatori" method="GET">
                    <input type="submit" class="btn btn-primary btn-lg m-2 fix-button" name="displayJudecatori" value="Tabelul cu judecători">
                </form>

                <button type="button" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#judecatori_add_modal">
                    Adaugă un judecător
                </button>
            </div>

        </div>
        <div class="col-sm text-center">
            <div class="m-3 header">
                Procese
            </div>


            <form role="form" action="Procese" method="GET">
                <input type="submit" class="btn btn-primary btn-lg m-2 fix-button" name="displayProcese" value="Tabelul cu procese">
            </form>
            <button type="button" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#procese_add_modal">
                Adaugă un proces
            </button>

        </div>
        <div class="col-sm text-center">
            <div class="m-3 header">
                Programări
            </div>


            <form role="form" action="Programari" method="GET">
                <input type="submit" class="btn btn-primary btn-lg m-2 fix-button" name="displayProgramari" value="Tabelul cu programări">
            </form>
            <button type="button" class="btn btn-primary btn-lg m-2 fix-button" data-bs-toggle="modal" data-bs-target="#programari_add_modal">
                Adaugă o programare
            </button>
        </div>
    </div>
</div>

<!-- Judecători Add Modal -->
<div class="modal fade" id="judecatori_add_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="judecatori_add_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="judecatori_add_modal_label">Adaugă un judecător nou</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Judecatori" method="POST">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Prenume_add" placeholder="Prenume" aria-label="Prenume" id="Prenume_add"
                                       maxlength="50" autocomplete="given-name" pattern="[A-ZĂÂÎȚȘ]{1}[a-zăâîțș]+(-[A-ZĂÂÎȚȘ]{1}[a-zăâîțș]+)*" required>
                                <label for="Prenume_add">Prenume</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Nume_add" placeholder="Nume" aria-label="Nume" id="Nume_add"
                                       maxlength="50" autocomplete="family-name" pattern="[A-Za-zăâîțșĂÂÎȚȘ]+(-[A-Za-zăâîțșĂÂÎȚȘ]+)*" required>
                                <label for="Nume_add">Nume</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="CNP_add" placeholder="Cod Numeric Personal (CNP)" aria-label="CNP"
                                       id="CNP_add" maxlength="13" pattern="\d{13}" required>
                                <label for="CNP_add">Cod Numeric Personal (CNP)</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="tel" class="form-control" name="Telefon_add" placeholder="Telefon" aria-label="Telefon" id="Telefon_add"
                                       autocomplete="tel" maxlength="13" pattern="\+\d{11,12}" required>
                                <label for="Telefon_add">Telefon</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="email" class="form-control" name="Email_add" placeholder="Email" aria-label="Email" id="Email_add"
                                       autocomplete="email" maxlength="50"
                                       pattern="([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)" required>
                                <label for="Email_add">Email</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Specializare_add" aria-label="Specializare" id="Specializare_add"
                                        required>
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
                                <label for="Specializare_add">Specializare</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="date" class="form-control" name="Preluare_mandat_add" placeholder="Preluare mandat"
                                       aria-label="Preluare mandat" id="Preluare_mandat_add" required>
                                <label for="Preluare_mandat_add">Preluare mandat</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="date" class="form-control" name="Expirare_mandat_add" placeholder="Expirare mandat"
                                       aria-label="Expirare mandat" id="Expirare_mandat_add" required>
                                <label for="Expirare_mandat_add">Expirare mandat</label>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="addJudecator">Adaugă</button>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Proces Add Modal -->
<div class="modal fade" id="procese_add_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="procese_add_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="procese_add_modal_label">Adaugă un proces nou</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Procese" method="POST">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Numar_add" placeholder="Număr" aria-label="Număr" id="Numar_add"
                                       maxlength="50" pattern="\d{1,5}\/\d{1,2}\/\d{4}" required>
                                <label for="Numar_add">Număr</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <textarea type="text" class="form-control" name="Obiect_add" placeholder="Obiect" aria-label="Obiect" id="Obiect_add"
                                          maxlength="100" required></textarea>
                                <label for="Obiect_add">Obiect</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Materie_juridica_add" placeholder="Materie juridică"
                                       aria-label="Materie juridică" id="Materie_juridica_add" maxlength="50" pattern="[A-Z]{1}.*" required>
                                <label for="Materie_juridica_add">Materie juridică</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="Stadiu_procesual_add" aria-label="Stadiu procesual"
                                        id="Stadiu_procesual_add" required>
                                    <option value="Apel">Apel</option>
                                    <option value="Fond">Fond</option>
                                    <option value="Recurs">Recurs</option>
                                    <option value="Revizuire">Revizuire</option>
                                    <option value="Contestație">Contestație</option>
                                </select>
                                <label for="Stadiu_procesual_add">Stadiu procesual</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <textarea type="text" class="form-control" name="Reclamant_add" placeholder="Reclamant"
                                          aria-label="Reclamant" id="Reclamant_add" maxlength="100" required></textarea>
                                <label for="Reclamant_add">Reclamant</label>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <textarea type="text" class="form-control" name="Parat_add" placeholder="Pârât"
                                          aria-label="Pârât" id="Parat_add" maxlength="100" required></textarea>
                                <label for="Parat_add">Pârât</label>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="addProces">Adaugă</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Programări Add Modal -->
<div class="modal fade" id="programari_add_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="programari_add_modal_label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="programari_add_modal_label">Adaugă o programare nouă</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form autocomplete="on" action="Programari" method="POST">
                <div class="modal-body">

                    <div class="row g-3">
                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="ID_Proces_add" aria-label="Proces" id="ID_Proces_add"
                                        required>
                                    <c:forEach var="proces" items="${procesList}">
                                        <option value="${proces.ID_PROCES}">${proces.NUMAR}</option>
                                    </c:forEach>
                                </select>
                                <label for="ID_Proces_add">Proces</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <select type="text" class="form-control" name="ID_Judecator_add" aria-label="Judecător" id="ID_Judecator_add"
                                        required>
                                    <c:forEach var="judecator" items="${judecatorList}">
                                        <option value="${judecator.ID_JUDECATOR}">${judecator.PRENUME} ${judecator.NUME} (${judecator.CNP})</option>
                                    </c:forEach>
                                </select>
                                <label for="ID_Judecator_add">Judecător</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Oras_add" placeholder="Oraș" aria-label="Oraș" id="Oras_add"
                                       maxlength="20" pattern="[A-Z]{1}.*" required>
                                <label for="Oras_add">Oraș</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Locatie_add" placeholder="Locație" aria-label="Locație" id="Locatie_add"
                                       maxlength="50" pattern="[A-Z]{1}.*" required>
                                <label for="Locatie_add">Locație</label>
                            </div>
                        </div>

                        <div class="col-12">
                            <div class="form-floating">
                                <input type="text" class="form-control" name="Sala_add" placeholder="Sala" aria-label="Sala" id="Sala_add"
                                       maxlength="10" pattern="\d+[A-Z]*" required>
                                <label for="Sala_add">Sala</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="date" class="form-control" name="Data_add" placeholder="Data" aria-label="Data" id="Data_add" required>
                                <label for="Data_add">Data</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="time" class="form-control" name="Ora_add" placeholder="Ora" aria-label="Ora" id="Ora_add" required>
                                <label for="Ora_add">Ora</label>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Închide</button>
                    <button type="submit" class="btn btn-primary" name="addProgramare">Adaugă</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>

</html>
