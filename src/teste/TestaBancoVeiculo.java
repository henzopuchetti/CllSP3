package teste;

import java.sql.SQLException;
import java.util.List;

import dao.VeiculoDAO;
import model.Veiculo;

public class TestaBancoVeiculo {

    public static void main(String[] args) {
        try {
            // Criando um gerenciador de veículos
            VeiculoDAO gv = new VeiculoDAO();

            // Criando um objeto Veiculo
            Veiculo veiculo = new Veiculo(1, "Mercedes", "G63");

            // Validar o veículo antes de inserir
            if (veiculo.validarMarcaModelo()) {
                // Inserir veículo
                System.out.println(gv.inserir(veiculo) ? "Veículo adicionado!" : "Veículo NÃO adicionado!");
            } else {
                System.err.println("Veículo inválido! Marca e modelo devem ter mais de 1 caractere.");
            }

            // Atualizar veículo
            //veiculo.setMarcaVeiculo("BMW");
            //veiculo.setModeloVeiculo("M4");

            // Validar o veículo antes de atualizar
            //if (veiculo.validarMarcaModelo()) {
                //boolean atualizado = gv.atualizar(veiculo);
                //System.out.println(atualizado ? "Veículo atualizado!" : "Veículo NÃO atualizado!");
            //} else {
                //System.err.println("Veículo inválido! Marca e modelo devem ter mais de 1 caractere.");
            //}

            // Listar veículos
            //List<Veiculo> veiculos = gv.listar();
            //System.out.println("Lista de veículos:");
            //veiculos.forEach(v -> System.out.println(v.getIdVeiculo() + " - " + v.getMarcaVeiculo() + " - " + v.getModeloVeiculo()));

            // Excluir veículo
            //boolean excluido = gv.excluir(veiculo.getIdVeiculo());
            //System.out.println(excluido ? "Veículo removido!" : "Veículo NÃO removido!");

        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
}
