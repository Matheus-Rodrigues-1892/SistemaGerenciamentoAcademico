package interfaces;

import modelos.Usuario;

import java.util.List;

public interface UsuarioInterface {

    String getNome();

    void setNome(String nome);

    int getBolsa();

    void setBolsa(double bolsa);
    
    int getId();

    void setId(int id);
    
    Usuario addId(int id);
    
    void alterar(List<Usuario> listUsuarios, int identif, String senha);

    void consultaUsuario();

    String getSenha();

    void setSenha(String senha);

    Usuario addNome(String nome);

    Usuario addLogin(String login);

    void addSenha(String senha);

}
