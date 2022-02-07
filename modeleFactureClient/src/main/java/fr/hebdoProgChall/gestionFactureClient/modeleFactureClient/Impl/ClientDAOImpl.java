package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDAOImpl implements ClientDAO  {

    String url = "jdbc:mysql://localhost:3306/hebdochall3";
    String driver = "com.mysql.cj.jdbc.Driver";
    String username = "Challenger";
    String password = "4Jaz643bXXorAFDCFD86R2WtEzqahy";


    @Override
    public ArrayList<Client> findAll() throws Exception {

        ArrayList<Client> allClients = new ArrayList<>();

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, username, password);

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
