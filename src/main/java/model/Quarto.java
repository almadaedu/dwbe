package model;

class Quarto {
    private int idQuarto;
    private String localizacao;
    private String status;
    private String caracteristica;
    private int numeroQuarto;

    public Quarto(int idQuarto, String localizacao, String status, String caracteristica, int numeroQuarto) {
        this.idQuarto = idQuarto;
        this.localizacao = localizacao;
        this.status = status;
        this.caracteristica = caracteristica;
        this.numeroQuarto = numeroQuarto;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String TipoQuarto() {
        return "Quarto " + caracteristica;
    }
}

