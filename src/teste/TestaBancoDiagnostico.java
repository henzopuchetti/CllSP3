package teste;

import java.sql.SQLException;
import java.util.List;

import dao.DiagnosticoDAO;
import model.Diagnostico;

public class TestaBancoDiagnostico {

    public static void main(String[] args) {
        try {
            // Criando um gerenciador de diagnóstico
            DiagnosticoDAO gd = new DiagnosticoDAO();

            // Criando um objeto Diagnostico
            Diagnostico diagnostico = new Diagnostico(1, "Falha no motor", "Mecânica", 5000.00, 1, 1, 1);

            // Inserir diagnóstico
            System.out.println(gd.inserir(diagnostico) ? "Diagnóstico adicionado!" : "Diagnóstico NÃO adicionado!");

            // Atualizar diagnóstico
            //diagnostico.setDescricaoDiagnostico("Problema na suspensão");
            //diagnostico.setCategoriaDiagnostico("Mecânica leve");
            //diagnostico.setOrcamentoDiagnostico(2500.00);
            //boolean atualizado = gd.atualizar(diagnostico);
            //System.out.println(atualizado ? "Diagnóstico atualizado!" : "Diagnóstico NÃO atualizado!");

            // Listar diagnósticos
            //List<Diagnostico> diagnosticos = gd.listar();
            //System.out.println("Lista de diagnósticos:");
            //diagnosticos.forEach(d -> System.out.println(d));

            // Excluir diagnóstico
            //boolean excluido = gd.excluir(diagnostico.getIdDiagnostico());
            //System.out.println(excluido ? "Diagnóstico removido!" : "Diagnóstico NÃO removido!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}