import java.util.*;

public class DSExercise6 {
    public static void main(String[] args){

        Book b1 = new Book(1, "Philosopher's Stone", "J.K. Rowling");
        Book b2 = new Book(2, "Chamber of Secrets", "J.K. Rowling");
        Book b3 = new Book(3, "Prisoner of Azkaban", "J.K. Rowling");
        Book b4 = new Book(4, "Goblet of Fire", "J.K. Rowling");
        Book b5 = new Book(5, "Order of the Phoenix", "J.K. Rowling");

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);

        Books hpBooks = new Books(bookList);

        String title1 = "Prisoner of Azkaban";
        Book found1 = hpBooks.linearSearch(title1);
        System.out.println("Linear Search Result: " + (found1 != null ? found1 : "Not Found"));

        String title2 = "Goblet of Fire";
        Book found2 = hpBooks.binarySearch(title2);
        System.out.println("Binary Search Result: " + (found2 != null ? found2 : "Not Found"));
    }
}

class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getTitle().compareTo(b2.getTitle());
    }
}

class Books{
    List<Book> books;
    public Books(){
        books=new ArrayList<>();
    }
    public Books(List<Book> b){
        books=b;
    }
    public Book linearSearch(String title){
        for(Book book : books){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
    public Book binarySearch(String title){
        Collections.sort(books, new TitleComparator());
        int lb=0;
        int ub=books.size()-1;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(books.get(mid).getTitle().compareTo(title)==0){
                return books.get(mid);
            }
            else if(books.get(mid).getTitle().compareTo(title)<0){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
        }
        return null;
    }
}

class Book{
    private int bookId;
    private String title;
    private String author;
    public Book(int bid,String t, String a){
        bookId=bid;
        title=t;
        author=a;
    }
    public int getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    @Override
    public String toString(){
        return "ID: "+bookId+", Title: "+title+", Author: "+author;
    }
}
