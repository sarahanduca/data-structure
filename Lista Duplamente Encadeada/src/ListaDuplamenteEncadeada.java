public class ListaDuplamenteEncadeada {
    private Celula primeira = null;
    private Celula ultima  = null;
    private int totalElementos = 0;

    public void adicionaNoComeco(Object elemento){
       if(this.totalElementos == 0){
           Celula nova = Celula(elemento);
           this.primeira = nova;
           this.ultima = nova;
       }else{
           Celula nova = Celula(elemento, this.primeira);
           this.primeira.setAnterior(nova);
           this.primeira = nova;
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
            builder.append(" -> ");

            atual = atual.getProx();
        }
        builder.append("]");

        return builder.toString();
    }

    public void adiciona(Object elemento){
        if(this.totalElementos == 0){
            adicionaNoComeco(elemento);
        }else{
            Celula nova = Celula(elemento);
            nova.setAnterior(this.ultima);
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
            Celula anterior = pegaCelula(posicao).getAnterior();
            Celula nova = Celula(elemento, anterior.getProx());
            Celula prox = anterior.getProx();
            prox.setAnterior(nova);
            nova.setAnterior(anterior);
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
            this.removeDoComeco();
        }else if(posicao == this.totalElementos){
            this.removeDoFim();
        }else{
            Celula anterior = pegaCelula(posicao-1);
            Celula elementoParaRemover = anterior.getProx();
            Celula prox = elementoParaRemover.getProx();
            anterior.setProx(prox);
            prox.setAnterior(anterior);

            this.totalElementos--;
        }
    }

    public void removeDoFim(){
        if(this.totalElementos == 1){
            this.removeDoComeco();
        }
        Celula penultimoElemento = this.ultima.getAnterior();
        penultimoElemento.setProx(null);
        this.ultima = penultimoElemento;
        this.totalElementos--;
    }
    
    public Object pega(int posicao){return this.pegaCelula(posicao).getElemento();}

    public int tamanho(){ return this.totalElementos;}

    public boolean contem(Object elemento){
        Celula atual = this.primeira;

        while(atual != null){
            if(atual.getElemento() == elemento){
                return true;
            }
            atual = atual.getProx();
        }

        return false;
    }
    
}
