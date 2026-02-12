package Behavioral.ChainOfResponsability;

public class Employee extends Handler {
    @Override
    protected boolean canHandle(int quantity) {
        return (quantity < 100);
    }

    @Override
    protected void process(int quantity) {
        System.out.println("El empleado aprobó el gasto de: "+quantity+"€.");
    }
}
