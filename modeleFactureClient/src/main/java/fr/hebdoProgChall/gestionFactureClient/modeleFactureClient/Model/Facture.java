package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

import java.sql.Date;

public class Facture {
    private int id;
    private int id_cli;
    private double tva;
    private String loc_pdf;
    private Date date_creation;

    public Facture(int id, int id_cli, double tva, String loc_pdf, Date date_creation) {
        this.id = id;
        this.id_cli = id_cli;
        this.tva = tva;
        this.loc_pdf = loc_pdf;
        this.date_creation = date_creation;
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

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public String getLoc_pdf() {
        return loc_pdf;
    }

    public void setLoc_pdf(String loc_pdf) {
        this.loc_pdf = loc_pdf;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }
}
