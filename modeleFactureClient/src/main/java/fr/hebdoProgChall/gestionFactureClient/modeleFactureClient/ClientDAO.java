package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;

import java.util.ArrayList;

public interface ClientDAO {

    public ArrayList<Client> findAll() throws Exception;
}
