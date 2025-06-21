import java.util.*;

public class DSExercise2 {
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        Product2[] products = {
                new Product2(1, "Laptop", "Electronics"),
                new Product2(2, "Shoes", "Fashion"),
                new Product2(3, "Keyboard", "Electronics"),
                new Product2(4, "T-Shirt", "Fashion"),
                new Product2(5, "Mobile", "Electronics")
        };
        ECommerce ecom=new ECommerce(products);
        System.out.println("-----LINEAR SEARCH-----");
        System.out.println("Enter product name to search: ");
        String name=ob.nextLine();
        Product2 linear=ecom.linearSearch(name);
        if(linear!=null){
            linear.display();
        }
        else{
            System.out.println("Product not found");
        }
        System.out.println("-----BINARY SEARCH-----");
        System.out.println("Enter product name to search: ");
        name=ob.nextLine();
        Product2 binary=ecom.binarySearch(name);
        if(binary!=null){
            binary.display();
        }
        else{
            System.out.println("Product not found");
        }
        ob.close();
    }
}

class ECommerce{
    Product2[] products;
    public ECommerce() {}
    public ECommerce(Product2[] products){
        this.products=products;
    }
    public Product2 linearSearch(String name){
        for(Product2 p : products){
            if(p.getProductName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }
    public Product2 binarySearch(String name){
        Arrays.sort(products,Comparator.comparing(p -> p.getProductName().toLowerCase()));
        int lb=0,ub= products.length-1;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            int temp=products[mid].getProductName().compareToIgnoreCase(name);
            if(temp==0){
                return products[mid];
            }
            else if(temp<0){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
        }
        return null;
    }
    public void display(){
        for(Product2 p: products){
            p.display();
        }
    }
}

class Product2{
    private int productId;
    private String productName;
    private String category;
    public Product2(int pi,String pn,String c){
        productId=pi;
        productName=pn;
        category=c;
    }
    public int getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }
    public void display(){
        System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
    }
}


