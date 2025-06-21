import java.util.*;

public class Exercise6 {
    public static void main(String[] args){
        new ProxyTest().runTests();
    }
}

class ProxyTest {
    void runTests() {
        Image img1 = new ProxyImage("cat.png");
        Image img2 = new ProxyImage("dog.png");

        img1.display();
        img1.display();

        img2.display();
        img2.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading " + filename + " from remote server...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
