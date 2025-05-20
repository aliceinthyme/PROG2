public class App {
    public static void main(String[] args) throws Exception {
        try {
            MySet a = new MySet();
            for(int i = 0; i < 10; i++) {
                a.add(i);
            }
            a.addAll(a);
            a.contains(5);
            a.containsAll(a);
            Object[] b = a.toArray();
            a.equals(a);
            a.isEmpty();
            a.iterator();
            a.remove(5);
            a.removeAll(a);
            a.clear();
            for(int i = 0; i < b.length; i++) {
                System.out.println(b[i]);
            }
        } catch (IndexOutOfBoundsException e ) {
            System.out.println("Index out of bounds!");
        }
    }
}
