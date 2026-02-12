package Behavioral.Mediator;

public abstract class User{
    protected Mediator mediator;
    protected String name;

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message){
        System.out.println(name + " Received: " + message);
    }

}
