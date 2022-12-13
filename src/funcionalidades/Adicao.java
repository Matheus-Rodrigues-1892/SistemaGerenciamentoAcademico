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
import modelos.Coordenador;
import modelos.Projeto;
import modelos.Usuario;
import modelos.UsuarioCoord;
import interfaces.*;

public class Adicao extends Operacoes{

    public Adicao(List<Usuario> listUsuarios, List<Projeto> listProjetos, List<Atividade> listAtividades) {
        super(listUsuarios, listProjetos, listAtividades);
        //TODO Auto-generated constructor stub
    }

    private static void stringExtract(String x) {
        System.out.println(x);
    }

    private static String getString(Scanner input) {
        return input.nextLine();
    }

    public static void adicionaUsuario(Scanner input, List<Usuario> listUsuarios, Pilha redo){
        Usuario usuario = Usuario.criarUsuario();

        Stack<Usuario> stack = new Stack<>();

        stringExtract("""
                Usuario coordenador(Professor ou pesquisador)?
                1 - Sim:
                2 - Nao""");
                
        int aux = input.nextInt();

        input.nextLine();

        UsuarioCoord.getUsuario(aux);

        stringExtract("Digite o nome:");
        String name = getString(input);
        //user.setName(name);

        int size = listUsuarios.size();
        //user.setId(size);
        stringExtract("Digite o login:");
        String login = getString(input);
        //user.setLogin(login);
        stringExtract("Digite a senha:");
        String password = getString(input);
        //user.setPassword(password);

        usuario .addNome(name)
             .addId(size)
             .addLogin(login)
             .addSenha(password);

        stack.push(usuario);
        redo.setPilhaRedo(stack);
        listUsuarios.add(usuario);
    }


    public static void adicionaAtividade(Scanner input, List<Atividade> listAtividades, List<Usuario> listUsuarios, Pilha redo) {
        Stack<Atividade> stack = new Stack<>();

        Atividade atividade = Atividade.criarAtividade();
        input.nextLine();

        stringExtract("Digite o nome da activity:");
        String ident = getString(input);
        atividade.setIdent(ident);

        stringExtract("Digite a descricao da activity:");
        String desc = getString(input);
        atividade.setDescricao(desc);

        DateFormat formatter = null;
        try {
            stringExtract("Digite a data de inicio da activity: (dd/MM/yyyy hh:mm:ss)");
            String inicio = getString(input);
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dateI = formatter.parse(inicio);
            atividade.setdataInicio(dateI);
        } catch( ParseException e){
            stringExtract("Formato de data errado" + e.getMessage());
        }
        try {
            stringExtract("digite a data de termino da activity: (dd/MM/yyyy hh:mm:ss)");
            String finall = getString(input);
            Date datef = formatter.parse(finall);
            atividade.setDataTermino(datef);
        } catch (ParseException e){
            stringExtract("Formato de data errado" + e.getMessage());
        }

        stringExtract("Selecione o responsavel pela Activity:");
        for (Usuario usuario : listUsuarios) {
            stringExtract(usuario.getId() + "  - " + usuario.getNome());
        }
        int num0 = input.nextInt();
        input.nextLine();
        UsuarioInterface nomeResp = listUsuarios.get(num0);
        atividade.setResponsavel(nomeResp);
        int cont = 0;
        stringExtract("selecione os profissionais envolvidos: \n");
        for (Usuario listUser : listUsuarios) {
            stringExtract(listUser.getId() + " - " + listUser.getNome() + " ");
            cont++;
        }
        int in = 0;
        List<UsuarioInterface> listUserp = new ArrayList<>();
        while(in != cont + 1) {
            in = input.nextInt();
            input.nextLine();
            Usuario usuario = listUsuarios.get(in);
            listUserp.add(usuario);
            if (listUserp.size() == listUsuarios.size()) {
                stringExtract("Tamanho maximo de profissionais selecionado!");
                in += cont + 1;
            }
            else{
                stringExtract("""
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
        }
        atividade.setProfissionais(listUserp);

        stringExtract("digite as tarefas a serem realizadas:");
        
        String cargos = getString(input);

        atividade.setCargos(cargos);

        int size = listAtividades.size();

        atividade.setId(size);

        stack.push(atividade);

        redo.setPilhaRedo(stack);

        listAtividades.add(atividade);
    }

    //----------------------------------------------------------------------------------

    public static void adicionaProjeto(Scanner input, List<Projeto> listProjetos, List<Usuario> listUsuarios, List<Atividade> listAtividades, int identificador, Pilha redo) {
        Stack<Projeto> stack = new Stack<>();
        var type = Coordenador.class;
        input.nextLine();

        if(listUsuarios.get(identificador).getClass().equals(type)) {
            Projeto projeto = Projeto.criarProjeto();

            projeto.setStatus("Em processo de criacao");

            stringExtract("Digite o nome do Projeto:");
            String ident = getString(input);
            projeto.setIdent(ident);

            stringExtract("Digite a descricao do Projeto:");
            String desc = getString(input);
            projeto.setDescricao(desc);

            DateFormat formatter = null;
            Date datei = null;
            try {
                stringExtract("Digite a data de inicio do projeto: (dd/MM/yyyy hh:mm:ss)");
                String inicio = getString(input);
                formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                datei = formatter.parse(inicio);
                projeto.setdataInicio(datei);
            } catch (ParseException e){
                stringExtract("Formato errado de data" + e.getMessage());
            }
            try{
                stringExtract("digite a data de termino do projeto: (dd/MM/yyyy hh:mm:ss)");
                String termino = getString(input);
                Date datef = formatter.parse(termino);
                projeto.setdataTermino(datef);

                Calendar m_calendar = getCalendar();
                setFormatDate(datei, m_calendar);

                int nMonth1 = 12 * m_calendar.get(Calendar.YEAR)+ m_calendar.get(Calendar.MONTH);
                setFormatDate(datef, m_calendar);
                int nMonth2 = 12*m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
                int diff = Math.abs(nMonth2 - nMonth1);
                stringExtract("Tempo: " + diff + "meses)");
                projeto.setTempo(diff);
            } catch (ParseException e){
                stringExtract("Formato errado de data" + e.getMessage());
            }

            stringExtract("Selecione o coordenador do projeto:");
            for (int i = 0; i < listUsuarios.size(); i++) {
                if (listUsuarios.get(i).getClass().equals(type)) {
                    stringExtract(i + " - " + listUsuarios.get(i).getNome() + " " + listUsuarios.get(i).getClass().toString());
                }
            }
            int num = input.nextInt();
            input.nextLine();
            Usuario nomeCoord =  listUsuarios.get(num);
            projeto.setCoordenador(nomeCoord);
            int cont = 0;
            stringExtract("selecione os profissionais envolvidos: \n");
            for (Usuario listUser : listUsuarios) {
                stringExtract(listUser.getId() + " - " + listUser.getNome() + " ");
                cont++;
            }
            int in = 0;
            List<Usuario> listUserp = new ArrayList<>();
            while (in != cont + 1) {
                in = input.nextInt();
                input.nextLine();
                Usuario user = listUsuarios.get(in);
                listUserp.add(user);
                if (listUserp.size() == listUsuarios.size()) {
                    stringExtract("Tamanho maximo de profissionais selecionado!");
                    in += cont + 1;
                    break;
                }
                stringExtract("""
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

            projeto.setProfissionais(listUserp);
            try {
                stringExtract("Selecione as atividades a serem realizadas:");
                int inn = 0;
                int sizeAtividade = listAtividades.size();
                List<Atividade> atividadesses = new ArrayList<>();
                while (inn != sizeAtividade + 1) {
                    for (Atividade listAtv : listAtividades) {
                        stringExtract(listAtv.getId() + " " + listAtv.getDescricao());
                    }
                    int num1 = input.nextInt();
                    Atividade atividadeaux = listAtividades.get(num1);
                    atividadesses.add(atividadeaux);
                    if (atividadesses.size() == listAtividades.size()) {
                        inn += sizeAtividade + 1;
                    }
                    stringExtract("""
                            Adicionar mais uma activity?
                            1 - Selecionar
                            2 - Nao selecionar""");
                    int aa = input.nextInt();
                    input.nextLine();
                    if (aa == 2) inn = sizeAtividade + 1;
                    else if (aa == 1) {
                        inn = 0;
                    }
                }
                projeto.setAtividades(atividadesses);
            } catch (IllegalArgumentException e){
                stringExtract("Lista de atividades vazia!" + " " + e.getMessage());
            }
            stringExtract("Bolsa para cada profissional");
            for (int i = 0; i < listUsuarios.size(); i++) {
                stringExtract(listUserp.get(i).getNome() + " ");
                double valor = input.nextDouble();
                input.nextLine();
                listUserp.get(i).setBolsa(valor);
            }
            projeto.setStatus("Iniciado");
            LocalDate today = LocalDate.now();
            Date todayd = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
            int coordopt;
            stringExtract("Iniciar projeto?" +
                    "1 - SIM\n" +
                    "2 - NAO");
            coordopt = input.nextInt();
            input.nextLine();
            if(coordopt == 1) {
                if((projeto.getdataInicio().after(todayd))){
                    projeto.setStatus("Em andamento");
                }
            } else if (coordopt == 2) {
                projeto.setStatus("Iniciado");
            }
            else stringExtract("Opcao Invalida!");
            stack.push(projeto);
            redo.setPilhaRedo(stack);
            listProjetos.add(projeto);
        }
        else{
            stringExtract("Voce nao tem permissao para isso!");
        }
    }
    
    //----------------------------------------------------------------------------------

    private static void setFormatDate(Date date, Calendar m_calendar) {
        m_calendar.setTime(date);
    }

    private static Calendar getCalendar() {
        return Calendar.getInstance();
    }
}
