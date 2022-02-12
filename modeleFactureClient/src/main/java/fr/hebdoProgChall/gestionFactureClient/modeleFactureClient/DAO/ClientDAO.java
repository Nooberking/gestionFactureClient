package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;

import java.util.ArrayList;

public interface ClientDAO {

    public ArrayList<Client> findAll(String... ordre) throws Exception;

    public ArrayList<Client> findBy(String colonne,Object value, String... ordre ) throws Exception;



}
