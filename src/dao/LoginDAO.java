package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import credencial.CredenciaisCll;
import model.Login;
import oracle.jdbc.pool.OracleDataSource;

public class LoginDAO {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public LoginDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(CredenciaisCll.user);
        ods.setPassword(CredenciaisCll.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    // Inserir
    public boolean inserir(Login login) {
        if (!login.validarEmail()) {
            System.err.println("E-mail inválido! O login não foi cadastrado.");
            return false;
        }

        String sql = "INSERT INTO TB_LOGIN_JV_NEW (ID_LOGIN, USUARIO_EMAIL, USUARIO_SENHA) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, login.getIdLogin());
            ps.setString(2, login.getUsuarioEmail());
            ps.setString(3, login.getUsuarioSenha());
            ps.execute();
        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão nula!");
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                System.out.println("Fechando a conexão com o banco de dados!");
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    // Excluir
    public boolean excluir(int idLogin) {
        String sql = "DELETE FROM TB_LOGIN_JV_NEW WHERE ID_LOGIN = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idLogin);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover o login");
            e.printStackTrace();
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Não foi possível encerrar a conexão");
                e.printStackTrace();
            }
        }
        return true;
    }

    // Atualizar
    public boolean atualizar(Login login) {
        if (!login.validarEmail()) {
            System.err.println("E-mail inválido! O login não foi atualizado.");
            return false;
        }

        String sql = "UPDATE TB_LOGIN_JV_NEW SET USUARIO_EMAIL = ?, USUARIO_SENHA = ? WHERE ID_LOGIN = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login.getUsuarioEmail());
            ps.setString(2, login.getUsuarioSenha());
            ps.setInt(3, login.getIdLogin());
            ps.execute();
        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão nula - (método atualizar)");
            } else {
                System.err.println("Erro no Prepared Statement");
            }
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                System.out.println("Fechando conexão");
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    // Listar
    public List<Login> listar() {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT * FROM TB_LOGIN_JV_NEW";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idLogin = rs.getInt("ID_LOGIN");
                String usuarioEmail = rs.getString("USUARIO_EMAIL");
                String usuarioSenha = rs.getString("USUARIO_SENHA");

                logins.add(new Login(idLogin, usuarioEmail, usuarioSenha));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return logins;
    }
}
