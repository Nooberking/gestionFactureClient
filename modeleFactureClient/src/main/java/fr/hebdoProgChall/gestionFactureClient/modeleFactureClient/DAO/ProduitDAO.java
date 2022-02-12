package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;


import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Produit;

import java.util.ArrayList;

public interface ProduitDAO {
    public ArrayList<Produit> findAll(String... ordre) throws Exception;

    public  ArrayList<Produit> findBy(String colonne, Object value, String... ordre)throws Exception;

    public void add (
            String pro_lib,
            String pro_cat,
            double pro_prix) throws Exception;

    public void delete(int pro_code) throws Exception;

    public void update(
            int pro_code,
            String pro_lib,
            String pro_cat,
            double pro_prix
    )throws Exception;

}
