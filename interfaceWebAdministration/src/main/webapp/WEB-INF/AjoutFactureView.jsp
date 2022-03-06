<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 06/03/2022
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <form method="post" action="Ajout">

                                    <div class="form-floating form-group mb-3">
                                        <select class="form-select" id="selectClient"  name="selectClient"  required>
                                            <option >Client 1</option>
                                            <option >Client 2</option>
                                            <option >Client 3</option>
                                            <option >Client 4</option>
                                            <option >Client 5</option>
                                        </select>
                                        <label for="selectClient">Client</label>
                                    </div>
                                    <div>
                                        <table class="table table-bordered table-striped">
                                            <thead>
                                            <tr>
                                                <th>Produit</th>
                                                <th>Prix Unitaire</th>
                                                <th>Quantité</th>
                                                <th>Prix total</th>
                                                <th>Suprimer</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <th>
                                                        <select class="form-select" id="produit1"  name="produit1"  required>
                                                            <option >Produit 1</option>
                                                            <option >Produit 2</option>
                                                        </select>
                                                        </th>
                                                    <td> 5.00 €</td>
                                                    <td>
                                                        <input class="form-control" id="inputQ1" type="number" min="1"  name="inputQ1"  required/>
                                                    </td>
                                                    <td>20.00 €</td>
                                                    <td>
                                                        <input class="btn bg-danger text-white" type="submit" value="Supprimer"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>
                                                        <select class="form-select" id="produit2"  name="produit2"  required>
                                                            <option >Produit 1</option>
                                                            <option >Produit 2</option>
                                                        </select>
                                                    </th>
                                                    <td> 1.00 €</td>
                                                    <td>
                                                        <input class="form-control" id="inputQ2" type="number" min="1" name="inputQ2"  required/>
                                                    </td>
                                                    <td>2.00 €</td>
                                                    <td>
                                                        <input class="btn bg-danger text-white" type="submit" value="Supprimer"/>
                                                    </td>
                                                </tr>

                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th><input class="btn bg-success text-white" type="submit" value="Nouvelle ligne"/></th>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <div class="col-lg-3">
                                        <table class="table table-bordered">
                                            <tbody>
                                            <tr>
                                                <th>Total HT</th>
                                                <td>1</td>
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
                                                <td>3</td>
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
<script src="../resources/js/scripts.js"></script>
</body>
</html>