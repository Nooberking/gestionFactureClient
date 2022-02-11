package fr.hebdoProgChall.gestionFactureClient.interfaceWebAdministration.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.*;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.*;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.*;

@WebServlet("/Clients")
public class ClientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> allClients = null;
        ClientDAO clientAccess = new ClientDAOImpl();

        try {
            allClients = clientAccess.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("allClients",allClients);
        this.getServletContext().getRequestDispatcher("/WEB-INF/View.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
