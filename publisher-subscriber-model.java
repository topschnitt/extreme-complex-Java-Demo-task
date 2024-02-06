import java.util.ArrayList;
import java.util.List;

// Interface for subscribers
interface Subscriber {
    void update(String message);
}

// Concrete implementation of a subscriber
class ConcreteSubscriber implements Subscriber {
    private String name;

    public ConcreteSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}

// Notifier class responsible for sending notifications to subscribers
class Notifier {
    private List<Subscriber> subscribers = new ArrayList<>();

    // Subscribe a new subscriber
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Unsubscribe a subscriber
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // Notify all subscribers with a message
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}

// Example usage
public class SubscriptionExample {
    public static void main(String[] args) {
        // Create a notifier
        Notifier notifier = new Notifier();

        // Create subscribers
        Subscriber subscriber1 = new ConcreteSubscriber("Subscriber 1");
        Subscriber subscriber2 = new ConcreteSubscriber("Subscriber 2");

        // Subscribe subscribers
        notifier.subscribe(subscriber1);
        notifier.subscribe(subscriber2);

        // Notify subscribers
        notifier.notifySubscribers("New update!");

        // Unsubscribe a subscriber
        notifier.unsubscribe(subscriber1);

        // Notify remaining subscribers
        notifier.notifySubscribers("Another update!");
    }
}
