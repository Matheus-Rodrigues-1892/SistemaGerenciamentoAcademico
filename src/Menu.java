import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Menu {

    void principal();

    void menuE(int logged, ArrayList<Usuario> listUsuarios, int id, Pilha redo, Pilha undo, ArrayList<Projeto> listProjetos, ArrayList<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException;

    int isLogged(int logged, ArrayList<Usuario> listUsuarios, String login, String senha, int id);

    void login(int logged, ArrayList<Usuario> listUsuarios, int id, ArrayList<Projeto> listProjetos, Pilha redo, Pilha undo, ArrayList<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException;

    void usuarios();

    void atividades();

    void projetos();

    void consulta();

    void relatorio();

    void acoes();

    void redo();

    void undo();

    void menuI(Scanner input, ArrayList<Usuario> listUsuarios, int identificador, String senha, int logged, ArrayList<Projeto> listProjetos, Pilha redo, ArrayList<Atividade> listAtividades, Pilha undo) throws ParseException;
}
    
