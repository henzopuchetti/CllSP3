package teste;

import java.sql.SQLException;

import java.util.List;

import dao.ProblemaDAO;
import model.Problema;

public class TestaBancoProblema {

    public static void main(String[] args) {
        try {
            // Criando um gerenciador de problemas
            ProblemaDAO gp = new ProblemaDAO();

            // Criando um objeto Problema
            Problema problema = new Problema(1, "Problema de falha no motor", "Motor", 1);

            // Inserir problema
            System.out.println(gp.inserir(problema) ? "Problema adicionado!" : "Problema NÃO adicionado!");

            // Atualizar problema
            //problema.setDescricaoProblema("Problema de falha na suspensão");
            //problema.setCategoriaProblema("Suspensão");
            //boolean atualizado = gp.atualizar(problema);
            //System.out.println(atualizado ? "Problema atualizado!" : "Problema NÃO atualizado!");

            // Listar problemas
            //List<Problema> problemas = gp.listar();
            //System.out.println("Lista de problemas:");
            //problemas.forEach(p -> System.out.println(p));

            // Excluir problema
            //boolean excluido = gp.excluir(problema.getIdProblema());
            //System.out.println(excluido ? "Problema removido!" : "Problema NÃO removido!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
