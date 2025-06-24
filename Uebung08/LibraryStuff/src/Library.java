import java.util.*;

public class Library {
    private TreeSet<Book> content = new TreeSet<Book>();
    public Library()  {
    }
    public boolean sortedInsert(Book newBook) {
        boolean result = content.add(newBook);
        return result;
    }
    public Book searchISBN(String isbn) {
        Iterator<Book> iter = content.iterator();
        while(iter.hasNext()) {
            Book temp = iter.next();
            if(temp.getIsbn().equals(isbn)) {
                return temp;
            }
        }
        return null;
    }
    public Collection<Book> searchAuthor(String author) {
        Iterator<Book> iter = content.iterator();
        ArrayList<Book> list = new ArrayList<Book>();
        while(iter.hasNext()) {
            Book temp = iter.next();
            if(temp.getAuthor().equals(author)) {
                list.add(temp);
            }
        }
        if(list.isEmpty()) {
            return null;
        }
        return list;
    }
    public Map<String, ArrayList<Book>> stockByAuthor() {
        TreeMap<String, ArrayList<Book>> output = new TreeMap<String, ArrayList<Book>>();
        Iterator<Book> iter = content.iterator();
        while(iter.hasNext()) {
            Book temp = iter.next();
            if(output.containsKey(temp.getAuthor())) {
                ArrayList<Book> list = output.get(temp.getAuthor());
                list.add(temp);
                output.put(temp.getAuthor(), list);
            } else {
                ArrayList<Book> list = new ArrayList<Book>();
                list.add(temp);
                output.put(temp.getAuthor(), list);
            }
        }
        return output;
    }
}


/*
 * 
 * 
+sortedInsert(newBook:Book):boolean
+searchISBN(isbn:String):Buch
+searchAuthor(autor:String):Collection
 */