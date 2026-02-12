package Behavioral.Iterator;

public class NumberList implements Colection{

    private int[] numbers;

    // Constructor de la clase
    public NumberList(int[] numbers) {
        this.numbers = numbers;
    }

    // Metodo para obtener los numeros de la lista
    public int[] getNumbers(){
        return numbers;
    }

    @Override
    public Iterator createIterator(){
        return new IteratorList(this);
    }
}
