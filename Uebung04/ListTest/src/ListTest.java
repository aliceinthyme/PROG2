import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) throws Exception {
        try {
            final int N = 100000;   //constant
        int[] a = new int[] {1};
        ArrayList<Integer> b = new ArrayList<Integer>();
        LinkedList<Integer> c = new LinkedList<Integer>();
        //append N times at the end
        long start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            a = arrayAppend(a);
        }
        long out = System.currentTimeMillis()-start;    //IDE was complaining about doing this in Sysout so I seperated it
        System.out.println("Array Append: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            b.add(1);
        }
        out = System.currentTimeMillis()-start;
        System.out.println("ArrayList Append: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            c.add(1);
        }
        out = System.currentTimeMillis()-start;
        System.out.println("LinkedList Append: "+out);
        //Add to front
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            arrayToFront(a);
        }
        out = System.currentTimeMillis()-start;    //IDE was complaining about doing this in Sysout so I seperated it
        System.out.println("Array add elements to front: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            b.addFirst(1);
        }
        out = System.currentTimeMillis()-start;
        System.out.println("ArrayList add elements to front: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            c.addFirst(1);
        }
        out = System.currentTimeMillis()-start;
        System.out.println("LinkedList add elements to front: "+out);
        //Sequential Access
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            int temp = a[i];
        }
        out = System.currentTimeMillis()-start;    //IDE was complaining about doing this in Sysout so I seperated it
        System.out.println("Array access all elements: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            int temp = b.get(i);
        }
        out = System.currentTimeMillis()-start;
        System.out.println("ArrayList access all elements: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            int temp = c.get(i);
        }
        out = System.currentTimeMillis()-start;
        System.out.println("LinkedList access all elements: "+out);
        //remove first element N times
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            a = arrayCutFirst(a);
        }
        out = System.currentTimeMillis()-start;    //IDE was complaining about doing this in Sysout so I seperated it
        System.out.println("Array rm first element: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            b.removeFirst();
        }
        out = System.currentTimeMillis()-start;
        System.out.println("ArrayList rm first element: "+out);
        start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            c.removeFirst();
        }
        out = System.currentTimeMillis()-start;
        System.out.println("LinkedList rm first element: "+out);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        }
        
    }
    static int[] arrayAppend(int[] a) {
        int[] b = new int[a.length+1];
        for(int j = 0; j < a.length; j++) {
            if(j == a.length-1) {
                b[j] = 1;
            } else {
                b[j] = a[j];
            }
        }
        return(b);
    }
    static int[] arrayToFront(int[] a) {
        int[] b = new int[a.length+1];
        for(int j = 0; j < b.length; j++) {
            if(j == 0) {
                b[j] = 1;
            } else {
                b[j] = a[j-1];
            }
        }
        return(b);
    }
    static int[] arrayCutFirst(int[] a) {
        int[] b = new int[a.length-1];
        for(int j = 0; j < b.length; j++) {
            b[j] = a[j+1];
        }
        return(b);
    }
}











