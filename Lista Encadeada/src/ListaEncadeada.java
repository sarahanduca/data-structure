public class ListaEncadeada {
    private Celula primeira = null;
    private Celula ultima  = null;
    private int totalElementos = 0;
    public void adicionaNoComeco(Object elemento){
        Celula nova = new Celula(elemento, primeira);
        this.primeira = nova;

        if(this.totalElementos == 0){
            this.ultima = this.primeira;
        }

        this.totalElementos++;
    }
    @Override
    public String toString() {
        if(this.totalElementos == 0){
            return "[]";
        }
        Celula atual = primeira;
        StringBuilder builder = new StringBuilder("[");
        for(int i = 0; i < totalElementos; i++){
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProx();
        }
        builder.append("]");

        return builder.toString();
    }
    public void adiciona(Object elemento){
        if(this.totalElementos == 0){
            adicionaNoComeco(elemento);
        }else{
            Celula nova = new Celula(elemento, null);
            this.ultima.setProx(nova);
            this.ultima = nova;
            this.totalElementos++;
        }
    }

    private boolean posicaoOcupada(int posicao){
       return posicao >= 0 && posicao < this.totalElementos;
    }

    private Celula pegaCelula(int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inexistente");
        }
        Celula atual = primeira;

        for(int i = 0; i < posicao; i++){
            atual = atual.getProx();
        }
        return atual;
    }
    public void adiciona(int posicao, Object elemento){
        if(posicao == 0){
            adicionaNoComeco(elemento);
        }else if(posicao == this.totalElementos){
            adiciona(elemento);
        }else{
            Celula anterior = this.pegaCelula( posicao - 1 );
            Celula nova = new Celula(elemento, anterior.getProx());
            anterior.setProx(nova);
            this.totalElementos++;
        }
    }

    public void removeDoComeco(){ 
        if(this.totalElementos == 0){
            throw new IllegalArgumentException("Lista vazia");
        }

        this.primeira = this.primeira.getProx();
        this.totalElementos--;
        if(this.totalElementos == 0){
            this.ultima = null;
        }
    }

    public void remove(int posicao){
        if(this.totalElementos == 0 || posicao > totalElementos){
            throw new IllegalArgumentException("Remoção inválida");
        }else if(posicao == 0){
            removeDoComeco();
        }else if(posicao == this.totalElementos){
            Celula anterior = this.pegaCelula(posicao - 1);
            anterior.setProx(null);
            this.ultima = anterior;
        }else{
            Celula anterior = this.pegaCelula(posicao - 1);
            anterior.setProx(this.pegaCelula(posicao).getProx());
            totalElementos--;
        }
    }
    
    public Object pega(int posicao){return this.pegaCelula(posicao).getElemento();}

    public int tamanho(){ return this.totalElementos;}

    public boolean contem(Object o){return false;}
}
