package modelos;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import funcionalidades.Adicao;
import funcionalidades.Gerenciar;
import funcionalidades.Pilha;
import interfaces.Menu;

public class MenuExt implements Menu{
    public void optMenuE(int logged, List<Usuario> listUsuario, int identificador, Pilha redo, Pilha undo, List<Projeto> listProjeto, List<Atividade> listAtividade, MenuExt menu, MenuInt menu1) throws ParseException, NumberFormatException, NullPointerException {
        loop: while (true) {
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            menu.principal();
            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    menu.login(logged, listUsuario, identificador, listProjeto, redo, undo, listAtividade, menu, menu1);
                    break;
                case 2:
                    Adicao.adicionaUsuario(input, listUsuario, null);
                    break;
                case 3:
                    System.out.println("You logged out! See you next time.");
                    break loop;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
    public void principal(){
        System.out.println("""
                Selecione uma opcao:
                1 - Login
                2 - Cadastro de usuario
                3 - Sair""");
    }
    @Override
    public int isLogged(int logged, List<Usuario> listUsuarios, String login, String senha, int identificador){
        for (Usuario usuario : listUsuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                System.out.println("Logado com sucesso!");
                identificador = usuario.getId();
                return 1;
            }
        }
        System.out.println("Senha ou Usuario incorretos!");
        return 0;
    }

    public void login(int logged, List<Usuario> listUsuario, int identificador, List<Projeto> listProjeto, Pilha redo, Pilha undo, List<Atividade> listAtividade, MenuExt menu, MenuInt menu1) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Login:");
        String login = input.nextLine();
        System.out.println("Senha: ");
        String password = input.nextLine();
        while( menu.isLogged(logged, listUsuario, login, password, identificador) == 1) {
            Gerenciar.processMenuInt(menu1, input, listUsuario, identificador, password, logged, listProjeto, redo, listAtividade, undo);
            break;
        }

    }

    public void optMenuI(Scanner input, List<Usuario> listUsuarios, int identificador, String senha, int logged, List<Projeto> listProjeto, Pilha redo, List<Atividade> listAtividade, Pilha undo) {

    }
    @Override
    public void menuE(int logged, List<Usuario> listUsuarios, int id, Pilha operacaoRedo, Pilha operacaoUndo,
            List<Projeto> listProjetos, List<Atividade> listAtividades, MenuExt menu, MenuInt menu1)
            throws ParseException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void usuarios() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void atividades() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void projetos() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void consulta() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void relatorio() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void acoes() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void redo() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void undo() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void menuI(Scanner input, List<Usuario> listUsuarios, int identificador, String senha, int logged,
            List<Projeto> listProjetos, Pilha operacaoRedo, List<Atividade> listAtividades,
            Pilha operacaoUndo) throws ParseException {
        // TODO Auto-generated method stub
        
    }

}
