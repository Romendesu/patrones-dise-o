package Behavioral.Mediator;

public class Main {
    public static void main(String[] args) {

        Mediator chat = new ChatMediator();

        User u1 = new ConcreteUser(chat, "Ana");
        User u2 = new ConcreteUser(chat, "Luis");
        User u3 = new ConcreteUser(chat, "Marta");

        chat.addNewUser(u1);
        chat.addNewUser(u2);
        chat.addNewUser(u3);

        System.out.println("Enviando un mensaje de bienvenida por parte del Usuario 1");
        u1.send("Hola a todos");
    }
}
