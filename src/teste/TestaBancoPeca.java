package teste;

import java.sql.SQLException;

import java.util.List;

import dao.PecaDAO;
import model.Peca;

public class TestaBancoPeca {

    public static void main(String[] args) {
        try {
            // Criando um gerenciador de peças
            PecaDAO gp = new PecaDAO();

            // Criando um objeto Peca
            Peca peca = new Peca(1, "Filtro de óleo", 50);

            // Inserir peça
            System.out.println(gp.inserir(peca) ? "Peça adicionada!" : "Peça NÃO adicionada!");

            // Atualizar peça
            //peca.setNomePeca("Filtro de ar");
            //peca.setPrecoPeca(55.00);
            //boolean atualizado = gp.atualizar(peca);
            //System.out.println(atualizado ? "Peça atualizada!" : "Peça NÃO atualizada!");

            // Listar peças
            //List<Peca> pecas = gp.listar();
            //System.out.println("Lista de peças:");
            //pecas.forEach(p -> System.out.println(p));

            // Excluir peça
            //boolean excluido = gp.excluir(peca.getIdPeca());
            //System.out.println(excluido ? "Peça removida!" : "Peça NÃO removida!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
