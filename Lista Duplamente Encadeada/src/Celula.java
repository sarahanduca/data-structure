public class Celula {
    private Object elemento;

    private Celula anterior;
    private Celula prox;

    public Celula(Object elemento) {
        this(elemento, null);
    }
    public Celula(Object elemento, Celula prox) {
        this.elemento = elemento;
        this.prox = prox;
    }

    public Object getElemento() {
        return elemento;
    }

    public Celula getProx() {
        return prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior){
        this.anterior = anterior;
    }
}
