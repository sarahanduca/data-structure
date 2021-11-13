public class App {
    public static void main(String[] args) throws Exception {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

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
        lista.removeDoComeco();
        System.out.println(lista);
        lista.remove(0);
        System.out.println(lista);
        lista.adicionaNoComeco("José");
        System.out.println(lista);
        lista.adiciona(2, "Nina");
        System.out.println(lista);
        lista.remove(3);
        System.out.println(lista);
        lista.adiciona("Talio");
        System.out.println(lista);



        Object x = lista.pega(2);
        System.out.println(x);
        System.out.println(lista.tamanho());
    }
}
