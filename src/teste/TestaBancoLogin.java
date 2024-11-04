package teste;

import java.sql.SQLException;
import java.util.List;

import dao.LoginDAO;
import model.Login;

public class TestaBancoLogin {

    public static void main(String[] args) throws SQLException {
        
        LoginDAO gc = new LoginDAO();
 
        // Criando um novo objeto Login com um e-mail válido
        Login loginValido = new Login(1, "henzo@gmail.com", "senha123");
        // Testando a inserção de um login válido
        System.out.println(gc.inserir(loginValido) ? "Login cadastrado com sucesso!" : "Login NÃO adicionado!");
        
        // Tentando inserir um login com e-mail inválido
        //Login loginInvalido = new Login(2, "henzo.com", "senha123");
        //System.out.println(gc.inserir(loginInvalido) ? "Login cadastrado com sucesso!" : "Login NÃO adicionado!");

        // Atualizando o login com um e-mail válido
        //loginValido.setUsuarioSenha("novaSenha123");
        //System.out.println(gc.atualizar(loginValido) ? "Login atualizado com sucesso!" : "Login NÃO atualizado!");

        // Tentando atualizar um login com e-mail inválido
        //loginValido.setUsuarioEmail("henzo.com");
        //System.out.println(gc.atualizar(loginValido) ? "Login atualizado com sucesso!" : "Login NÃO atualizado!");

        // Listar logins
        //List<Login> logins = gc.listar();
        //logins.forEach(l -> System.out.println(l.getIdLogin() + " - " + l.getUsuarioEmail() + " - " + l.getUsuarioSenha()));
        
        // Excluir um login
        //System.out.println(gc.excluir(1) ? "Login excluído com sucesso!" : "Login NÃO removido");
    }
}
