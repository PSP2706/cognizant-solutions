import java.util.*;

public class Exercise5 {
    public static void main(String[] args){
        new DecoratorTest().runTests();
    }
}

class DecoratorTest {
    void runTests() {
        Notifier notifier1 = new EmailNotifier();
        notifier1.send();

        Notifier notifier2 = new SMSNotifierDecorator(new EmailNotifier());
        notifier2.send();

        Notifier notifier3 = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        notifier3.send();
    }
}

interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    @Override
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send() {
        notifier.send();
        System.out.println("Sending SMS Notification");
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send() {
        notifier.send();
        System.out.println("Sending Slack Notification");
    }
}
