package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import credencial.CredenciaisCll;
import model.Cliente;
import oracle.jdbc.pool.OracleDataSource;

public class ClienteDAO {

    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public ClienteDAO() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(CredenciaisCll.user);
        ods.setPassword(CredenciaisCll.pwd);
        conn = ods.getConnection();
        System.out.println("Conectado!");
    }

    // Inserir
    public boolean inserir(Cliente cliente) {
        if (!cliente.validarTelefone()) {
            System.err.println("Telefone inválido!");
            return false;
        }

        String sql = "INSERT INTO TB_CLIENTE_JV_NEW (ID_CLIENTE, NOME_CLIENTE, TELEFONE_CLIENTE, CEP_CLIENTE, ID_LOGIN, ID_VEICULO) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNomeCliente());
            ps.setInt(3, cliente.getTelefoneCliente());
            ps.setInt(4, cliente.getCepCliente());
            ps.setInt(5, cliente.getIdLogin());
            ps.setInt(6, cliente.getIdVeiculo());
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
    public boolean excluir(int idCliente) {
        String sql = "DELETE FROM TB_CLIENTE_JV_NEW WHERE ID_CLIENTE = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao remover o cliente");
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
    public boolean atualizar(Cliente cliente) {
        if (!cliente.validarTelefone()) {
            System.err.println("Telefone inválido!");
            return false;
        }

        String sql = "UPDATE TB_CLIENTE_NEW SET NOME_CLIENTE = ?, TELEFONE_CLIENTE = ?, CEP_CLIENTE = ?, ID_LOGIN = ?, ID_VEICULO = ? WHERE ID_CLIENTE = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNomeCliente());
            ps.setInt(2, cliente.getTelefoneCliente());
            ps.setInt(3, cliente.getCepCliente());
            ps.setInt(4, cliente.getIdLogin());
            ps.setInt(5, cliente.getIdVeiculo());
            ps.setInt(6, cliente.getIdCliente());
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
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM TB_CLIENTE_JV";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("ID_CLIENTE");
                String nomeCliente = rs.getString("NOME_CLIENTE");
                int telefoneCliente = rs.getInt("TELEFONE_CLIENTE");
                int cepCliente = rs.getInt("CEP_CLIENTE");
                int idLogin = rs.getInt("ID_LOGIN");
                int idVeiculo = rs.getInt("ID_VEICULO");

                clientes.add(new Cliente(idCliente, nomeCliente, telefoneCliente, cepCliente, idLogin, idVeiculo));
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
        return clientes;
    }
}