public class Celula {
    private Object elemento;
    private Celula prox;

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
}
