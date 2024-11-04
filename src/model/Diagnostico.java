package model;

public class Diagnostico {
    private int idDiagnostico;
    private String descricaoDiagnostico;
    private String categoriaDiagnostico;
    private double orcamentoDiagnostico;
    private int idProblema;
    private int idPeca;
    private int idMaoDeObra;

    // Construtor
    public Diagnostico(int idDiagnostico, String descricaoDiagnostico, String categoriaDiagnostico, 
                       double orcamentoDiagnostico, int idProblema, int idPeca, int idMaoDeObra) {
        this.idDiagnostico = idDiagnostico;
        this.descricaoDiagnostico = descricaoDiagnostico;
        this.categoriaDiagnostico = categoriaDiagnostico;
        this.orcamentoDiagnostico = orcamentoDiagnostico;
        this.idProblema = idProblema;
        this.idPeca = idPeca;
        this.idMaoDeObra = idMaoDeObra;
    }

    // Getters e Setters
    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescricaoDiagnostico() {
        return descricaoDiagnostico;
    }

    public void setDescricaoDiagnostico(String descricaoDiagnostico) {
        this.descricaoDiagnostico = descricaoDiagnostico;
    }

    public String getCategoriaDiagnostico() {
        return categoriaDiagnostico;
    }

    public void setCategoriaDiagnostico(String categoriaDiagnostico) {
        this.categoriaDiagnostico = categoriaDiagnostico;
    }

    public double getOrcamentoDiagnostico() {
        return orcamentoDiagnostico;
    }

    public void setOrcamentoDiagnostico(double orcamentoDiagnostico) {
        this.orcamentoDiagnostico = orcamentoDiagnostico;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getIdMaoDeObra() {
        return idMaoDeObra;
    }

    public void setIdMaoDeObra(int idMaoDeObra) {
        this.idMaoDeObra = idMaoDeObra;
    }
    
    public double calcularOrcamentoTotal(double custoPecas, double custoMaoDeObra) {
        return this.orcamentoDiagnostico + custoPecas + custoMaoDeObra;
    }

    @Override
    public String toString() {
        return "Diagnostico [id=" + idDiagnostico + ", descricao=" + descricaoDiagnostico +
               ", categoria=" + categoriaDiagnostico + ", orcamento=" + orcamentoDiagnostico +
               ", idProblema=" + idProblema + ", idPeca=" + idPeca + ", idMaoDeObra=" + idMaoDeObra + "]";
    }
}