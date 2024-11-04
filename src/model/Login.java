package model;

public class Login {
    private int idLogin;
    private String usuarioEmail;
    private String usuarioSenha;

    // Construtor
    public Login(int idLogin, String usuarioEmail, String usuarioSenha) {
        this.idLogin = idLogin;
        this.usuarioEmail = usuarioEmail;
        this.usuarioSenha = usuarioSenha;
    }

    // GETTERS E SETTERS
    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    public boolean validarEmail() {
        return this.usuarioEmail.contains("@") && this.usuarioEmail.contains(".");
    }
    
    @Override
    public String toString() {
        return "Login [idLogin=" + idLogin + ", usuarioEmail=" + usuarioEmail + ", usuarioSenha=" + usuarioSenha + "]";
    }
}
