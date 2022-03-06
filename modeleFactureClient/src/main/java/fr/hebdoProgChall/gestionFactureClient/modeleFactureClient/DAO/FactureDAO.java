package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Facture;

import java.util.ArrayList;

public interface FactureDAO extends NameDbDAO {
    public ArrayList<Facture> findAll(String... ordre) throws Exception;

    public ArrayList<Facture> findBy(String colonne,Object value, String... ordre) throws Exception;

    public void add(
            int id_cli,
            int tva,
            String loc_pdf) throws Exception;

    public void delete(int id)throws Exception;

    public void update(
            int id,
            String loc_pdf) throws Exception;

}
