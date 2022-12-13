package modelos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

import funcionalidades.Operacoes;


public class Bolsa extends Operacoes {
    public Bolsa(ArrayList<Usuario> listUsuarios, ArrayList<Projeto> listProjetos, ArrayList<Atividade> listAtividades) {
        super(listUsuarios, listProjetos, listAtividades);
    }

    public static void gerenciamento(List<Projeto> listProjeto){
        Scanner input = new Scanner(System.in);
        for (Projeto projeto : listProjeto) {
            System.out.println(projeto.getId() + " - " + projeto.getIdent() + " " + projeto.getDesc());
        }
        int opt = input.nextInt();
        input.nextLine();
        busca(listProjeto, opt);
    }
    public static void busca(List<Projeto> listProjeto, int id){

        /*System.out.println("""

        """);*/
        IntStream.range(0, listProjeto.size()).mapToObj(i -> "Profissional: " + listProjeto.get(id).getProfissionais().get(i).getNome() + " valor bolsa: " + listProjeto.get(id).getProfissionais().get(i).getBolsa() + "(" + listProjeto.get(id).getProfissionais().get(i).getBolsa() * listProjeto.get(id).getTempo() + " ) ").forEach(System.out::println);
    }
}
