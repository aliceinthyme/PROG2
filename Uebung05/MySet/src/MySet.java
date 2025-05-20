import java.util.*;

public class MySet implements Set { 
    ArrayList<Object> list;
    MySet() {
        list = new ArrayList<Object>();
    }
    @Override
    public Iterator iterator() {
        return list.iterator();
    }
    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }
    @Override
    public boolean retainAll(Collection c) {
        return list.retainAll(c);
    }
    @Override
    public boolean add(Object arg0) {
        if(list.contains(arg0)) {
            return false;
        }
        return list.add(arg0);
    }
    @Override
    public boolean addAll(Collection c) {
        Iterator iter = c.iterator();
        while(iter.hasNext()) {
            this.add(iter.next());
        }
        return true;
    }
    @Override
    public void clear() {
        list.clear(); 
    }
    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }
    @Override
    public boolean containsAll(Collection c) {
        return list.containsAll(c);
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }
    @Override
    public boolean removeAll(Collection c) {
        return list.removeAll(c);
    }
    @Override
    public int size() {
        return list.size();
    }
    @Override
    public Object[] toArray() {
        return list.toArray();
    }
}
