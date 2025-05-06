public class List {
    private Node first = null;
    private Node last = null;
    private int counter = 0;
    //empty list
    List() {}
    //methods
    public void print() {
        Node h = first;
        for(int i = 0; i < counter; i++) {
            System.out.println(i+": "+h.getValue());
            h = h.getNext();
        }
    }
    public void insert(Node x, int p) throws IndexOutOfBoundsException {
        Node h = first;
        int curPos = 0;
        if((p < 0) || (p > counter)) {
            throw new IndexOutOfBoundsException();
        } else {
            assert p >= 0;
            assert p < (counter);
            if(first == null && last == null) {
                first = x;
                last = x;
                counter++;
                return;
            }
            while ((h != last) && (curPos != p)) {
                h = h.getNext();
                curPos++;
            }
            assert first != null;
            assert last != null;
            //insert at start of list
            if(p == 0) {
                x.setNext(h);
                h.setPrev(x);
                first = x;
                counter++;
                return;
            }
            assert p != 0;
            //insert at end of list
            if(p == counter) {
                x.setPrev(last);
                h.setNext(x);
                last = x;
                counter++;
                return;
            }
            //insert in middle of list
            assert p != counter - 1;
            if(p != 0 && p != counter) {
                x.setNext(h);
                x.setPrev(h.getPrev());
                h.getPrev().setNext(x);
                h.setPrev(x);
                counter++;
            }
        }
    }
    public Node remove(int p) throws IndexOutOfBoundsException, EmptyListException {
        Node h = first;
        int curPos = 0;
        if((p < 0) || (p > counter)) {
            throw new IndexOutOfBoundsException();
        } else {
            assert p >= 0;
            assert p < (counter);
            while ((h != last) && (curPos != p)) {
                h = h.getNext();
                curPos++;
            }
            if((first == null && last == null)) {
                throw new EmptyListException();
            }
            assert first != null;
            assert last != null;
            //remove first element
            if(p == 0) {
                h.getNext().setPrev(null);
                first = h.getNext();
                h.setNext(null);
                h.setPrev(null);
                counter--;
                return(h);
            }
            assert p != 0;
            //remove last element
            if(p == counter - 1) {
                h.getPrev().setNext(null);
                last = h.getPrev();
                h.setNext(null);
                h.setPrev(null);
                counter--;
                return(h);
            }
            assert p != counter - 1;
            //remove from middle
            h.getNext().setPrev(h.getPrev());
            h.getPrev().setNext(h.getNext());
            h.setNext(null);
            h.setPrev(null);
            counter--;
            return(h);
        }
    }
    public int search(Node x) {
        Node h = first;
        int curPos = 0;
        while ((h != last) && (h != x)) {
            h = h.getNext();
            curPos++;
        }
        if(h == x) {
            return(curPos);
        } else {
            return(-1);
        }
    }
}
