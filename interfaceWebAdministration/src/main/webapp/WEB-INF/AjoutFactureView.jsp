<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 06/03/2022
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Génération d'une nouvelle facture</title>
    <link href="../ressources/style/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="bg-secondary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-15">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Générer une nouvelle facture</h3></div>
                            <div class="card-body">
                                <form method="post" action="Generer">

                                    <div class="form-floating form-group mb-3">
                                        <select class="form-select" id="selectClient"  name="selectClient"  required>
                                            <c:forEach var="client" items="${allClients}">

                                            <option value="${client.getCli_code()}">${client.getCli_nom()} ${client.getCli_prenom()}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="selectClient">Client</label>
                                    </div>
                                    <div>
                                        <table class="table table-bordered table-striped" >
                                            <thead>
                                            <tr>
                                                <th>Produit</th>
                                                <th>Prix Unitaire</th>
                                                <th>Quantité</th>
                                                <th>Prix total</th>
                                                <th>Suprimer</th>
                                            </tr>
                                            </thead>
                                            <tbody id= "gestionLine">
                                                <tr id="ligne0">
                                                    <th >

                                                        <select class="form-select" id="produit0" onchange="UpdatePrixUnitaire('produit0')"  required>
                                                           <c:forEach var="produit" items="${allProduits}">

                                                               <option id="${produit.getPro_prix()}" value="${produit.getPro_code()}">${produit.getPro_lib()}

                                                               </option>

                                                           </c:forEach>
                                                        </select>
                                                    </th>
                                                    <td id="PU" ></td>
                                                    <td>
                                                        <input class="form-control" id="inputQ0" type="number" min="1" onchange="UpdatePrixSoustotal('produit0')"   />
                                                    </td>
                                                    <td></td>
                                                    <td>
                                                        <input class="btn bg-danger text-white" type="button" id = "0" onclick="supprLine(0)" value = "Supprimer"/>
                                                    </td>
                                                </tr>
                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th>
                                                    <input type="button" class="btn bg-success text-white" onclick="copyLine()"  id="btnAddLine" value="Nouvelle ligne"/>
                                                </th>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <div class="col-lg-3">
                                        <table class="table table-bordered">
                                            <tbody>
                                            <tr>
                                                <th>Total HT</th>
                                                <td id="totalHT"></td>
                                            </tr>
                                            <tr>
                                                <th>TVA</th>
                                                <td>
                                                    <select class="form-select" id="TVA"  name="TVA"  required>
                                                        <option>/</option>
                                                        <option>5.5%</option>
                                                        <option>10%</option>
                                                        <option>20%</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>Total TTC</th>
                                                <td id="totalTTC"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <button class="btn btn-primary btn-block" type="submit">Générer la facture</button>
                                        </div>
                                    </div>

                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <div id="layoutAuthentication_footer">
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
<script src="../ressources/js/scripts.js"></script>

</body>
</html>