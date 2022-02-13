<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Homepage</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>

        <link href="ressources/style/signin.css" rel="stylesheet">
    </head>
    <body class="text-center">
    <main class="form-signin">
        <form action="Clients">
            <img class="mb-4" src="ressources/logo/HPC_transparent.png" alt="" width="200" height="150">
            <h1 class="h2 mb-3 fw-normal">Gestion facture client</h1>
            <h2 class="h3 mb-3 fw-normal fs-6">Cliquez sur le bouton ci-dessous pour accéder à la plateforme de gestion des
             factures.</h2>


            <button class="w-100 btn btn-lg btn-primary" type="submit">Cliquez ici</button>
            <p class="mt-5 mb-3 text-muted" >&copy; David MANUEL 2022</p>
        </form>
    </main>

    </body>
</html>
