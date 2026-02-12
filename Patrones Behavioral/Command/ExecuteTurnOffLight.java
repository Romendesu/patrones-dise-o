package Behavioral.Command;

public class ExecuteTurnOffLight implements Command{
    // Instanciamos la clase Luz como atributo privado
    private Light light;

    // Constructor de la clase
    public ExecuteTurnOffLight(Light light) {
        this.light = light;
    }

    // Sobreescribimos el metodo para apagar las luces
    @Override
    public void execute() {
        light.turnOff();
    }
}
