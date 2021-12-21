<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <title>Judecatori</title>
</head>
<body>
<h1>Judecatori</h1>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <form role="form" action="JudecatorController" method="POST">
                    <div class="form-group">
                        <label class="control-label">Vizualizati datele din tabela Judecători</label><br>
                        <input type="submit" class="btn btn-default" name="displayJudecatori" value="Afiseaza">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</table>
</body>
</html>
