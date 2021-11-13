public class App {
    public static void main(String[] args) throws Exception {
        ListaEncadeada lista = new ListaEncadeada();

        System.out.println(lista);
        lista.adicionaNoComeco("Mauricio");
        System.out.println(lista);
        lista.adicionaNoComeco("Maria");
        System.out.println(lista);
        lista.adicionaNoComeco("Antonia");
        System.out.println(lista);
        lista.adiciona("Katarina");
        System.out.println(lista);
        lista.adiciona(2, "Viviane");
        System.out.println(lista);

        Object x = lista.pega(2);
        System.out.println(x);
        System.out.println(lista.tamanho());

    }
}
