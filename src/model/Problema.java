package model;

public class Problema {
    private int idProblema;
    private String descricaoProblema;
    private String categoriaProblema;
    private int idVeiculo; // Correspondente ao campo id_veiculo2

    // Construtor
    public Problema(int idProblema, String descricaoProblema, String categoriaProblema, int idVeiculo) {
        this.idProblema = idProblema;
        this.descricaoProblema = descricaoProblema;
        this.categoriaProblema = categoriaProblema;
        this.idVeiculo = idVeiculo;
    }

    // Getters e Setters
    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getCategoriaProblema() {
        return categoriaProblema;
    }

    public void setCategoriaProblema(String categoriaProblema) {
        this.categoriaProblema = categoriaProblema;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public String toString() {
        return "Problema [id=" + idProblema + ", descricao=" + descricaoProblema + ", categoria=" + categoriaProblema + ", idVeiculo=" + idVeiculo + "]";
    }
}
