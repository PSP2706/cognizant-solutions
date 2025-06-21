import java.util.*;

public class Exercise7 {
    public static void main(String[] args){
        new ObserverTest().runTests();
    }
}

class ObserverTest {
    void runTests() {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setStockPrice("AAPL", 150.0);
        market.setStockPrice("GOOG", 2800.0);

        market.deregisterObserver(web);

        market.setStockPrice("MSFT", 310.0);
    }
}

interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers(String stock, double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String stock, double price) {
        for (Observer o : observers) {
            o.update(stock, price);
        }
    }

    public void setStockPrice(String stock, double price) {
        System.out.println("Stock updated: " + stock + " - $" + price);
        notifyObservers(stock, price);
    }
}

interface Observer {
    void update(String stock, double price);
}

class MobileApp implements Observer {
    @Override
    public void update(String stock, double price) {
        System.out.println("MobileApp received update: " + stock + " - $" + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stock, double price) {
        System.out.println("WebApp received update: " + stock + " - $" + price);
    }
}
