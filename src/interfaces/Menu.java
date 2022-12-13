package interfaces;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import funcionalidades.Pilha;
import modelos.Atividade;
import modelos.MenuExt;
import modelos.MenuInt;
import modelos.Projeto;
import modelos.Usuario;

public interface Menu {

    void principal();

    void menuE(int logged, List<Usuario> listUsuarios, int id, Pilha operacaoRedo, Pilha operacaoUndo, List<Projeto> listProjetos, List<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException;

    int isLogged(int logged, List<Usuario> listUsuarios, String login, String senha, int id);

    void login(int logged, List<Usuario> listUsuarios, int id, List<Projeto> listProjetos, Pilha operacaoRedo, Pilha operacaoUndo, List<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException;

    void usuarios();

    void atividades();

    void projetos();

    void consulta();

    void relatorio();

    void acoes();

    void redo();

    void undo();

    void menuI(Scanner input, List<Usuario> listUsuarios, int identificador, String senha, int logged, List<Projeto> listProjetos, Pilha operacaoRedo, List<Atividade> listAtividades, Pilha operacaoUndo) throws ParseException;
}
    
