package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Ligne;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Produit;

import java.util.ArrayList;

public interface LigneDAO  {
    public ArrayList<Ligne> findAll(String... ordre) throws Exception;

    public  ArrayList<Ligne> findBy(String colonne, Object value, String... ordre)throws Exception;

    public void add (
            int id_fact,
            int lig_fact,
            int lig_prod,
            int lig_qte) throws Exception;

    public void delete(int id_fact, int lig_fact) throws Exception;

    public void update(
            int id_fact,
            int lig_fact,
            int lig_prod,
            int lig_qte)throws Exception;



}
