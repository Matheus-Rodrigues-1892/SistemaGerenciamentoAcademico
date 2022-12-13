import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Bolsa extends Operacoes {
    public Bolsa(ArrayList<Usuario> usuarios, ArrayList<Projeto> projetos, ArrayList<Atividade> atividades) {
        super(usuarios, projetos, atividades);
    }

    public static void bountyManager(List<Projeto> listProjeto){
        Scanner input = new Scanner(System.in);
        for (Projeto projeto : listProjeto) {
            System.out.println(projeto.getId() + " - " + projeto.getIdent() + " " + projeto.getDesc());
        }
        int opt = input.nextInt();
        input.nextLine();
        bounty(listProjeto, opt);
    }
    public static void bounty(List<Projeto> listProjeto, int id){
        IntStream.range(0, listProjeto.size()).mapToObj(i -> "Profissional: " + listProjeto.get(id).getProfissionais().get(i).getName() + " valor bolsa: " + listProjeto.get(id).getProfissionais().get(i).getBolsa() + "(" + listProjeto.get(id).getProfissionais().get(i).getBolsa() * listProjeto.get(id).getTempo() + " ) ").forEach(System.out::println);
    }
}
