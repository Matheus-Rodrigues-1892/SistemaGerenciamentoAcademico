package modelos;

import interfaces.UsuarioCoordInterface;

public class UsuarioCoord{

    public static void getUsuario(int opt){
        switch (opt) {
            case 1 -> new Usuario();
            case 2 -> new Coordenador();
            default -> System.out.println("Tipo de usuário inválido");
        }
    }
    
}
