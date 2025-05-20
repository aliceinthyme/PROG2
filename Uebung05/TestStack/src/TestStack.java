import java.util.Iterator;

public class TestStack {
    public static void main(String[] args) throws Exception {
        TwoStacks a = new TwoStacks(100);
        TwoStacks b = new TwoStacks(1000);
        TwoStacks c = new TwoStacks(10000);
        TwoStacks d = new TwoStacks(100000);
        testStack(a);
        Iterator backward = a.backwardIterator();
        Iterator forward = a.forwardIterator();
        show(backward, "backwards");
        show(forward, "forwards");
        testStack(b);
        testStack(c);
        testStack(d);
    }
    static void testStack(TwoStacks in) {
        long start = System.currentTimeMillis();
        try {
            while(true) {
                if(Math.random() < 0.5) {   //s1
                    if(Math.random() < 0.5) {
                        in.s1Push(new Object());
                    } else {
                        if(!in.s1IsEmpty()) {
                            in.s1Pop();
                        }
                    }
                } else {    //s2
                    if(Math.random() < 0.5) {
                        in.s2Push(new Object());
                    } else {
                        if(!in.s2IsEmpty()) {
                            in.s2Pop();
                        }
                    }
                }
            }
        } catch(EmptyStackException e) {
            System.out.println("Pop attempted on empty stack");
        } catch(StackCollisionException e) {
            long time = System.currentTimeMillis()-start;
            System.out.println("Collision detected between stacks after "+time+"ms");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Something went really really wrong here!");
        }
    }
    public static void show(java.util.Iterator iter, String a) {  //honestly kinda just stole this
        int b = 1;
        while (iter.hasNext()) {
            System.out.println(b + " " + a + ": " + iter.next());
            b++;
        }
    }
}
