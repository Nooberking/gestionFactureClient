package fr.hebdoProgChall.gestionFactureClient.interfaceWebAdministration.controller;


import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ProduitDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.ProduitDAOImpl;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Produits")
public class ProduitController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produit> allProduits = null;
        ProduitDAO produitAccess = new ProduitDAOImpl();


        try {
            allProduits = produitAccess.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("allProduits",allProduits);
        this.getServletContext().getRequestDispatcher("/WEB-INF/ProduitView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
