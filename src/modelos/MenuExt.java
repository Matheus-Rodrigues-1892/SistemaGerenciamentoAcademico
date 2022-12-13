import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuExt implements Menu{
    public void optMenuE(int logged, ArrayList<Usuario> listUser, int identificador, Pilha redo, Pilha undo, ArrayList<Projeto> listProject, ArrayList<Atividade> listActivities, MenuExt menu, MenuInt menu1) throws ParseException, NumberFormatException, NullPointerException {
        loop: while (true) {
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            menu.principal();
            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    menu.login(logged, listUser, identificador, listProject, redo, undo, listActivities, menu, menu1);
                    break;
                case 2:
                    Criar.addUser(input, listUser, redo);
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
    public int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador){
        for (DefaultUser defaultUser : listUser) {
            if (defaultUser.getLogin().equals(login) && defaultUser.getPassword().equals(password)) {
                System.out.println("Logado com sucesso!");
                identificador = defaultUser.getId();
                return 1;
            }
        }
        System.out.println("Senha ou Usuario incorretos!");
        return 0;
    }

    public void login(int logged, ArrayList<Usuario> listUsuario, int identificador, ArrayList<Projeto> listProject, Pilha redo, Pilha undo, ArrayList<Atividade> listActivity, MenuExt menu, MenuInt menu1) {
        //System.out.println(listUser.get(0).getName());
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Login:");
        String login = input.nextLine();
        System.out.println("Senha: ");
        String password = input.nextLine();
        while( menu.isLogged(logged, listUser, login, password, identificador) == 1) {
            Process.processMenuInt(menu1, input, listUser, identificador, password, logged, listProject, redo, listActivity, undo);
            break;
        }
        //System.out.println(logged);

    }


    @Override
    public void optMenuI(Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Activity> listActivity, Pilha undo) {

    }
    @Override
    public void menuE(int logged, ArrayList<Usuario> listUsuarios, int id, Pilha operacaoRedo, Pilha operacaoUndo,
            ArrayList<Projeto> listProjetos, ArrayList<Atividade> listAtividades, MenuExt menu, MenuInt menu1)
            throws ParseException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public int isLogged(int logged, ArrayList<Usuario> listUsuarios, String login, String senha, int id) {
        // TODO Auto-generated method stub
        return 0;
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
    public void menuI(Scanner input, ArrayList<Usuario> listUsuarios, int identificador, String senha, int logged,
            ArrayList<Projeto> listProjetos, Pilha operacaoRedo, ArrayList<Atividade> listAtividades,
            Pilha operacaoUndo) throws ParseException {
        // TODO Auto-generated method stub
        
    }

}
