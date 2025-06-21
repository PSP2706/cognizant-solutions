import java.util.*;

public class DSExercise3 {
    public static void main(String[] args){
        Order[] orderList = {
                new Order(101, "Alice", 220),
                new Order(102, "Bob", 560),
                new Order(103, "Charlie", 320),
                new Order(104, "David", 450),
                new Order(105, "Eve", 150)
        };

        Orders bubbleSorted = new Orders(orderList.clone());
        Orders quickSorted = new Orders(orderList.clone());

        System.out.println("Original Orders:");
        new Orders(orderList).displayOrders();

        System.out.println("\nBubble Sort by Total Price:");
        bubbleSorted.bubbleSort();
        bubbleSorted.displayOrders();

        System.out.println("\nQuick Sort by Total Price:");
        quickSorted.quickSort();
        quickSorted.displayOrders();
    }
}
class Orders {
    private Order[] orders;

    public Orders(Order[] orders) {
        this.orders = orders;
    }

    // Bubble Sort
    public void bubbleSort() {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public void quickSort() {
        quickSortHelper(0, orders.length - 1);
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

class Order{
    private int orderId;
    private String customerName;
    private int totalPrice;
    public Order(){}
    public Order(int oi,String cn, int tp){
        orderId=oi;
        customerName=cn;
        totalPrice=tp;
    }
    public int getOrderId(){
        return orderId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int getTotalPrice(){
        return totalPrice;
    }
    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}



