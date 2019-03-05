<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carmine.emanuelevigi
  Date: 26/02/2019
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show User</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <td>Name</td>
                <td>${nome}</td>
            </tr>
            <tr>
                <td>Age</td>
                <td>${cognome}</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>${nickUtente}</td>
            </tr>
        </table>
    </div>

</body>
</html>
