import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        try {
            // using only Book, class Library
            Library lib1 = new Library();
            lib1.sortedInsert(new Book("Dickins", "12345321", "A Christmas Carol"));
            lib1.sortedInsert(new Book("Shakespeare", "12345342", "Much ado about nothing"));
            lib1.sortedInsert(new Book("Shakespeare", "12345343", "Romeo and Juliet"));
            lib1.sortedInsert(new Book("Shakespeare", "12345344", "Hamlet"));
            lib1.sortedInsert(new Book("Shakespeare", "12345345", "MacBeth"));
            Collection<Book> list = lib1.searchAuthor("Shakespeare");
            for (Book book : list) {
                System.out.println(book.getTitle() + " // " + book.getAuthor() + " // " + book.getIsbn());
            }
            System.out.println(lib1.searchISBN("12345345").getTitle());
            System.out.println(lib1.stockByAuthor());
            // using generics, class Library2
            Library2<Book> lib2 = new Library2<Book>();
            lib2.sortedInsert(new Book("Dickins", "12345321", "A Christmas Carol"));
            lib2.sortedInsert(new Book("Shakespeare", "12345342", "Much ado about nothing"));
            lib2.sortedInsert(new Book("Shakespeare", "12345343", "Romeo and Juliet"));
            lib2.sortedInsert(new Book("Shakespeare", "12345344", "Hamlet"));
            lib2.sortedInsert(new Book("Shakespeare", "12345345", "MacBeth"));
            Collection<Book> list2 = lib2.searchAuthor("Shakespeare");
            for (Book book : list2) {
                System.out.println(book.getTitle() + " // " + book.getAuthor() + " // " + book.getIsbn());
            }
            System.out.println(lib2.searchISBN("12345345").getTitle());
            System.out.println(lib2.stockByAuthor());
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("array index out of bounds");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("index out of bounds");
        } catch (NullPointerException e) {
            System.out.println("null pointer exception");
        } 
    }
}
