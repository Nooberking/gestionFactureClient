<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <meta name="author" content="David MANUEL" />
    <title>Liste Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="ressources/style/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="Clients">Gestion Facture Client</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="!"><i class="fas fa-bars"></i></button>


</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Menu</div>
                    <a class="nav-link" href="Clients">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-address-book"></i></div>
                        Clients
                    </a>
                    <a class="nav-link" href="Produits">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-store"></i></div>
                        Produits
                    </a>
                    <a class="nav-link" href="Factures">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-receipt"></i></div>
                        Factures
                    </a>

                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">BDD Connectée : </div> <c:out value="${dbName}"/>
            </div>
        </nav>
    </div>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Liste des Produits</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">Voici tous les produits présents dans la BDD.</li>
                </ol>
                <div class="row">
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-primary text-white mb-4">
                            <div class="card-body">Ajouter un Produit</div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="Produits/Ajout"><i class="fa-solid fa-user-plus"></i></a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fa-solid fa-list"></i>
                        Produits
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Catégorie</th>
                                <th>Prix</th>

                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nom</th>
                                <th>Catégorie/th>
                                <th>Prix</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="produit" items="${allProduits}">

                            <tr>
                                <td>${produit.getPro_lib()}</td>
                                <td>${produit.getPro_cat()}</td>
                                <td>${produit.getPro_prix()}</td>
                            </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; David MANUEL 2022</div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="ressources/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="ressources/js/datatables-simple-demo.js"></script>


    </body>
</html>
