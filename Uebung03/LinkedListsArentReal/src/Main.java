public class Main {
    public static void main(String[] args) throws Exception {
        try {
            List l = new List();
            for(int i = 0; i < 10; i++) {
                l.insert(new Node(i+1), i);
            }
            l.print();
            l.insert(new Node(2), 10);
            l.print();
            l.insert(new Node(5), 0);
            l.print();
            l.insert(new Node(111), 5);
            l.print();
            Node a = new Node(7);
            l.insert(a, 6);
            l.print();
            System.out.println("Node position: "+l.search(a));
            l.remove(l.search(a));
            l.print();
            System.out.println("Node position: "+l.search(a));
            l.insert(new Node(2), 20);  //deliberate index out of bounds exception!
        } catch(IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds!");
        } catch(EmptyListException e) {
            System.out.println("EmptyListException!");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!");
        }
    }
}
