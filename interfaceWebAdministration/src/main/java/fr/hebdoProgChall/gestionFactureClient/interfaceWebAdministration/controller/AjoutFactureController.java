package fr.hebdoProgChall.gestionFactureClient.interfaceWebAdministration.controller;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ProduitDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.ClientDAOImpl;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.ProduitDAOImpl;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Produit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AjoutFactureController", value = "/Factures/Generer")
public class AjoutFactureController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> allClients = null;
        List<Produit> allProduits = null;
        ClientDAO clientAccess = new ClientDAOImpl();
        ProduitDAO produitAccess = new ProduitDAOImpl();


        try {
            allClients = clientAccess.findAll();
            allProduits = produitAccess.findAll();

        } catch (Exception e){
            e.printStackTrace();

        }
        request.setAttribute("allClients",allClients);
        request.setAttribute("allProduits",allProduits);
        this.getServletContext().getRequestDispatcher("/WEB-INF/AjoutFactureView.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
