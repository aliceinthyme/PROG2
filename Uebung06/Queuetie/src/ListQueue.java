import java.util.*;

public class ListQueue<T> implements Queue<T> {
    LinkedList<T> list = new LinkedList<T>();
    ListQueue() {
    }
    @Override
    public boolean enter(T o) {
        if(list.add(o)) {
            return(true);
        }
        return(false);
    }
    @Override
    public void front() {
        System.out.println(list.peekFirst());
    }
    @Override
    public boolean isEmpty() {
        if(list.isEmpty()) {
            return(true);
        }
        return(false);
    }
    @Override
    public T leave() {
        return list.removeFirst();
    }
}
