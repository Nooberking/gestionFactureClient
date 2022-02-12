package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.LigneDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Connexion;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Ligne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LigneDAOImpl implements LigneDAO {

    public ArrayList<Ligne> findAll(String... ordre) throws Exception {
        Connexion connexion = new Connexion();

        ArrayList<Ligne> allLignes = new ArrayList<>();

        Connection conn = connexion.on();

        Statement stmt = conn.createStatement();

        String sql = "SELECT * FROM ligne";

        if (ordre.length > 0 ) sql += " ORDER BY " + ordre[0] ;
        if (ordre.length == 2 ) sql += " " + ordre[1];

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            allLignes.add(new Ligne(
                    rs.getInt("ID_FACT"),
                    rs.getInt("LIG_FACT"),
                    rs.getInt("LIG_PROD"),
                    rs.getInt("LIG_QTE")
            ));

        }
        rs.close();stmt.close();conn.close();

        return allLignes;
    }

    public ArrayList<Ligne> findBy(String colonne, Object value, String... ordre) throws Exception {
        Connexion connexion = new Connexion();
        ArrayList<Ligne> allLignes =new ArrayList<>();
        Connection conn = connexion.on();
        String sql = "SELECT * FROM ligne WHERE " + colonne + " = ? ";

        if (ordre.length > 0 ) sql += " ORDER BY " + ordre[0] ;
        if (ordre.length == 2 ) sql += " " + ordre[1];
        PreparedStatement stmt = conn.prepareStatement(sql);
        if (value instanceof Integer)  stmt.setInt(1,(int)value);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            allLignes.add( new Ligne(
                    rs.getInt("ID_FACT"),
                    rs.getInt("LIG_FACT"),
                    rs.getInt("LIG_PROD"),
                    rs.getInt("LIG_QTE")
            ));
        }
        rs.close();stmt.close();conn.close();

        return allLignes ;
    }

    public void add(int id_fact, int lig_fact, int lig_prod, int lig_qte) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "INSERT INTO ligne "
                + "VALUES (?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id_fact);
        stmt.setInt(2, lig_fact);
        stmt.setInt(3,lig_prod);
        stmt.setInt(4,lig_qte);
        stmt.executeUpdate();
        stmt.close();conn.close();
    }

    public void delete(int id_fact, int lig_fact) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "DELETE FROM ligne WHERE ID_FACT = ? AND LIG_FACT = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id_fact);
        stmt.setInt(2,lig_fact);

        int success = stmt.executeUpdate();
        stmt.close();conn.close();

    }

    public void update(int id_fact, int lig_fact, int lig_prod, int lig_qte) throws Exception {
        Connexion connexion = new Connexion();
        Connection conn = connexion.on();
        String sql = "UPDATE ligne " +
                "SET LIG_PROD = ?, " +
                "LIG_QTE = ? " +
                "WHERE ID_FACT = ? AND LIG_FACT = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,lig_prod);
        stmt.setInt(2,lig_qte);
        stmt.setInt(3,id_fact);
        stmt.setInt(4,lig_fact);
        int success = stmt.executeUpdate();
        stmt.close();conn.close();

    }
}
