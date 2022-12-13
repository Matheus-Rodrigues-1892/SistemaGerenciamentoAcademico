package funcionalidades;

import java.util.ArrayList;
import java.util.List;


import modelos.Atividade;
import modelos.Coordenador;
import modelos.Projeto;
import modelos.Usuario;

public class Pesquisa extends Operacoes{

    public Pesquisa(ArrayList<Usuario> listUsuarios, ArrayList<Projeto> listProjetos,
            ArrayList<Atividade> listAtividades) {
        super(listUsuarios, listProjetos, listAtividades);
        //TODO Auto-generated constructor stub
    }

    public static void consultaAtv(List<Atividade> listAtividades){
        try{
            for (Atividade atividade : listAtividades){
                System.out.println(atividade.getId() + " " + atividade.getDescricao());

            }

        } catch (IllegalArgumentException e){
            System.out.println("Sem atividades");
        }
        
    }

    public static void consultaProj(List<Projeto> listProjetos){
        try{
            for (Projeto projeto : listProjetos){
                System.out.println(projeto.getId());
                System.out.println(projeto.getDescricao());

            }

        } catch (IllegalArgumentException e){
            System.out.println("Sem projetos");
        }
        
    }

    public static void consultaUsuario(List<Usuario> listUsuarios){
        try{
            for (Usuario usuario : listUsuarios){
                System.out.println(usuario.getNome());
                System.out.println(usuario.getClass().toString());

            }

        } catch (IllegalArgumentException e){
            System.out.println("Sem usuários");
        }
        
    }

    public static void consultaUser(List<Usuario> listUsuarios, Coordenador coordenador) {
        try {

            var type = coordenador.getClass();
            for (int i = 0; i <listUsuarios.size(); i++) {

                if (listUsuarios.get(i).getClass().equals(type)) {

                    System.out.println(i +listUsuarios.get(i).getNome());
                    System.out.println("Coordenador");

                }
            }
        } catch (IllegalArgumentException e){
            System.out.println("Lista de Coordenadores vazia!");
        }
    }


    
}
