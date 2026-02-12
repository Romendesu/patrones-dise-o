package Behavioral.Command;

public class Main {
    public static void main(String[] args) {
        // Clases implementadas en el programa
        Light light = new Light();
        Command turnLightOn = new ExecuteTurnOnLight(light);
        Command turnLightOff = new ExecuteTurnOffLight(light);
        RemoteControl remoteControl = new RemoteControl();

        // Mensaje de introduccion
        System.out.println("Implementacion del patron de diseño Command encendiendo y apagando luces.");

        // Encendemos la luz con el control remoto
        remoteControl.setCommand(turnLightOn);
        remoteControl.pressButton();

        // Apagamos la luz con el control remoto
        remoteControl.setCommand(turnLightOff);
        remoteControl.pressButton();
    }
}
