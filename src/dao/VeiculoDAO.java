package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import credencial.CredenciaisCll;
import model.Veiculo;
import oracle.jdbc.pool.OracleDataSource;

public class VeiculoDAO {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public VeiculoDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(CredenciaisCll.user);
        ods.setPassword(CredenciaisCll.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    // Inserir
    public boolean inserir(Veiculo veiculo) {
        if (!veiculo.validarMarcaModelo()) {
            System.err.println("Marca ou modelo inválido! Devem ter mais de 1 caractere.");
            return false;
        }

        String sql = "INSERT INTO TB_VEICULO_JV_NEW (ID_VEICULO, MARCA_VEICULO, MODELO_VEICULO) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, veiculo.getIdVeiculo());
            ps.setString(2, veiculo.getMarcaVeiculo());
            ps.setString(3, veiculo.getModeloVeiculo());
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
    public boolean excluir(int idVeiculo) {
        String sql = "DELETE FROM TB_VEICULO_JV_NEW WHERE ID_VEICULO = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idVeiculo);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover o veículo");
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
    public boolean atualizar(Veiculo veiculo) {
        if (!veiculo.validarMarcaModelo()) {
            System.err.println("Marca ou modelo inválido! Devem ter mais de 1 caractere.");
            return false;
        }

        String sql = "UPDATE TB_VEICULO_JV_NEW SET MARCA_VEICULO = ?, MODELO_VEICULO = ? WHERE ID_VEICULO = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, veiculo.getMarcaVeiculo());
            ps.setString(2, veiculo.getModeloVeiculo());
            ps.setInt(3, veiculo.getIdVeiculo());
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
    public List<Veiculo> listar() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM TB_VEICULO_JV_NEW";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idVeiculo = rs.getInt("ID_VEICULO");
                String marcaVeiculo = rs.getString("MARCA_VEICULO");
                String modeloVeiculo = rs.getString("MODELO_VEICULO");

                veiculos.add(new Veiculo(idVeiculo, marcaVeiculo, modeloVeiculo));
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
        return veiculos;
    }
}
