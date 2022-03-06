package fr.hebdoProgChall.gestionFactureClient.interfaceWebAdministration.controller;




import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.FactureDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.ClientDAOImpl;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.FactureDAOImpl;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Facture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Factures")
public class FactureController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FactureController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Facture> allFactures = null;
        String dbName ="";

        FactureDAO factureAccess = new FactureDAOImpl();



        try {
            allFactures = factureAccess.findAll();
            dbName = factureAccess.getDbName();

        }catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("allFactures",allFactures);
        req.setAttribute("dbName",dbName);
        this.getServletContext().getRequestDispatcher("/WEB-INF/FactureView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
