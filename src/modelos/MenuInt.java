import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInt implements Menu {
    public void principal(){
        System.out.println("""
                Selecione uma opção:\s
                1 - Usuarios
                2 - Atividades
                3 - Projetos
                4 - Consultas
                5 - Mudar senha
                6 - Relatorios
                7 - Gerenciar bolsas (Projetos)\s
                8 - Acoes\s
                9 - Sair""");
    }
    @Override
    public void usuarios(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Cadastrar Usuario
                2 - Editar Usuario
                3 - Deletar Usuario""");
    }
    @Override
    public void atividades(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Cadastrar Atividade
                2 - Editar Atividade
                3 - Deletar Atividade""");
    }
    @Override
    public void projetos(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Cadastrar Projeto
                2 - Editar Projeto
                3 - Deletar Projeto""");
    }
    @Override
    public void relatorio(){
        System.out.println("""
                Relatorios:
                1 - Relatorio de projeto
                2 - Relatorio de activity""");
    }
    @Override
    public void consulta(){
        System.out.println("1: Consultar usuarios");
        System.out.println("2: Consultar Atividades");
        System.out.println("3: Consultar Projetos");
    }
    @Override
    public void acoes(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Desfazer
                2 - Refazer""");
    }
    public void operacaoRedo(){
        System.out.println("""
                REFAZER:
                1 - Usuario
                2 - Atividade
                3 - Projeto""");
    }
    @Override
    public void operacaoUndo(){
        System.out.println("""
                DESFAZER:
                1 - Usuario
                2 - Atividade
                3 - Projeto""");
    }


    public MenuInt() {

    }

    public void optMenuI(Scanner input, ArrayList<Usuario> listUsuario, int identificador, String senha, int logged, ArrayList<Projeto> listProjeto, Pilha redo, ArrayList<Atividade> listActivity, Pilha undo) throws ParseException, NumberFormatException, NullPointerException, InputMismatchException {
        MenuInt menu = new MenuInt();
        Coordenador coordenador = new Coordenador();
        Usuario user = Usuario.criarUsuario();
        loop: while(true) {
            menu.principal();
            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    usuarios();
                    int option = input.nextInt();
                    switch (option) {
                        case 1 -> Criar.criarUsuario(input, listUsuario, redo);
                        case 2 -> Update.editUser(input, listUsuario, redo);
                        case 3 -> Remocao.removeUsuarios(input, listUsuario, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 2:
                    atividades();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Add.addAtividade(input, listActivity, listUser, redo);
                        case 2 -> Update.editAtividade(input, listActivity, listUser, redo);
                        case 3 -> Remove.delAtividade(input, listActivity, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 3:
                    projetos();();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Criar.addProject(input,listProjeto, listUsuario, listActivity, identificador, redo);
                        case 2 -> Update.editProject(input, listProjeto, listUsuario, listActivity, identificador, redo);
                        case 3 -> Remove.delProject(input, listProjeto, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 4:
                    consulta();
                    option = input.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("""
                                    Qual tipo de usuario você quer verificar?
                                    1 - Coordenadores
                                    2 - Todos os usuarios
                                    """);
                            opt = input.nextInt();
                            switch (opt){
                                case 1 -> Query.consultaUser(listUsuario, coordenador);
                                case 2 -> Query.consultaUser(listUsuario);
                                default -> System.out.println("Opcao invalida!");
                            }
                        case 2:
                            Query.consultaAtividade(listActivity);
                            break;
                        case 3:
                            Query.consultaProject(listProject);
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;
                case 5:
                    user.changePass(listUser, identificador, password);
                    break;
                case 6:
                    stringRelatorio();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Reports.projetoRelatorio(listProject);
                        case 2 -> Reports.atividadeRelatorio(listActivity);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 7:
                    Bolsa.bountyManager(listProject);
                    break;
                case 8:
                    stringActions();
                    option = input.nextInt();
                    switch (option) {
                        case 1:
                            stringDesfazer();
                            opt = input.nextInt();
                            switch (opt) {
                                case 1 -> Pilha.desfazer(redo, undo, listUser);
                                case 2 -> Pilha.desfazer(redo, undo, listActivity);
                                case 3 -> Pilha.desfazer(redo, undo, listProject);
                                default -> System.out.println("Opcao invalida!");
                            }
                            break;
                        case 2:
                            stringRefazer();
                            opt = input.nextInt();
                            switch (opt) {
                                case 1 -> Pilha.refazer(redo, undo, listUser);
                                case 2 -> Pilha.refazer(redo, undo, listActivity);
                                case 3 -> Pilha.refazer(redo, undo, listProject);
                                default -> System.out.println("Opcao invalida!");
                            }
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;
                case 9:
                    break loop;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
    }
    @Override
    public void optMenuE(int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Activity> listActivities, MenuExt menu, MenuInt menu1) {

    }

    @Override
    public int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador) {
        return 0;
    }

    @Override
    public void login(int logged, List<DefaultUser> listUser, int identificador, List<Project> listProject, Pilha redo, Pilha undo, List<Activity> listActivity, MenuExt menu, MenuInt menu1) {

    }
}
