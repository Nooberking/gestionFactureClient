package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Ligne;

import java.util.ArrayList;

public interface LigneDAO {
    public ArrayList<Ligne> findAll() throws Exception;



}
