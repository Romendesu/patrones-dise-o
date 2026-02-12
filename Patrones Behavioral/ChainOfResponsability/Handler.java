package Behavioral.ChainOfResponsability;

// Clase abstracta para manejar peticiones
abstract class Handler {
    // Atributos de la clase abstracta
    protected Handler next;
    protected abstract boolean canHandle(int quantity);
    protected abstract void process(int quantity);

    // Establecemos el siguiente objetivo
    public void setNext(Handler next) {
        this.next = next;
    }

    // Metodo para manejar a los clientes
    public void handle(int quantity) {
        if (canHandle(quantity)) {
            process(quantity);
        } else if (next != null) {
            next.handle(quantity);
        } else {
            System.out.println("Nadie puede manejar");
        }
    }


}
