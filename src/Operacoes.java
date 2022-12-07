import java.util.ArrayList;
import java.util.Stack;

public abstract class Operacoes {

    protected ArrayList<Usuario> listUsuario;
    protected ArrayList<Projeto> listProjeto;
    protected ArrayList<Atividade> listAtividade;


    public Operacoes(ArrayList<Usuario> listUsuario, ArrayList<Projeto> listProjeto,
            ArrayList<Atividade> listAtividade) {
        this.listUsuario = listUsuario;
        this.listProjeto = listProjeto;
        this.listAtividade = listAtividade;
    }
    private Stack pilhaUndo;
    private Stack pilhaRedo;

    public Stack getPilhaUndo() {
        return pilhaUndo;
    }
    public void setPilhaUndo(Stack pilhaUndo) {
        this.pilhaUndo = pilhaUndo;
    }
    public Stack getPilhaRedo() {
        return pilhaRedo;
    }
    public void setPilhaRedo(Stack pilhaRedo) {
        this.pilhaRedo = pilhaRedo;
    }
    
    
}
