import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) throws Exception {
        try {
            ListQueue<String> list = new ListQueue<String>();
            System.out.println(list.isEmpty());
            list.enter("Hi!");
            list.front();
            System.out.println(list.isEmpty());
            list.leave();
            list.leave(); //to intentionally cause an exception
        } catch (NoSuchElementException e) {
            System.out.println("Empty List, sorry can't remove what isn't real!");
        }
    }
}
