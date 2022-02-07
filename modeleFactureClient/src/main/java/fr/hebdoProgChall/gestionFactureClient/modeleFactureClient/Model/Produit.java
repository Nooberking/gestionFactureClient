package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

public class Produit {
    private int pro_code;
    private String pro_lib;
    private String pro_cat;
    private double pro_prix;

    public Produit(int pro_code, String pro_lib, String pro_cat, double pro_prix) {
        this.pro_code = pro_code;
        this.pro_lib = pro_lib;
        this.pro_cat = pro_cat;
        this.pro_prix = pro_prix;
    }

    public int getPro_code() {
        return pro_code;
    }

    public void setPro_code(int pro_code) {
        this.pro_code = pro_code;
    }

    public String getPro_lib() {
        return pro_lib;
    }

    public void setPro_lib(String pro_lib) {
        this.pro_lib = pro_lib;
    }

    public String getPro_cat() {
        return pro_cat;
    }

    public void setPro_cat(String pro_cat) {
        this.pro_cat = pro_cat;
    }

    public double getPro_prix() {
        return pro_prix;
    }

    public void setPro_prix(double pro_prix) {
        this.pro_prix = pro_prix;
    }
}
