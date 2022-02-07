package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Facture;

import java.util.ArrayList;

public interface FactureDAO {
    public ArrayList<Facture> findAll() throws Exception;
}
