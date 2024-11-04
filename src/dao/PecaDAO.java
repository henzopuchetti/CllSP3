package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import credencial.CredenciaisCll;
import model.Peca;
import oracle.jdbc.pool.OracleDataSource;

public class PecaDAO {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public PecaDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(CredenciaisCll.user);
        ods.setPassword(CredenciaisCll.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    // Inserir
    public boolean inserir(Peca peca) {
        String sql = "INSERT INTO TB_PECA_JV_NEW (ID_PECA, NOME_PECA, PRECO_PECA) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, peca.getIdPeca());
            ps.setString(2, peca.getNomePeca());
            ps.setDouble(3, peca.getPrecoPeca());
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
    public boolean excluir(int idPeca) {
        String sql = "DELETE FROM TB_PECA_JV_NEW WHERE ID_PECA = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPeca);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover a peça");
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
    public boolean atualizar(Peca peca) {
        String sql = "UPDATE TB_PECA_JV_NEW SET NOME_PECA = ?, PRECO_PECA = ? WHERE ID_PECA = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, peca.getNomePeca());
            ps.setDouble(2, peca.getPrecoPeca());
            ps.setInt(3, peca.getIdPeca());
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
    public List<Peca> listar() {
        List<Peca> pecas = new ArrayList<>();
        String sql = "SELECT * FROM TB_PECA_JV_NEW";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPeca = rs.getInt("ID_PECA");
                String nomePeca = rs.getString("NOME_PECA");
                double precoPeca = rs.getDouble("PRECO_PECA");

                pecas.add(new Peca(idPeca, nomePeca, precoPeca));
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
        return pecas;
    }
}
