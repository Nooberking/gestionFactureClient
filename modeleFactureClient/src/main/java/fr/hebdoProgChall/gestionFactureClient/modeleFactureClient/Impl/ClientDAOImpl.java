package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Connexion;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAOImpl implements ClientDAO  {




    public ArrayList<Client> findAll(String... ordre) throws Exception {
        Connexion connexion = new Connexion();

        ArrayList<Client> allClients = new ArrayList<>();

        Connection conn = connexion.on();

        Statement stmt = conn.createStatement();

       String sql = "SELECT * FROM client";

       if (ordre.length > 0 ) sql += " ORDER BY " + ordre[0] ;
       if (ordre.length == 2 ) sql += " " + ordre[1];

        ResultSet rs = stmt.executeQuery(sql);

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


    public ArrayList<Client> findBy(String Colonne, Object value, String... ordre) throws Exception {
        Connexion connexion = new Connexion();
        ArrayList<Client> allClients =new ArrayList<Client>();
        Connection conn = connexion.on();
        String sql = "SELECT * FROM client WHERE " + Colonne+ " = ? ";

        if (ordre.length > 0 ) sql += " ORDER BY " + ordre[0] ;
        if (ordre.length == 2 ) sql += " " + ordre[1];
        PreparedStatement stmt = conn.prepareStatement(sql);
        if (value instanceof Integer)  stmt.setInt(1,(int)value);
        if (value instanceof String) stmt.setString(1,(String)value);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            allClients.add( new Client(
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

        return allClients ;

    }


}
