package funcionalidades;

import modelos.Atividade;
import modelos.Usuario;
import modelos.Projeto;
import interfaces.*;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Remocao extends Operacoes{

    public Remocao(List<Usuario> listUsuarios, List<Projeto> listProjetos, List<Atividade> listAtividades) {
        super(listUsuarios, listProjetos, listAtividades);
    }

    public static void RemoveAtv(Scanner input, List<Atividade> listAtividades, Pilha redo){
        Stack<Atividade> stack = new Stack<>();
        if (listAtividades.size()==0){
            System.out.println("Nao ha atividades inseridas");
        }
        else {
            System.out.println("Selecione uma atividade para remover? selecione um id:");
            for (Atividade atividade : listAtividades) {
                System.out.println(atividade.getIdent() + " " + atividade.getDescricao() + " " + atividade.getId());
            }
            int item = input.nextInt();
            Atividade atividade = listAtividades.get(item);
            listAtividades.remove(item);
            stack.push(atividade);
            redo.setPilhaRedo(stack);
        }
    }

    public static void RemoveProj(Scanner input, List<Projeto> listProjetos, Pilha redo){
        Stack<Object> stack = new Stack<>();
        if (listProjetos.size()==0){
            System.out.println("Nao ha projetos cadastrados");
        }
        else {
            System.out.println("Selecione o Projeto para remover? selecione um id:");
            for (Projeto projeto : listProjetos) {
                System.out.println(projeto.getIdent() + " " + projeto.getDescricao() + " " + projeto.getId());
            }
            int item = input.nextInt();
            
            Projeto project = listProjetos.get(item);
            stack.push(project);
            redo.setPilhaRedo(stack);
            listProjetos.remove(item);
        }
    }

    public static void RemoveUsuario(Scanner input, List<Usuario> listUsuarios, Pilha redo){
        Stack<Usuario> stack = new Stack<>();
        Usuario user;
        if (listUsuarios.size() <= 1){
            System.out.println("Nao ha funcionarios cadastrados");
        }
        else {
            System.out.println("Selecione um funcionario pra remover? selecione um id:");
            for (Usuario usuario : listUsuarios) {
                System.out.println(usuario.getNome() + " " + usuario.getId());
            }
            int item = input.nextInt();

            input.nextLine();

            user = listUsuarios.get(item);
            listUsuarios.remove(item);
            stack.push(user);
            redo.setPilhaRedo(stack);

        }
    }



    
}
