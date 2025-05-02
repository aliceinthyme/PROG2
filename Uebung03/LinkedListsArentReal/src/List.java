public class List {
    private Node first = null;
    private Node last = null;
    private int counter = 0;
    //empty list
    List() {}
    //methods
    public void print() {
        Node h = first;
        int curPos = 0;
        while ((h.getNext() != first) || (h != null)) {
            //System.out.println(curPos+": "+h.getValue());
            h = h.getNext();
            System.out.println(h+" "+h.getNext()+" "+h.getPrev());
            curPos++;
            return;
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
                System.out.println("Hi!");
                first = x;
                last = x;
                System.out.println(first);
                System.out.println(last);
                x.setNext(x);
                x.setPrev(x);
                counter++;
                return;
            }
            while ((h.getNext() != first) || (curPos != p)) {
                System.out.println(curPos+" 1");
                h = h.getNext();
                curPos++;
            }
            assert first != null;
            assert last != null;
            //insert at start of list
            if(p == 0) {
                x.setNext(h.getNext());
                x.setPrev(h.getPrev());
                first = x;
                counter++;
                return;
            }
            assert p != 0;
            //insert at end of list
            if(p == counter) {
                x.setNext(first);
                x.setPrev(last);
                last = x;
                counter++;
                System.out.println(first);
                System.out.println(last);
                System.out.println(x);
                System.out.println("Counter: "+counter);
                System.out.println(x.getNext());
                System.out.println(x.getPrev().getNext());
                return;
            }
            System.out.println("End");
            //insert in middle of list
            assert p != counter - 1;
            x.setNext(h.getNext());
            x.setPrev(h.getPrev());
            counter++;
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
            while ((h.getNext() != first) || (curPos != p)) {
                h = h.getNext();
                curPos++;
            }
            if((first == null && last == null)) {
                throw new EmptyListException();
            }
            assert first != null;
            assert last != null;
            if(p == 0) {
                h.getNext().setPrev(h.getPrev());
                h.getPrev().setNext(h.getNext());
                first = h.getNext();
                counter--;
                return(h);
            }
            assert p != 0;
            if(p == counter - 1) {
                h.getNext().setPrev(h.getPrev());
                h.getPrev().setNext(h.getNext());
                last = h.getNext();
                counter--;
                return(h);
            }
            assert p != counter - 1;
            h.getNext().setPrev(h.getPrev());
            h.getPrev().setNext(h.getNext());
            counter--;
            return(h);
        }
    }
    public int search(Node x) {
        Node h = first;
        int curPos = 0;
        while ((h.getNext() != first) || (h != null) || (h != last) || (h != x)) {
            h = h.getNext();
        }
        if(h == x) {
            return(curPos);
        } else {
            return(-1);
        }
    }
}
