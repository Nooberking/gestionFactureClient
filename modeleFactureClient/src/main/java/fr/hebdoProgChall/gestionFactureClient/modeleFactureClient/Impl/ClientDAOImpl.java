package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDAOImpl implements ClientDAO  {



    @Override
    public ArrayList<Client> findAll() throws Exception {
        Connexion connexion = new Connexion();

        ArrayList<Client> allClients = new ArrayList<>();


        Connection conn = connexion.on();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM client");

        while(rs.next()){
            allClients.add(new Client(
                                    rs.getInt("CLI_CODE"),
                                    rs.getString("CLI_NOM"),
                                    rs.getString("CLI_PRENOM"),
                                    rs.getString("CLI_ADR"),
                                    rs.getString("CLI_COMP"),
                                    rs.getInt("CLI_CP"),
                                    rs.getString("CLI_VILLE"),
                                    rs.getString("TEL")
            ));

        }
        rs.close();stmt.close();conn.close();

        return allClients;

    }
}
