package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import credencial.CredenciaisCll;
import model.MaoDeObra;
import oracle.jdbc.pool.OracleDataSource;

public class MaoDeObraDAO {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public MaoDeObraDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(CredenciaisCll.user);
        ods.setPassword(CredenciaisCll.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    // Inserir
    public boolean inserir(MaoDeObra maoDeObra) {
        String sql = "INSERT INTO TB_MAO_DE_OBRA_JV_NEW (ID_MAO_DE_OBRA, TIPO_SERVICO, PRECO_SERVICO) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maoDeObra.getIdMaoDeObra());
            ps.setString(2, maoDeObra.getTipoServico());
            ps.setString(3, maoDeObra.getPrecoServico());
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
    public boolean excluir(int idMaoDeObra) {
        String sql = "DELETE FROM TB_MAO_DE_OBRA_JV_NEW WHERE ID_MAO_DE_OBRA = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idMaoDeObra);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover o serviço");
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
    public boolean atualizar(MaoDeObra maoDeObra) {
        String sql = "UPDATE TB_MAO_DE_OBRA_JV_NEW SET TIPO_SERVICO = ?, PRECO_SERVICO = ? WHERE ID_MAO_DE_OBRA = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maoDeObra.getTipoServico());
            ps.setString(2, maoDeObra.getPrecoServico());
            ps.setInt(3, maoDeObra.getIdMaoDeObra());
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
    public List<MaoDeObra> listar() {
        List<MaoDeObra> maoDeObras = new ArrayList<>();
        String sql = "SELECT * FROM TB_MAO_DE_OBRA_JV_NEW";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idMaoDeObra = rs.getInt("ID_MAO_DE_OBRA");
                String tipoServico = rs.getString("TIPO_SERVICO");
                String precoServico = rs.getString("PRECO_SERVICO");

                maoDeObras.add(new MaoDeObra(idMaoDeObra, tipoServico, precoServico));
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
        return maoDeObras;
    }
}
