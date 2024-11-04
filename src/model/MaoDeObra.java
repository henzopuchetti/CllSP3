package model;

public class MaoDeObra {
    private int idMaoDeObra;
    private String tipoServico;
    private String precoServico; // Usando String para representar o preço, conforme o tipo na tabela

    // Construtor
    public MaoDeObra(int idMaoDeObra, String tipoServico, String precoServico) {
        this.idMaoDeObra = idMaoDeObra;
        this.tipoServico = tipoServico;
        this.precoServico = precoServico;
    }

    // Getters e Setters
    public int getIdMaoDeObra() {
        return idMaoDeObra;
    }

    public void setIdMaoDeObra(int idMaoDeObra) {
        this.idMaoDeObra = idMaoDeObra;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(String precoServico) {
        this.precoServico = precoServico;
    }

    @Override
    public String toString() {
        return "MaoDeObra [id=" + idMaoDeObra + ", tipoServico=" + tipoServico + ", precoServico=" + precoServico + "]";
    }
}
