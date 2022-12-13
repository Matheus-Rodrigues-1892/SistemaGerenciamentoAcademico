package funcionalidades;

import modelos.Atividade;
import modelos.Usuario;
import modelos.Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pilha extends Operacoes{
    private Stack setPilhaUndo;
    private Stack setPilhaRedo;
    
    public Pilha(List<Usuario> listUsuario, List<Projeto> listProjeto, List<Atividade> listAtividade) {
        super(listUsuario, listProjeto, listAtividade);
        //TODO Auto-generated constructor stub
    }

    public Stack getSetPilhaUndo() {
        return setPilhaUndo;
    }

    public void setSetPilhaUndo(Stack setPilhaUndo) {
        this.setPilhaUndo = setPilhaUndo;
    }

    public Stack getSetPilhaRedo() {
        return setPilhaRedo;
    }

    public void setSetPilhaRedo(Stack setPilhaRedo) {
        this.setPilhaRedo = setPilhaRedo;
    }

    public static void opDesfazer(Pilha undo, Pilha redo, List padrao){

        try {
            Stack stk;
            stk = undo.getPilhaRedo();
            redo.setPilhaUndo(undo.getPilhaRedo());
            var popped = stk.peek();
            stk.pop();
            undo.setPilhaRedo(stk);
            if(padrao.contains(popped)){
                padrao.remove(popped);
            }
            else{
                padrao.add(popped);
            }
        } catch (IllegalArgumentException e){
            System.out.println("Lista Vazia!");
        }

    }

    public static void opRefazer(Pilha undo, Pilha redo, List padrao){
        try {
            Stack stk;
            stk = undo.getPilhaRedo();
            stk.push(redo.getPilhaUndo());
            undo.setPilhaRedo(stk);
            var peeked = stk.peek();

            if (padrao.contains(peeked)) {
                padrao.remove(peeked);
            } else {
                padrao.add(peeked);
            }
        } catch (IllegalArgumentException e ){
            System.out.println("Lista Vazia!");
        }
    }
}
