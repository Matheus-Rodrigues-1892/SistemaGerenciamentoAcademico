package modelos;

public class Coordenador extends Usuario {
    public Coordenador(){
        super();
    }
    @Override
    public String toString(){
        return this.getNome();
    }
}

/*Esta é uma classe que herda da classe Usuario*/
