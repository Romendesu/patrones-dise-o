package Behavioral.Iterator;

public class Main {
    public static void main(String[] args){
        // Datos que vamos a emplear (SOLO MANEJA ENTEROS)
        int[] data = {1,2,3,4};

        // Creamos la coleccion de datos y el iterador
        NumberList list = new NumberList(data);
        Iterator iterator = list.createIterator();

        // Mostramos la iteracion
        System.out.println("Iterando la coleccion de elementos");
        while(iterator.hasNext()){
            System.out.print("Mostrando el elemento: "+iterator.next() + ".");
            System.out.println(" ¿Tiene siguiente elemento? "+ iterator.hasNext() + "\n");
        }
        System.out.println("Ya se han mostrado todos los elementos.");
    }
}
