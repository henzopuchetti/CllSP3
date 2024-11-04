package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import credencial.CredenciaisCll;
import model.Diagnostico;
import oracle.jdbc.pool.OracleDataSource;

public class DiagnosticoDAO {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public DiagnosticoDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(CredenciaisCll.user);
        ods.setPassword(CredenciaisCll.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    // Inserir
    public boolean inserir(Diagnostico diagnostico) {
        String sql = "INSERT INTO TB_DIAGNOSTICO_JV_NEW (ID_DIAGNOSTICO, DESCRICAO_DIAGNOSTICO, CATEGORIA_DIAGNOSTICO, " +
                     "ORCAMENTO_DIAGNOSTICO, ID_PROBLEMA, ID_PECA, ID_MAO_DE_OBRA) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, diagnostico.getIdDiagnostico());
            ps.setString(2, diagnostico.getDescricaoDiagnostico());
            ps.setString(3, diagnostico.getCategoriaDiagnostico());
            ps.setDouble(4, diagnostico.getOrcamentoDiagnostico());
            ps.setInt(5, diagnostico.getIdProblema());
            ps.setInt(6, diagnostico.getIdPeca());
            ps.setInt(7, diagnostico.getIdMaoDeObra());
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
    public boolean excluir(int idDiagnostico) {
        String sql = "DELETE FROM TB_DIAGNOSTICO_JV_NEW WHERE ID_DIAGNOSTICO = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDiagnostico);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover o diagnóstico");
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
    public boolean atualizar(Diagnostico diagnostico) {
        String sql = "UPDATE TB_DIAGNOSTICO_JV_NEW SET DESCRICAO_DIAGNOSTICO = ?, CATEGORIA_DIAGNOSTICO = ?, " +
                     "ORCAMENTO_DIAGNOSTICO = ?, ID_PROBLEMA = ?, ID_PECA = ?, ID_MAO_DE_OBRA = ? WHERE ID_DIAGNOSTICO = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, diagnostico.getDescricaoDiagnostico());
            ps.setString(2, diagnostico.getCategoriaDiagnostico());
            ps.setDouble(3, diagnostico.getOrcamentoDiagnostico());
            ps.setInt(4, diagnostico.getIdProblema());
            ps.setInt(5, diagnostico.getIdPeca());
            ps.setInt(6, diagnostico.getIdMaoDeObra());
            ps.setInt(7, diagnostico.getIdDiagnostico());
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
    public List<Diagnostico> listar() {
        List<Diagnostico> diagnosticos = new ArrayList<>();
        String sql = "SELECT * FROM TB_DIAGNOSTICO_JV_NEW";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idDiagnostico = rs.getInt("ID_DIAGNOSTICO");
                String descricaoDiagnostico = rs.getString("DESCRICAO_DIAGNOSTICO");
                String categoriaDiagnostico = rs.getString("CATEGORIA_DIAGNOSTICO");
                double orcamentoDiagnostico = rs.getDouble("ORCAMENTO_DIAGNOSTICO");
                int idProblema = rs.getInt("ID_PROBLEMA");
                int idPeca = rs.getInt("ID_PECA");
                int idMaoDeObra = rs.getInt("ID_MAO_DE_OBRA");

                diagnosticos.add(new Diagnostico(idDiagnostico, descricaoDiagnostico, categoriaDiagnostico, 
                                                 orcamentoDiagnostico, idProblema, idPeca, idMaoDeObra));
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
        return diagnosticos;
    }
}
