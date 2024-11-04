package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import credencial.CredenciaisCll;
import model.Problema;
import oracle.jdbc.pool.OracleDataSource;

public class ProblemaDAO {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public ProblemaDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(CredenciaisCll.user);
        ods.setPassword(CredenciaisCll.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    // Inserir
    public boolean inserir(Problema problema) {
        String sql = "INSERT INTO TB_PROBLEMA_JV_NEW (ID_PROBLEMA, DESCRICAO_PROBLEMA, CATEGORIA_PROBLEMA, ID_VEICULO) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, problema.getIdProblema());
            ps.setString(2, problema.getDescricaoProblema());
            ps.setString(3, problema.getCategoriaProblema());
            ps.setInt(4, problema.getIdVeiculo());
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
    public boolean excluir(int idProblema) {
        String sql = "DELETE FROM TB_PROBLEMA_JV_NEW WHERE ID_PROBLEMA = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProblema);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover o problema");
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
    public boolean atualizar(Problema problema) {
        String sql = "UPDATE TB_PROBLEMA_JV_NEW SET DESCRICAO_PROBLEMA = ?, CATEGORIA_PROBLEMA = ?, ID_VEICULO = ? WHERE ID_PROBLEMA = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, problema.getDescricaoProblema());
            ps.setString(2, problema.getCategoriaProblema());
            ps.setInt(3, problema.getIdVeiculo());
            ps.setInt(4, problema.getIdProblema());
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
    public List<Problema> listar() {
        List<Problema> problemas = new ArrayList<>();
        String sql = "SELECT * FROM TB_PROBLEMA_JV_NEW";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idProblema = rs.getInt("ID_PROBLEMA");
                String descricaoProblema = rs.getString("DESCRICAO_PROBLEMA");
                String categoriaProblema = rs.getString("CATEGORIA_PROBLEMA");
                int idVeiculo = rs.getInt("ID_VEICULO");

                problemas.add(new Problema(idProblema, descricaoProblema, categoriaProblema, idVeiculo));
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
        return problemas;
    }
}