package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.FactureDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Connexion;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Facture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class FactureDAOImpl implements FactureDAO {

    public String getDbName() {
        Connexion connexion = new Connexion();
        return connexion.getDbName();
    }

    public ArrayList<Facture> findAll(String... ordre) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        Statement stmt = conn.createStatement();
        ArrayList<Facture> allFactures = new ArrayList<>();

        String sql = "SELECT * FROM facture";

        if (ordre.length > 0) sql += " ORDER BY " + ordre[0] ;
        if (ordre.length == 2) sql += " " + ordre[1];

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            allFactures.add(new Facture(
                    rs.getInt("ID"),
                    rs.getInt("ID_CLI"),
                    rs.getInt("TVA"),
                    rs.getString("LOC_PDF"),
                    rs.getDate("DATE_CREATION")
            ));
        }
        rs.close();stmt.close();conn.close();

        return allFactures;

    }


    public ArrayList<Facture> findBy(String colonne, Object value, String... ordre) throws Exception {
        Connexion connexion = new Connexion();
        ArrayList<Facture> allFactures =new ArrayList<>();
        Connection conn = connexion.on();
        String sql = "SELECT * FROM facture WHERE " + colonne + " = ? ";

        if (ordre.length > 0 ) sql += " ORDER BY " + ordre[0] ;
        if (ordre.length == 2 ) sql += " " + ordre[1];
        PreparedStatement stmt = conn.prepareStatement(sql);
        if (value instanceof Integer)  stmt.setInt(1,(int)value);
        if (value instanceof String) stmt.setString(1,(String)value);
        if (value instanceof Date) stmt.setDate(1, (Date)value);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            allFactures.add( new Facture(
                    rs.getInt("ID"),
                    rs.getInt("ID_CLI"),
                    rs.getInt("TVA"),
                    rs.getString("LOC_PDF"),
                    rs.getDate("DATE_CREATION")
            ));
        }
        rs.close();stmt.close();conn.close();

        return allFactures ;
    }


    public void add(int id_cli, int tva, String loc_pdf) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "INSERT INTO facture (ID_CLI, TVA, LOC_PDF, DATE_CREATION)"
                + "VALUES (?,?,?,NOW())";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id_cli);
        stmt.setInt(2,tva);
        stmt.setString(3,loc_pdf);
        stmt.executeUpdate();
        stmt.close();conn.close();

    }


    public void delete(int id) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "DELETE FROM facture WHERE ID = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        int success = stmt.executeUpdate();
        stmt.close();conn.close();

    }


    public void update(int id, String loc_pdf) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "UPDATE facture " +
                "SET LOC_PDF = ? " +
                "WHERE ID = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,loc_pdf);
        stmt.setInt(2,id);
        
        int success = stmt.executeUpdate();
        stmt.close();conn.close();

    }
}
