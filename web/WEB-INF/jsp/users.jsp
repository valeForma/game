<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carmine.emanuelevigi
  Date: 26/02/2019
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina Utente</title>
</head>
<body>
<h1>Inserisci utente</h1>

<div class="panel-body">
    <form:form action="add" cssClass="form-horizontal"
               method="post" modelAttribute="utente">

        <%--<label for="cognome" class="col-md-4 control-label">cognome</label>--%>
        <%--<div class="col-md-9">--%>
        <%--<form:input path="cognome"/>--%>
        <%--</div>--%>

        <div class="form-group">
            <label for="nome" class="col-md-4 control-label">Name</label>
            <div class="col-md-9">
                <form:input path="nome"/>
            </div>
        </div>
        <div class="form-group">
            <label for="sesso" class="col-md-4 control-label">sex</label>
            <div class="col-md-9">
                <form:input path="sesso"/>
            </div>
        </div>
        <div class="form-group">
            <!-- Button -->
            <div class="col-md-offset-3 col-md-9">
                <form:button cssClass="btn btn-primary">Submit</form:button>
            </div>
        </div>

    </form:form>
</div>


<h1>Pagina vedi utente</h1>
<form:form action="showUser/${nickUtente}" cssClass="form-horizontal"
           method="get" modelAttribute="utente">
<div class="form-group">
    <label for="nickUtente" class="col-md-4 control-label">Nickname</label>
    <div class="col-md-9">
        <form:input path="nickUtente"/>
    </div>
</div>
<div class="form-group">
    <!-- Button -->
    <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
    </div>
    </form:form>
</body>
</html>
