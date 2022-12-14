package funcionalidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import modelos.Atividade;
import modelos.Projeto;
import modelos.Usuario;

public abstract class Operacoes {

    protected List<Usuario> listUsuario;
    protected List<Projeto> listProjeto;
    protected List<Atividade> listAtividade;

    public Operacoes(List<Usuario> listUsuarios, List<Projeto> listProjetos,
            List<Atividade> listAtividades) {

                this.listUsuario = listUsuarios;
                this.listProjeto = listProjetos;
                this.listAtividade = listAtividades;
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


