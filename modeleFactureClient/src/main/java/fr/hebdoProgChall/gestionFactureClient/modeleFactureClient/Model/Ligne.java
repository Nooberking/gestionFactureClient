package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

public class Ligne {
    private int id_fact;
    private int lig_fact;
    private int lig_prod;
    private int lig_qte;

    public Ligne(int id_fact, int lig_fact, int lig_prod, int lig_qte) {
        this.id_fact = id_fact;
        this.lig_fact = lig_fact;
        this.lig_prod = lig_prod;
        this.lig_qte = lig_qte;
    }

    public int getId_fact() {
        return id_fact;
    }

    public void setId_fact(int id_fact) {
        this.id_fact = id_fact;
    }

    public int getLig_fact() {
        return lig_fact;
    }

    public void setLig_fact(int lig_fact) {
        this.lig_fact = lig_fact;
    }

    public int getLig_prod() {
        return lig_prod;
    }

    public void setLig_prod(int lig_prod) {
        this.lig_prod = lig_prod;
    }

    public int getLig_qte() {
        return lig_qte;
    }

    public void setLig_qte(int lig_qte) {
        this.lig_qte = lig_qte;
    }
}
