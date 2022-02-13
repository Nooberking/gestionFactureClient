package fr.hebdoProgChall.gestionFactureClient.interfaceWebAdministration.controller;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.ClientDAOImpl;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/Clients/Ajout")
public class AjoutClientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutClientController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/AjoutClientView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientDAO clientAccess = new ClientDAOImpl();

        try{
            clientAccess.add(
                    req.getParameter("inputNom")== null?"" :(String)req.getParameter("inputNom"),
                    req.getParameter("inputPrenom")== null?"" :(String)req.getParameter("inputPrenom"),
                    req.getParameter("inputAdresse")== null?"" :(String)req.getParameter("inputAdresse"),
                    req.getParameter("inputComAdresse")== null?"" :(String)req.getParameter("inputComAdresse"),
                    req.getParameter("inputCP")== null? 0 : Integer.parseInt(req.getParameter("inputCP")),
                    req.getParameter("inputVille")== null?"" :(String)req.getParameter("inputVille"),
                    req.getParameter("inputTel")== null?"" :(String)req.getParameter("inputTel")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/Clients");
    }
}
