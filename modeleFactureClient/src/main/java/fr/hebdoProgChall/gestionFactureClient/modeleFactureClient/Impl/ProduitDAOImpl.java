package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ProduitDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Connexion;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProduitDAOImpl implements ProduitDAO {


    public ArrayList<Produit> findAll(String... ordre) throws Exception {
        Connexion connexion = new Connexion();

        ArrayList<Produit> allProduits = new ArrayList<>();

        Connection conn = connexion.on();

        Statement stmt = conn.createStatement();

        String sql = "SELECT * FROM produit";

        if (ordre.length > 0) sql += " ORDER BY " + ordre[0];
        if (ordre.length == 2) sql += " " + ordre[1];

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            allProduits.add(new Produit(
                    rs.getInt("PRO_CODE"),
                    rs.getString("PRO_LIB"),
                    rs.getString("PRO_CAT"),
                    rs.getDouble("PRO_PRIX")
            ));

        }
        rs.close();
        stmt.close();
        conn.close();

        return allProduits;
    }


    public ArrayList<Produit> findBy(String colonne, Object value, String... ordre) throws Exception {
        Connexion connexion = new Connexion();
        ArrayList<Produit> allProduits =new ArrayList<>();
        Connection conn = connexion.on();
        String sql = "SELECT * FROM produit WHERE " + colonne + " = ? ";

        if (ordre.length > 0 ) sql += " ORDER BY " + ordre[0] ;
        if (ordre.length == 2 ) sql += " " + ordre[1];
        PreparedStatement stmt = conn.prepareStatement(sql);
        if (value instanceof Integer)  stmt.setInt(1,(int)value);
        if (value instanceof String) stmt.setString(1,(String)value);
        if (value instanceof Double) stmt.setDouble(1,(Double)value);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            allProduits.add( new Produit(
                    rs.getInt("PRO_CODE"),
                    rs.getString("PRO_LIB"),
                    rs.getString("PRO_CAT"),
                    rs.getDouble("PRO_PRIX")
            ));
        }
        rs.close();stmt.close();conn.close();

        return allProduits ;
    }


    public void add(String pro_lib, String pro_cat, double pro_prix) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "INSERT INTO produit (PRO_LIB, PRO_CAT, PRO_PRIX)"
                + "VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,pro_lib);
        stmt.setString(2,pro_cat);
        stmt.setDouble(3,pro_prix);
        stmt.executeUpdate();
        stmt.close();conn.close();

    }


    public void delete(int pro_code) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "DELETE FROM produit WHERE PRO_CODE = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,pro_code);

        int success = stmt.executeUpdate();
        stmt.close();conn.close();
    }


    public void update(int pro_code, String pro_lib, String pro_cat, double pro_prix) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "UPDATE produit " +
                "SET PRO_LIB = ?, " +
                "PRO_CAT = ?, " +
                "PRO_PRIX = ? " +
                "WHERE PRO_CODE = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,pro_lib);
        stmt.setString(2,pro_cat);
        stmt.setDouble(3,pro_prix);
        stmt.setInt(4,pro_code);

        stmt.close();conn.close();

    }
}
