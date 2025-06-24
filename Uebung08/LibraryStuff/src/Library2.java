import java.util.*;

public class Library2<T extends Book> {
    private TreeSet<T> content = new TreeSet<T>();
    public Library2()  {
    }
    public boolean sortedInsert(T newBook) {
        boolean result = content.add(newBook);
        return result;
    }
    public T searchISBN(String isbn) {
        for (T t : content) {
            if(t.getIsbn().equals(isbn)) {
                return t;
            }
        }
        return null;
    }
    public Collection<T> searchAuthor(String author) {
        ArrayList<T> list = new ArrayList<T>();
        for (T t : content) {
            if(t.getAuthor().equals(author)) {
                list.add(t);
            }
        }
        if(list.isEmpty()) {
            return null;
        }
        return list;
    }
    public Map<String, ArrayList<T>> stockByAuthor() {
        TreeMap<String, ArrayList<T>> output = new TreeMap<String, ArrayList<T>>();
        for (T t : content) {
            if(output.containsKey(t.getAuthor())) {
                ArrayList<T> list = output.get(t.getAuthor());
                list.add(t);
                output.put(t.getAuthor(), list);
            } else {
                ArrayList<T> list = new ArrayList<T>();
                list.add(t);
                output.put(t.getAuthor(), list);
            }
        }
        return output;
    }
}