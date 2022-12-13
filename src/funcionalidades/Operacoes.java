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

    public Operacoes(ArrayList<Usuario> listUsuarios, ArrayList<Projeto> listProjetos,
            ArrayList<Atividade> listAtividades) {

                this.listUsuario = listUsuarios;
                this.listProjeto = listProjetos;
                this.listAtividade = listAtividades;
    }

    private Stack pilhaUndo;
    private Stack pilhaRedo;

    public Stack getStkUndo() { 
        return pilhaUndo; 
    }

    public void setStkUndo(Stack pilhaUndo) { 
        this.pilhaUndo = pilhaUndo; 
    }

    public Stack getStkRedo() { 
        return pilhaRedo; 
    }

    public void setStkRedo(Stack pilhaRedo) { 
        this.pilhaRedo = pilhaRedo; 
    }

}


