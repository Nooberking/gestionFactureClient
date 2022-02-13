package fr.hebdoProgChall.gestionFactureClient.interfaceWebAdministration.controller;



import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ProduitDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.ProduitDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Produits/Ajout")
public class AjoutProduitController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutProduitController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/AjoutProduitView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProduitDAO produitAccess = new ProduitDAOImpl();

        try{
            produitAccess.add(
                    req.getParameter("inputLib")== null?"" :(String)req.getParameter("inputLib"),
                    req.getParameter("inputCat")== null?"" :(String)req.getParameter("inputCat"),
                    req.getParameter("inputPrix")== null? 0 : Double.parseDouble(req.getParameter("inputPrix"))


            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/Produits");
    }
}
