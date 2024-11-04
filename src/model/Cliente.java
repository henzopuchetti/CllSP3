package model;

public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private int telefoneCliente;
    private int cepCliente;
    private int idLogin;
    private int idVeiculo;

    // Construtor
    public Cliente(int idCliente, String nomeCliente, int telefoneCliente, int cepCliente, int idLogin, int idVeiculo) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.cepCliente = cepCliente;
        this.idLogin = idLogin;
        this.idVeiculo = idVeiculo;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(int telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public int getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(int cepCliente) {
        this.cepCliente = cepCliente;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
    public boolean validarTelefone() {
        String telefoneStr = String.valueOf(this.telefoneCliente);
        return telefoneStr.length() == 10 || telefoneStr.length() == 11;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + idCliente + ", nome=" + nomeCliente + ", telefone=" + telefoneCliente + ", cep=" + cepCliente + ", idLogin=" + idLogin + ", idVeiculo=" + idVeiculo + "]";
    }
}

