import java.util.List;
import java.util.Stack;

public class Pilha extends Operacoes{

    private Stack pilhaUndo;
    private Stack pilhaRedo;
    
    public Stack getPilhaUndo() {
        return pilhaUndo;
    }
    public void setPilhaUndo(Stack pilhaUndo) {
        this.pilhaUndo = pilhaUndo;
    }
    public Stack getPilhaRedo() {
        return pilhaRedo;
    }
    public void setPilhaRedo(Stack pilhaRedo) {
        this.pilhaRedo = pilhaRedo;
    }

    public static void undo  (Pilha operacaoUndo, Pilha operacaoRedo, List padrao) {

        try {
            Stack pilha;
    
            pilha = operacaoUndo.getPilhaRedo();
    
            operacaoRedo.setPilhaUndo(operacaoUndo.getPilhaRedo());
    
            var retirado = pilha.peek();
            pilha.pop();
    
            operacaoUndo.setPilhaRedo(pilha);
    
            if(padrao.contains(retirado)){
                padrao.remove(retirado);
            } else{
                padrao.add(retirado);
            }

        } catch(IllegalArgumentException e){
            System.out.println("Empty list!");
        }


    }

    public static void redo(Pilha undo, Pilha redo, List padrao){
        try {
            Stack pilha;

            pilha = undo.getPilhaRedo();

            pilha.push(redo.getPilhaRedo());

            undo.setPilhaRedo(pilha);

            var retirado = pilha.peek();

            if (padrao.contains(retirado)) {
                padrao.remove(retirado);
            } else {
                padrao.add(retirado);
            }
        } catch (IllegalArgumentException e ){
            System.out.println("Empty list!");
        }
    }

}
