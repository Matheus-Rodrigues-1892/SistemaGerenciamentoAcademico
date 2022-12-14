package funcionalidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import modelos.Atividade;
import modelos.Projeto;
import modelos.Usuario;

import interfaces.UsuarioInterface;

public class Edicao extends Operacoes{

    public Edicao(List<Usuario> listUsuarios, List<Projeto> listProjetos, List<Atividade> listAtividades) {
        super(listUsuarios, listProjetos, listAtividades);
        //TODO Auto-generated constructor stub
    }

    public static void editaUsuario(Scanner input, List<Usuario> listUsuario, Pilha redo){
        Stack stack = new Stack();
        System.out.println("Selecione um usuário para editar");
        int cont = 0;
        for (Usuario usuario : listUsuario) {
            System.out.println(usuario.getNome() + " " + " " + cont++);
        }
        int num = input.nextInt();
        input.nextLine();
        System.out.printf("Usuário seleionado: %s\n", listUsuario.get(num).getNome());
        UsuarioInterface user = listUsuario.get(num);
        System.out.printf("Edit name (%s)\n", listUsuario.get(num).getNome());
        String name = input.nextLine();
        user.setNome(name);
        stack.push(user);
        redo.setPilhaRedo(stack);
    }

    public static void editaAtividade(Scanner input, List<Atividade> listAtividades, List<Usuario> listUsuarios, Pilha redo) {
        Stack<Atividade> stack = new Stack<>();
        System.out.println("Selecione uma atividade para editar");
        for (Atividade listAtv : listAtividades) {
            System.out.println(listAtv.getId() + " " + listAtv.getDescricao() + " " + listAtv.getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        Atividade atividade = listAtividades.get(numm);
        System.out.println("Escreva o nome:");
        String ident = input.nextLine();
        atividade.setIdent(ident);
        System.out.println("Escreva a descricao:");
        String descricao = input.nextLine();
        atividade.setDescricao(descricao);
        DateFormat formatter = null;
        try {
            System.out.println("Escreva a data da atividade: (dd/MM/yyyy hh:mm:ss)");
            String inicio = input.nextLine();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date datei = formatter.parse(inicio);
            atividade.setdataInicio(datei);
        } catch( ParseException e){
            System.out.println("Formato de data errado" + e.getMessage());
        }
        try {
            System.out.println("Escreva a data de término: (dd/MM/yyyy hh:mm:ss)");
            String termino = input.nextLine();
            Date datef = formatter.parse(termino);
            atividade.setDataTermino(datef);
        } catch (ParseException e){
            System.out.println("Escreva a data errada" + e.getMessage());
        }
        System.out.println("Selecione o responsavel pela atividade:");
        for (Usuario listUser : listUsuarios) {
            System.out.println(listUser.getId() + "  - " + listUser.getNome() + " ( " + " )");
        }
        int num0 = input.nextInt();
        input.nextLine();
        UsuarioInterface nomeResp = listUsuarios.get(num0);
        atividade.setResponsavel(nomeResp);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (Usuario listUser : listUsuarios) {
            System.out.println(listUser.getId() + " - " + listUser.getNome() + " ");
            cont++;
        }
        int in = 0;
        List<UsuarioInterface> listUserp = new ArrayList<>();
        while(in != cont + 1) {
            in = input.nextInt();
            input.nextLine();
            UsuarioInterface user = listUsuarios.get(in);
            listUserp.add(user);
            if (listUserp.size() == listUsuarios.size()) {
                System.out.println("Número de profisionais excedido!");
                in = cont + 1;
            }
            else{
                System.out.println("""
                        Adicionar mais um?
                        1 - Adicionar
                        2 - Não""");
                int aa = input.nextInt();
                input.nextLine();
                if (aa == 2) in = cont + 1;
                else if (aa == 1) {
                    in = 0;
                }
            }
        }
        System.out.println("digite as tarefas a serem realizadas:");
        String cargos = input.nextLine();
        atividade.setCargos(cargos);
        stack.push(atividade);
        redo.setPilhaRedo(stack);
        listAtividades.add(atividade);
    }


    public static void editProjeto(Scanner input, List<Projeto> listProjetos, List<Usuario> listUsuarios, List<Atividade> listAtividade, int identificador, Pilha redo) throws NullPointerException {
        Stack<Projeto> stack = new Stack<>();
        System.out.println("Selecione um projeto para editar");
        
        for (Projeto value : listProjetos) {
            System.out.println(value.getId() + " " + value.getDescricao() + " " + value.getId());
        }

        int numm = input.nextInt();
        input.nextLine();
        Projeto projeto = listProjetos.get(numm);
        System.out.println("Escreva o nome do projeto:");
        String ident = input.nextLine();
        projeto.setIdent(ident);

        System.out.println("Escreva a descrição do projeto");
        String descricao = input.nextLine();
        projeto.setDescricao(descricao);
        DateFormat formatter = null;
        Date datei = null;
        try {
            System.out.println("Digite a data de inicio do projeto: (dd/MM/yyyy hh:mm:ss)");
            String inicio = input.nextLine();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            datei = formatter.parse(inicio);
            projeto.setdataInicio((java.sql.Date) datei);
        } catch (ParseException e){
            System.out.println("Formato de data errada" + e.getMessage());
        }
        try{
            System.out.println("digite a data de termino do projeto: (dd/MM/yyyy hh:mm:ss)");
            String finall = input.nextLine();
            Date datef = formatter.parse(finall);
            projeto.setdataTermino((java.sql.Date) datef);
            Calendar m_calendar = Calendar.getInstance();
            m_calendar.setTime(datei);
            int nMonth1 = 12 * m_calendar.get(Calendar.YEAR)+ m_calendar.get(Calendar.MONTH);
            m_calendar.setTime(datef);
            int nMonth2 = 12*m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
            int diff = Math.abs(nMonth2 - nMonth1);
            System.out.println("Tempo: " + diff + "meses)");
            projeto.setTempo(diff);
        } catch (ParseException e){
            System.out.println("Formato de data errado" + e.getMessage());
        }
        System.out.println("Selecione o coordenador do projeto:");
        for (int i = 0; i < listUsuarios.size(); i++) {
            var type = listUsuarios.getClass();
            if (listUsuarios.get(i).getClass().equals(type)) {
                System.out.println(i + ": " + listUsuarios.get(i).getNome());
            }
        }
        int num = input.nextInt();
        input.nextLine();
        Usuario nomeCoord = listUsuarios.get(num);
        projeto.setCoordenador(nomeCoord);
        int cont = 0;
        System.out.println("Selecione os profissionais envolvidos: \n");
        for (Usuario listUser : listUsuarios) {
            System.out.println(listUser.getId() + " - " + listUser.getNome());
            cont++;
        }
        int in = 0;
        List<UsuarioInterface> listUserp = new ArrayList<>();
        while(in != cont + 1){
            in = input.nextInt();
            input.nextLine();
            UsuarioInterface user = listUsuarios.get(in);
            listUserp.add(user);
            if(listUserp.size() == listUsuarios.size()){
                System.out.println("Tamanho maximo de profissionais selecionado!");
                in = cont + 1;
            }
            System.out.println("""
                    Adicionar mais um?
                    1 - Selecionar
                    2 - Nao selecionar""");
            int aa = input.nextInt();
            input.nextLine();
            if (aa == 2) in = cont + 1;
            else if (aa == 1) {
                in = 0;
            }
        }
        try {
            System.out.println("Selecione as atividades a serem realizadas:");
            int inn = 0;
            int sizeatividade = listAtividade.size();
            List<Atividade> atividadesses = new ArrayList<>();
            while (inn != sizeatividade + 1) {
                for (Atividade listActivity : listAtividade) {
                    System.out.println(listActivity.getId() + " " + listActivity.getDescricao());
                }
                int num1 = input.nextInt();
                Atividade atividadeaux = listAtividade.get(num1);
                atividadesses.add(atividadeaux);
                if (atividadesses.size() == listAtividade.size()) {
                    inn += sizeatividade + 1;
                }
                System.out.println("""
                        Adicionar mais uma atividade?
                        1 - Selecionar
                        2 - Nao selecionar""");
                int aa = input.nextInt();
                input.nextLine();
                if (aa == 2) inn = sizeatividade + 1;
                else if (aa == 1) {
                    inn = 0;
                }
            }
            projeto.setAtividades(atividadesses);
        } catch (IllegalArgumentException e){
            System.out.println("Lista Vazia!" + " " + e.getMessage());
        }
        System.out.println("Bolsa para cada profissional");
        for (int i = 0; i < listUsuarios.size(); i++) {
            System.out.println(listUserp.get(i).getNome());
            double valor = input.nextDouble();
            input.nextLine();
            listUserp.get(i).setBolsa(valor);
        }
        System.out.println("Periodo de vigencia");
        int tempo = input.nextInt();
        input.nextLine();
        projeto.setTempo(tempo);
        LocalDate today = java.time.LocalDate.now();
        Date todayd = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        int coordopt;
        if (listUsuarios.get(identificador).equals(listProjetos.get(identificador).getCoordenador())) {
            System.out.println("Concluir projeto?" +
                    "1 - SIM\n" +
                    "2 - NAO");
            coordopt = input.nextInt();
            input.nextLine();
            if (coordopt == 1) {
                projeto.setStatus("Concluido");
                System.out.println("Concluido");
            } else if ( coordopt == 2) {
                System.out.println("Sem alteracoes!");
            }
            else System.out.println("Opcao invalida!");
        }
        stack.push(projeto);
        redo.setPilhaRedo(stack);
        listProjetos.add(projeto);
    }
}
