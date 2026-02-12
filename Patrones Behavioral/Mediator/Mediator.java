package Behavioral.Mediator;

// Metodos que tiene el mediador
public interface Mediator {
    public void sendMessage(String message, User user);
    public void addNewUser(User user);
}
