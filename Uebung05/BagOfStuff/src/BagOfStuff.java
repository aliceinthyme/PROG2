import java.util.*;
public class BagOfStuff {
    //I genuinely do not know what the heck you want to see here, honestly the Question is barely even a description, like, is this a joke??
    private LinkedList<Object> list = new LinkedList<Object>();
    BagOfStuff() {
    }
    public boolean add(Object a) {
        return list.add(a);
    }
    public void remove(Object a) {
        list.remove(a);
    }
    public void print() {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
