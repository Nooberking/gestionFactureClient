package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;

public class Client {
    private int cli_code;
    private String cli_nom;
    private String cli_prenom;
    private String cli_adr;
    private String cli_comp;
    private int cli_cp;
    private String cli_ville;
    private String tel;

    public Client(int cli_code, String cli_nom, String cli_prenom, String cli_adr, String cli_comp, int cli_cp, String cli_ville, String tel) {
        this.cli_code = cli_code;
        this.cli_nom = cli_nom;
        this.cli_prenom = cli_prenom;
        this.cli_adr = cli_adr;
        this.cli_comp = cli_comp;
        this.cli_cp = cli_cp;
        this.cli_ville = cli_ville;
        this.tel = tel;
    }

    public int getCli_code() {
        return cli_code;
    }

    public void setCli_code(int cli_code) {
        this.cli_code = cli_code;
    }

    public String getCli_nom() {
        return cli_nom;
    }

    public void setCli_nom(String cli_nom) {
        this.cli_nom = cli_nom;
    }

    public String getCli_prenom() {
        return cli_prenom;
    }

    public void setCli_prenom(String cli_prenom) {
        this.cli_prenom = cli_prenom;
    }

    public String getCli_adr() {
        return cli_adr;
    }

    public void setCli_adr(String cli_adr) {
        this.cli_adr = cli_adr;
    }

    public String getCli_comp() {
        return cli_comp;
    }

    public void setCli_comp(String cli_comp) {
        this.cli_comp = cli_comp;
    }

    public int getCli_cp() {
        return cli_cp;
    }

    public void setCli_cp(int cli_cp) {
        this.cli_cp = cli_cp;
    }

    public String getCli_ville() {
        return cli_ville;
    }

    public void setCli_ville(String cli_ville) {
        this.cli_ville = cli_ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
