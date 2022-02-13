<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 13/02/2022
  Time: 17:30
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
  <title>Ajout Produit</title>
  <link href="../ressources/style/styles.css" rel="stylesheet" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="bg-secondary">
<div id="layoutAuthentication">
  <div id="layoutAuthentication_content">
    <main>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-7">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
              <div class="card-header"><h3 class="text-center font-weight-light my-4">Ajout d'un nouveau produit</h3></div>
              <div class="card-body">
                <form method="post" action="Ajout">
                  <div class="form-floating mb-3">
                    <input class="form-control" id="inputLib"  type="text" name="inputLib" placeholder="Entrez le nom du produit" required/>
                    <label for="inputLib">Nom du produit</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input class="form-control" id="inputCat" type="text" name="inputCat" placeholder="Entrez la catégorie du produit" required/>
                    <label for="inputCat">Catégorie du produit</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input class="form-control" id="inputPrix" type="text" name="inputPrix" placeholder="Entrez le prix du produit"  required/>
                    <label for="inputPrix">Prix</label>
                  </div>
                  <div class="mt-4 mb-0">
                    <div class="d-grid">
                      <button class="btn btn-primary btn-block" type="submit">Ajouter</button>
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

