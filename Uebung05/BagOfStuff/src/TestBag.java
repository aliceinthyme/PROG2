public class TestBag {
    public static void main(String[] args) throws Exception {
        BagOfStuff a = new BagOfStuff();
        for(int i = 0; i < 10; i++) {
            a.add(i);
        }
        a.remove(3);
        a.print();
    }
}
