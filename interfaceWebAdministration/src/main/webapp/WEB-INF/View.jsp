<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Display names</title>
    </head>
    <body>
        <h1>Clients</h1>
        <ul>
            <c:forEach var="client" items="${allClients}">
                <li>Nom : ${client.cli_nom} || Prénom : ${client.cli_prenom}</li>
            </c:forEach>
        </ul>
    </body>
</html>
