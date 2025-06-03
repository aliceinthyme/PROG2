import java.util.*;

public class Sort {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    public static Object[] mergeSort(Object[] a) {
        ArrayList<Object> list = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        list.sort(null);
        Object[] fin = new Object[list.size()];
        Iterator<Object> d = list.iterator();
        for(int i = 0; i < fin.length; i++) {
            fin[i] = d.next();
        }
        return(fin);
    }
}

