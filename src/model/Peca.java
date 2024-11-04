package model;

public class Peca {
    private int idPeca;
    private String nomePeca;
    private double precoPeca; // Usando double para representar valores monetários

    // Construtor
    public Peca(int idPeca, String nomePeca, double precoPeca) {
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.precoPeca = precoPeca;
    }

    // Getters e Setters
    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public double getPrecoPeca() {
        return precoPeca;
    }

    public void setPrecoPeca(double precoPeca) {
        this.precoPeca = precoPeca;
    }

    @Override
    public String toString() {
        return "Peca [id=" + idPeca + ", nome=" + nomePeca + ", preco=" + precoPeca + "]";
    }
}