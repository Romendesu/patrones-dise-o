package Behavioral.Command;

public class ExecuteTurnOnLight implements Command{
    // Instanciamos la clase Luz como atributo privado
    private Light light;

    // Constructor de la clase
    public ExecuteTurnOnLight(Light light) {
        this.light = light;
    }

    // Sobreescribimos el metodo para encender las luces
    @Override
    public void execute(){
        light.turnOn();
    }
}
