public class Main {
    public static void main(String[] args) {
        ListaVinculada listaVinculada = new ListaVinculada();

        System.out.println("Esta vacio: " + listaVinculada.estaVacia());


        listaVinculada.add(6);
        listaVinculada.add(5);
        listaVinculada.add(4);
        listaVinculada.add(3);
        listaVinculada.add(2);
        listaVinculada.add(1);

        Integer valor = 1;
        for (Comparable lista:listaVinculada){
            System.out.println(lista);
        }
        System.out.println("----------");
        listaVinculada.removeAllElements(valor);
        for (int i = 0;i < listaVinculada.size();i++){
            System.out.println(listaVinculada.get(i));
        }
        System.out.println("Esta vacio: " + listaVinculada.estaVacia());
    }
}
