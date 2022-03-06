package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;

import java.util.ArrayList;

public interface ClientDAO extends NameDbDAO {

    public ArrayList<Client> findAll(String... ordre) throws Exception;

    public ArrayList<Client> findBy(String colonne,Object value, String... ordre ) throws Exception;


    public void add(String cli_nom,
                    String cli_prenom,
                    String cli_adr,
                    String cli_comp,
                    int cli_cp,
                    String cli_ville,
                    String tel) throws Exception;

    public void delete(int cli_code)throws Exception;

    public void update(int cli_code,
                       String cli_nom,
                       String cli_prenom,
                       String cli_adr,
                       String cli_comp,
                       int cli_cp,
                       String cli_ville,
                       String tel) throws Exception;


}
