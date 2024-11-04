package model;

public class Veiculo {
    private int idVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;

    // Construtor
    public Veiculo(int idVeiculo, String marcaVeiculo, String modeloVeiculo) {
        this.idVeiculo = idVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
    }

    // GETTERS E SETTERS
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }
    
    public boolean validarMarcaModelo() {
        return this.marcaVeiculo.length() > 1 && this.modeloVeiculo.length() > 1;
    }

    @Override
    public String toString() {
        return "Veiculo [idVeiculo=" + idVeiculo + ", marcaVeiculo=" + marcaVeiculo + ", modeloVeiculo=" + modeloVeiculo + "]";
    }
}
