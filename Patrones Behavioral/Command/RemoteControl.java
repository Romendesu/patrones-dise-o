package Behavioral.Command;

/*
*  Clase "Invocador"
*  La clase no sabe absolutamente nada sobre la luz y sus comandos, solo ejecuta las instrucciones.
*/
public class RemoteControl {
    private Command command;

    // Constructor de la clase
    public void setCommand(Command command) {
        this.command = command;
    }

    // Metodo publico que ejecuta la instruccion de encendido y apagado
    public void pressButton() {
        command.execute();
    }
}
