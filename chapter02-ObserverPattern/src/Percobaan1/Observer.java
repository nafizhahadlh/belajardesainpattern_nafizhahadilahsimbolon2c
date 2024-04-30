package Percobaan1;

import java.util.ArrayList;

interface Observer {
    void receiveNotification(String msg);
}

interface Observable {
    void addSubscriber(User user);
    void removeSubscriber(User user);
    void notifyUser(String msg);
}

class User implements Observer {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receiveNotification(String msg) {
        System.out.println(msg);
    }

    public void subscribe(Channel channel) {
        channel.addSubscriber(this);
    }

    public void unsubscribe(Channel channel) {
        channel.removeSubscriber(this);
    }

    public String getName() {
        return name;
    }
}

class Channel implements Observable {
    private String name;
    private ArrayList<User> subscribers;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(User user) {
        subscribers.add(user);
    }

    @Override
    public void removeSubscriber(User user) {
        subscribers.remove(user);
    }

    @Override
    public void notifyUser(String msg) {
        System.out.println(name + " posted a new video!");
        String constructedMessage = String.format("%s: %s", name, msg);
        for(User user : subscribers) {
            user.receiveNotification(constructedMessage);
        }
    }
}