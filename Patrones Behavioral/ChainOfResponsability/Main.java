package Behavioral.ChainOfResponsability;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Creamos los handler
        Director director = new Director();
        Employee employee = new Employee();

        // Construimos la cadena
        employee.setNext(director);

        // Variables clave en el programa
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;

        // Bucle principal del programa
        while (isRunning) {

            System.out.println("Bienvenido a la oficina");
            System.out.println("Ingrese el numero de gastos:");
            int indexCosts = scan.nextInt();
            int[] costs = new int[indexCosts];

            // Añadimos costes al array
            for (int i = 0; i < indexCosts; i++) {
                System.out.println("Ingresa el coste numero: " + (i + 1));
                costs[i] = scan.nextInt();
            }

            System.out.println("Costes añadidos: " + Arrays.toString(costs));
            System.out.println("Procesando gastos...\n");

            // Manejo de costes empleando Chain of Responsability
            for (int c : costs) {
                /*
                * Se llama siempre al primer handler.
                * Si el primer handler no puede procesar el gasto, se llama al siguiente
                * Asi ocurre con todos los handler
                */
                employee.handle(c);
            }

            System.out.println("\nDesea continuar:\n1. Si\n2. No");
            int option = scan.nextInt();
            isRunning = (option == 1);
        }

        scan.close();
    }
}
