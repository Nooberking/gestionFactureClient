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
  <title>Ajout Client</title>
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
              <div class="card-header"><h3 class="text-center font-weight-light my-4">Ajout d'un nouveau client</h3></div>
              <div class="card-body">
                <form method="post" action="Ajout">
                  <div class="row mb-3">
                    <div class="col-md-6">
                      <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="inputPrenom"  type="text" name="inputPrenom" placeholder="Entrez votre prénom" required/>
                        <label for="inputPrenom">Prénom</label>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="form-floating">
                        <input class="form-control" id="inputNom" type="text" name="inputNom" placeholder="Entrez votre nom" required/>
                        <label for="inputNom">Nom <c:out value="${paramValues}"></c:out></label>
                      </div>
                    </div>
                  </div>
                  <div class="form-floating mb-3">
                    <input class="form-control" id="inputAdresse" type="text" name="inputAdresse" placeholder="Entrez votre adresse" required/>
                    <label for="inputAdresse">Adresse</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input class="form-control" id="inputCompAdresse" type="text" name="inputCompAdresse" placeholder="Entrez votre Complément d'adresse" />
                    <label for="inputCompAdresse">Complément d'adresse</label>
                  </div>
                  <div class="row mb-3">
                    <div class="col-md-6">
                      <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="inputCP" type="number" name="inputCP" placeholder="Ajoutez votre code postal" required/>
                        <label for="inputCP">Code Postal</label>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="inputVille" type="text" name="inputVille" placeholder="Ajoutez votre Ville" required/>
                        <label for="inputVille">Ville</label>
                      </div>
                    </div>

                  </div>
                  <div class="form-floating mb-3">
                    <input class="form-control" id="inputTel" type="text" name="inputTel" placeholder="Entrez votre Numéro de téléphone"  />
                    <label for="inputTel">Téléphone</label>
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

