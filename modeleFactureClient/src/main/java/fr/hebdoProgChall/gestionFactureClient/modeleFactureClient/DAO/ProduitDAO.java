package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;


import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Produit;

import java.util.ArrayList;

public interface ProduitDAO {
    public ArrayList<Produit> findAll() throws Exception;
}
