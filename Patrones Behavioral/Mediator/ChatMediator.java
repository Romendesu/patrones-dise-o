package Behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

// Mediador concreto
public class ChatMediator implements Mediator{

    // Array mutable de usuarios
    private List<User> users = new ArrayList<>();

    // Metodo para agregar usuarios
    @Override
    public void addNewUser(User user){
        users.add(user);
        System.out.println("Usuario nuevo agregado!!");
    }

    // Metodo para enviar mensajes
    @Override
    public void sendMessage(String message, User emisor) {
        for (User u: users){
            u.receive(message);
            System.out.println("Se ha recibido el mensaje, pasando con el siguiente usuario");
        }
    }
}
