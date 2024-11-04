package teste;

import java.sql.SQLException;
import java.util.List;

import dao.ClienteDAO;
import model.Cliente;

public class TestaBancoCliente {

    public static void main(String[] args) {
        try {
            // Criando um gerenciador de clientes
            ClienteDAO gc = new ClienteDAO();

            // Criando um objeto Cliente com dados válidos
            Cliente cliente = new Cliente(1, "Henzo", 1234567891, 98765432, 1, 1);

            // Inserir cliente (só vai adicionar se o telefone for válido)
            if (cliente.validarTelefone()) {
                System.out.println(gc.inserir(cliente) ? "Cliente adicionado!" : "Cliente NÃO adicionado!");
            } else {
                System.err.println("Telefone inválido, cliente não será adicionado.");
            }

            // Atualizar cliente com dados novos (validação de telefone também será aplicada)
            //cliente.setNomeCliente("Maria Silva");
            //cliente.setTelefoneCliente(1198517398); // Novo telefone
            //cliente.setCepCliente(12345678);
            //cliente.setIdLogin(2);
            //cliente.setIdVeiculo(2);

            //if (cliente.validarTelefone()) {
                //boolean atualizado = gc.atualizar(cliente);
                //System.out.println(atualizado ? "Cliente atualizado!" : "Cliente NÃO atualizado!");
            //} else {
                //System.err.println("Telefone inválido, cliente não será atualizado.");
            //}

            // Listar todos os clientes
            //List<Cliente> clientes = gc.listar();
            //System.out.println("Lista de clientes:");
            //clientes.forEach(c -> System.out.println(c));

            // Excluir cliente pelo ID
            //boolean excluido = gc.excluir(cliente.getIdCliente());
            //System.out.println(excluido ? "Cliente removido!" : "Cliente NÃO removido!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
