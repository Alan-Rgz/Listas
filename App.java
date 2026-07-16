public class App {
    public static void main(String[] args) throws Exception {
      //Pruebas de metodos arraylists
      ArrayList<String> Lista= new ArrayList<>();
      //cuando no hay nada de nada
        System.out.println("¿La lista esta vacia? "+ Lista.esVacia());
        System.out.println("¿Cuantos elementos hay en la lista: "+Lista.numElementos());
        //agregar elementos a la lista 
        Lista.agregarElemento("Azul");
        Lista.agregarInicio("Amarillo");
        Lista.agregarFinal("Rojo");
        Lista.agregarPosicion("Rosa", 2);

        //ver que hay en la lista y consultar elemento en especifico
        System.out.println("==========LISTA===========");
        System.out.println("¿La lista esta vacia? "+Lista.esVacia());
        System.out.println("Numero de elementos: "+Lista.numElementos());
        System.out.println("Posicion 2: "+Lista.consultar(2));
        System.out.println("Posicion 3: "+Lista.consultar(3));

        //Eliminacion de elementos
        System.out.println("Eliminar Elementos ");
        String eliminarInicio = Lista.eliminarElementoInicio();
        System.out.println("Eliminar el inicio "+eliminarInicio);
        String eliminarFinal = Lista.eliminarElementoFinal();
        System.out.println("Eliminar el inicio "+eliminarFinal);
        String eliminarPosicion = Lista.eliminarElementoPosicion(1);
        System.out.println("Eliminar el inicio "+eliminarPosicion);

        //convertir a arreglo
        System.out.println("Convertir el arreglo");
        Object[] arreglo = Lista.convertirArreglo();
        System.out.println("¿Cual es el tamaño del arreglo? " + arreglo.length);
        System.out.println("Imprimir lo que hay en el arreglo");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }
}
