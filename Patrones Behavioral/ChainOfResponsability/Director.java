package Behavioral.ChainOfResponsability;

public class Director extends Handler{
    @Override
    protected boolean canHandle(int quantity) {
        return (quantity < 1000);
    }

    @Override
    protected void process(int quantity) {
        System.out.println("El director aprobó el gasto de: "+quantity+"€.");
    }
}
