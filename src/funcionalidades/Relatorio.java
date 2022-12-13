package funcionalidades;

import java.util.List;
import java.util.Scanner;

import modelos.Atividade;
import modelos.Projeto;
import modelos.Usuario;

public class Relatorio extends Operacoes{

    public Relatorio(List<Usuario> listUsuarios, List<Projeto> listProjetos, List<Atividade> listAtividades) {
        super(listUsuarios, listProjetos, listAtividades);
    }

    public static void projetoRelatorio(List<Projeto> listProjetos){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Selecionar um projeto:\n");
            for (Projeto projeto : listProjetos) {
                System.out.println(projeto.getId() + " -  " + projeto.getIdent() + " ( " + projeto.getIdent() + " )");
            }
            int aux = input.nextInt();
            input.nextLine();
            gerarRelatorioProjeto(listProjetos, aux);
        } catch ( IllegalArgumentException e){
            System.out.println("Lista de atividades vazias" + e.getMessage());
        }
    }

    static void gerarRelatorioProjeto(List<Projeto> listProjetos, int identif){

        System.out.println("Nome do Projeto: ");

        System.out.println(listProjetos.get(identif).getIdent());
        
        System.out.println("Descricao: \n" + listProjetos.get(identif).getDescricao());
        
        System.out.println("Status atual: ");

        System.out.println(listProjetos.get(identif).getStatus());
        System.out.println("Coordenador: " +
                listProjetos.get(identif).getCoordenador().getNome());
                System.out.println("Profissionais envolvidos: ");

        for (int i = 0; i < listProjetos.get(identif).getProfissionais().size(); i++) {
            System.out.println(listProjetos.get(identif).getProfissionais().get(i).getNome());
        }

        System.out.println("Atividades envolvidas no Projeto:\n");
        for (int i = 0; i < listProjetos.get(identif).getAtividades().size(); i++) {
            System.out.println(listProjetos.get(identif).getAtividades().get(i).getIdent() + " " + listProjetos.get(identif).getAtividades().get(i).getDescricao());
        }

        System.out.println("Inicio: " + listProjetos.get(identif).getdataInicio() + " \n" + "Termino: " + listProjetos.get(identif).getdataTermino());
        System.out.println("Tempo: " + listProjetos.get(identif).getTempo());
    }

    public static void atividadeRelatorio(List<Atividade> listAtividades){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Selecionar uma Atividade:\n");
            for (Atividade atividade : listAtividades) {
                System.out.println(atividade.getId() + " -  " + atividade.getIdent() + " ( " + atividade.getIdent() + " )");
            }
            int opt = input.nextInt();
            input.nextLine();
            gerarRelatorioAtividade(listAtividades, opt);
        } catch ( IllegalArgumentException e){
        System.out.println("Lista de Atividades vazia" + e.getMessage());
        }
     
    }


    static void gerarRelatorioAtividade(List<Atividade> listAtividades, int ident){
        
        System.out.println("Nome do Projeto: ");

        System.out.println(listAtividades.get(ident).getIdent());
        
        System.out.println("Descricao: \n" + listAtividades.get(ident).getDescricao());
        
        System.out.println("Inicio: " + listAtividades.get(ident).getDataInicio() + " \n" + "Termino: " + listAtividades.get(ident).getDataTermino());
        
        System.out.println("Responsavel pela Atividade: \n" +
                listAtividades.get(ident).getResponsavel().getNome());
        System.out.println("Profissionais envolvidos: ");

        for (int i = 0; i < listAtividades.get(ident).getProfissionais().size(); i++){
            System.out.println(listAtividades.get(ident).getProfissionais().get(i).getNome());
        }
    }
    
}
