package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

public class Facture {
    private int id;
    private int id_cli;
    private int tva;
    private String loc_pdf;
    private String date;

    public Facture(int id, int id_cli, int tva, String loc_pdf, String date) {
        this.id = id;
        this.id_cli = id_cli;
        this.tva = tva;
        this.loc_pdf = loc_pdf;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public String getLoc_pdf() {
        return loc_pdf;
    }

    public void setLoc_pdf(String loc_pdf) {
        this.loc_pdf = loc_pdf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
