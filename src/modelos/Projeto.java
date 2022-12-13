package modelos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Projeto {

    protected String ident;
    protected String descricao;
    protected Date dataInicio;
    protected Date dataTermino;
    protected Usuario responsavel;
    protected int id;
    protected int tempo;
    protected String status;
    protected Usuario coordenador;
    private String cargos;
    private List<Atividade> atividades;
    private List<Usuario> profissionais;

    private Projeto(){
        this.responsavel = new Usuario();
        this.coordenador = new Coordenador();
        this.atividades = new ArrayList<>();
        this.profissionais = new ArrayList<>();
    }

    public static Projeto criarProjeto() {
        return new Projeto();
    }


    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setatividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }


    public Usuario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Usuario coordenador) {
        this.coordenador = coordenador;
    }
    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getDesc() {
        return descricao;
    }

    public void setDesc(String descricao) {
        this.descricao = descricao;
    }

    public Date getdataInicio() {
        return dataInicio;
    }

    public void setdataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getdataTermino() {
        return dataTermino;
    }

    public void setdataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Usuario> getProfissionais() {
        return profissionais;
    }

    public void setProfs(ArrayList<Usuario> profissionais) {
        this.profissionais = profissionais;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }
}