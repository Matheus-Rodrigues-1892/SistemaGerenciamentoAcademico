package interfaces;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import funcionalidades.Pilha;
import modelos.Atividade;
import modelos.MenuExt;
import modelos.MenuInt;
import modelos.Projeto;
import modelos.Usuario;

public interface Menu {

    void principal();

    void menuE(int logged, ArrayList<Usuario> listUsuarios, int id, Pilha operacaoRedo, Pilha operacaoUndo, ArrayList<Projeto> listProjetos, ArrayList<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException;

    int isLogged(int logged, ArrayList<Usuario> listUsuarios, String login, String senha, int id);

    void login(int logged, ArrayList<Usuario> listUsuarios, int id, ArrayList<Projeto> listProjetos, Pilha operacaoRedo, Pilha operacaoUndo, ArrayList<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException;

    void usuarios();

    void atividades();

    void projetos();

    void consulta();

    void relatorio();

    void acoes();

    void redo();

    void undo();

    void menuI(Scanner input, ArrayList<Usuario> listUsuarios, int identificador, String senha, int logged, ArrayList<Projeto> listProjetos, Pilha operacaoRedo, ArrayList<Atividade> listAtividades, Pilha operacaoUndo) throws ParseException;
}
    
