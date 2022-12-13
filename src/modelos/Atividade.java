package modelos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.UsuarioInterface;

public class Atividade {
    private Atividade(){
        this.responsavel = new Usuario();
        this.profissionais = new ArrayList<>();
    }
    public static Atividade criarAtividade() {
        return new Atividade();
    }

    private String ident;
    private String descricao;
    private Date dataInicio;
    private Date dataTermino;
    private UsuarioInterface responsavel;
    private int id;
    private List<UsuarioInterface> profissionais;
    private String cargos;



    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setdataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public UsuarioInterface getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(UsuarioInterface responsavel) {
        this.responsavel = responsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UsuarioInterface> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<UsuarioInterface> profissionais) {
        this.profissionais = profissionais;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

}
