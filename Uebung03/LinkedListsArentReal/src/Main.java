public class Main {
    public static void main(String[] args) throws Exception {
        try {
            List l = new List();
            for(int i = 0; i < 10; i++) {
                l.insert(new Node(i+1), i);
            }
            l.print();
            /*l.insert(new Node(2), 11);
            l.print();
            l.insert(new Node(5), 0);
            l.print();
            Node a = new Node(7);
            l.insert(a, 6);
            l.print();
            l.search(a);
            l.remove(l.search(a));
            l.search(a);*/
        } catch(IndexOutOfBoundsException e) {

        } //catch(EmptyListException e) {
            
        //}
    }
}
