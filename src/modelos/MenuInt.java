package modelos;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import funcionalidades.Adicao;
import funcionalidades.Edicao;
import funcionalidades.Pesquisa;
import funcionalidades.Pilha;
import funcionalidades.Relatorio;
import interfaces.Menu;
import funcionalidades.Remocao;

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
    
    public void operacaoUndo(){
        System.out.println("""
                DESFAZER:
                1 - Usuario
                2 - Atividade
                3 - Projeto""");
    }


    public MenuInt() {

    }

    public void optMenuI(Scanner input, List<Usuario> listUsuario, int identificador, String senha, int logged, List<Projeto> listProjeto, Pilha redo, List<Atividade> listAtividade, Pilha undo) throws ParseException, NumberFormatException, NullPointerException, InputMismatchException {
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
                        case 1 -> Adicao.adicionaUsuario(input, listUsuario, redo);
                        case 2 -> Edicao.editaUsuario(input, listUsuario, redo);
                        case 3 -> Remocao.RemoveUsuario(input, listUsuario, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 2:
                    atividades();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Adicao.adicionaAtividade(input, listAtividade, listUsuario, redo);
                        case 2 -> Edicao.editaAtividade(input, listAtividade, listUsuario, redo);
                        case 3 -> Remocao.RemoveAtv(input, listAtividade, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 3:
                    projetos();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Adicao.adicionaProjeto(input,listProjeto, listUsuario, listAtividade, identificador, redo);
                        case 2 -> Edicao.editProjeto(input, listProjeto, listUsuario, listAtividade, identificador, redo);
                        case 3 -> Remocao.RemoveProj(input, listProjeto, redo);
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
                                case 1 -> Pesquisa.consultaUser(listUsuario, coordenador);
                                case 2 -> Pesquisa.consultaUsuario(listUsuario);
                                default -> System.out.println("Opcao invalida!");
                            }
                        case 2:
                            Pesquisa.consultaAtv(listAtividade);
                            break;
                        case 3:
                            Pesquisa.consultaProj(listProjeto);
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;
                case 5:
                    user.alterar(listUsuario, identificador, senha);
                    break;
                case 6:
                    relatorio();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Relatorio.projetoRelatorio(listProjeto);
                        case 2 -> Relatorio.atividadeRelatorio(listAtividade);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 7:
                    Bolsa.gerenciamento(listProjeto);
                    break;
                case 8:
                    acoes();
                    option = input.nextInt();
                    switch (option) {
                        case 1:
                            operacaoUndo();
                            opt = input.nextInt();
                            switch (opt) {
                                case 1 -> Pilha.opDesfazer(redo, undo, listUsuario);
                                case 2 -> Pilha.opDesfazer(redo, undo, listAtividade);
                                case 3 -> Pilha.opDesfazer(redo, undo, listProjeto);
                                default -> System.out.println("Opcao invalida!");
                            }
                            break;
                        case 2:
                            operacaoRedo();
                            opt = input.nextInt();
                            switch (opt) {
                                case 1 -> Pilha.opRefazer(redo, undo, listUsuario);
                                case 2 -> Pilha.opRefazer(redo, undo, listAtividade);
                                case 3 -> Pilha.opRefazer(redo, undo, listProjeto);
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
    
    public void optMenuE(int logged, List<Usuario> listUsuario, int identificador, Pilha redo, Pilha undo, List<Projeto> listProjeto, List<Atividade> listAtividade, MenuExt menu, MenuInt menu1) {

    }

    @Override
    public int isLogged(int logged, List<Usuario> listUsuario, String login, String senha, int identificador) {
        return 0;
    }

    
    public void login(int logged, List<Usuario> listUsuario, int identificador, List<Projeto> listProjeto, Pilha redo, Pilha undo, List<Atividade> listAtividade, MenuExt menu, MenuInt menu1) {

    }
    @Override
    public void menuE(int logged, List<Usuario> listUsuarios, int id, Pilha operacaoRedo, Pilha operacaoUndo,
            List<Projeto> listProjetos, List<Atividade> listAtividades, MenuExt menu, MenuInt menu1)
            throws ParseException {
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
            List<Projeto> listProjetos, Pilha operacaoRedo, List<Atividade> listAtividades, Pilha operacaoUndo)
            throws ParseException {
        // TODO Auto-generated method stub
        
    }
}
