package teste;

import java.sql.SQLException;

import java.util.List;

import dao.MaoDeObraDAO;
import model.MaoDeObra;

public class TestaBancoMaoDeObra {

    public static void main(String[] args) {
        try {
            // Criando um gerenciador de mão de obra
            MaoDeObraDAO gmo = new MaoDeObraDAO();

            // Criando um objeto MaoDeObra
            MaoDeObra maoDeObra = new MaoDeObra(1, "Troca de óleo", "100");

            // Inserir mão de obra
            System.out.println(gmo.inserir(maoDeObra) ? "Mão de obra adicionada!" : "Mão de obra NÃO adicionada!");

            // Atualizar mão de obra
            //maoDeObra.setTipoServico("Troca de filtros");
            //maoDeObra.setPrecoServico("120");
            //boolean atualizado = gmo.atualizar(maoDeObra);
            //System.out.println(atualizado ? "Mão de obra atualizada!" : "Mão de obra NÃO atualizada!");

            // Listar mão de obra
            //List<MaoDeObra> maoDeObras = gmo.listar();
            //System.out.println("Lista de mão de obra:");
            //maoDeObras.forEach(m -> System.out.println(m));

            // Excluir mão de obra
            //boolean excluido = gmo.excluir(maoDeObra.getIdMaoDeObra());
            //System.out.println(excluido ? "Mão de obra removida!" : "Mão de obra NÃO removida!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
