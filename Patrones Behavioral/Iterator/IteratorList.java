package Behavioral.Iterator;

public class IteratorList implements Iterator {
    private NumberList numberList;
    private int pos = 0;

    public IteratorList(NumberList numberList){
        this.numberList = numberList;
    }

    // Metodo para comprobar si hay mas elementos
    @Override
    public boolean hasNext(){
        return pos<numberList.getNumbers().length;
    }

    // Metodo para obtener el siguiente elemento de la lista
    @Override
    public int next(){
        return numberList.getNumbers()[pos++];
    }
}
