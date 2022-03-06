package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.NameDbDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Connexion;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAOImpl implements ClientDAO {


    @Override
    public String getDbName() {
        Connexion connexion = new Connexion();
        return connexion.getDbName();
    }

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

    public void add(String cli_nom,
                    String cli_prenom,
                    String cli_adr,
                    String cli_comp,
                    int cli_cp,
                    String cli_ville,
                    String tel) throws Exception
    {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "INSERT INTO client (CLI_NOM, CLI_PRENOM, CLI_ADR, CLI_COMP, CLI_CP, CLI_VILLE, TEL)"
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,cli_nom);
        stmt.setString(2,cli_prenom);
        stmt.setString(3,cli_adr);
        stmt.setString(4,cli_comp);
        stmt.setInt(5,cli_cp);
        stmt.setString(6,cli_ville);
        stmt.setString(7,tel);
        stmt.executeUpdate();
        stmt.close();conn.close();



    }

    public void delete(int cli_code) throws Exception{
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "DELETE FROM client WHERE CLI_CODE = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,cli_code);

        int success = stmt.executeUpdate();
        stmt.close();conn.close();
    }


    public void update(
            int cli_code,
            String cli_nom,
            String cli_prenom,
            String cli_adr,
            String cli_comp,
            int cli_cp,
            String cli_ville,
            String tel) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "UPDATE client " +
                "SET CLI_NOM = ?, " +
                "CLI_PRENOM = ?, " +
                "CLI_ADR = ?, " +
                "CLI_COMP = ?, " +
                "CLI_CP = ?, " +
                "CLI_VILLE = ?, " +
                "TEL = ? " +
                "WHERE CLI_CODE = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,cli_nom);
        stmt.setString(2,cli_prenom);
        stmt.setString(3,cli_adr);
        stmt.setString(4,cli_comp);
        stmt.setInt(5,cli_cp);
        stmt.setString(6,cli_ville);
        stmt.setString(7,tel);
        stmt.setInt(8,cli_code);
        int success = stmt.executeUpdate();
        stmt.close();conn.close();


    }


}
