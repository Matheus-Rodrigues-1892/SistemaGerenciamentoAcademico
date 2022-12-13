import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    protected String nome;
    protected String login, senha;
    protected int id;
    Usuario() {

    }

    public static Usuario criarUsuario() {
        return new Usuario();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int getBolsa() {
        return 1;
    }

    @Override
    public void setBolsa(double bolsa) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    public String getName() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }


    public void consultaUsuario(){
        System.out.println(this.nome + login);
    }

    public Usuario addName(String nome){
        this.nome = nome;
        return this;
    }

    public Usuario addLogin(String login){
        this.login = login;
        return this;
    }

    public void addSenha(String senha){
        this.senha = senha;
    }

    public Usuario addId(int id){
        this.id = id;
        return this;
    }

    public void changePass(ArrayList<Usuario> listUsuario, int identificador, String senha){
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Qual a nova senha?");
            for (Usuario Usuario : listUsuario) {
                if (Usuario.getId() == identificador) {
                    senha = input.nextLine();
                    Usuario.setSenha(senha);
                }
            }
            System.out.println("Alteração realizada!");
        } catch (IllegalArgumentException e){
            System.out.println("Lista Vazia!");
        }
    }

}
