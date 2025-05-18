import java.io.*;
import java.util.*;


public class IOTEst {
    public static void main(String[] args) throws Exception {
        File file = new File("info.txt");
        try {
            //output
            Writer wname = new FileWriter(file);
            StringBuilder buildname = new StringBuilder();
            //do something
            for(int i = 0; i < 15; i++) {
                buildname.append("words"+i+"\n");
            }
            wname.write(buildname.toString());
            wname.flush();
            //input
            InputStream iname = new FileInputStream(file);
            BufferedInputStream bname = new BufferedInputStream(iname);
            //do something
            int a;
            while((a = bname.read()) != -1) {
                System.out.print((char)a);
            } 
            iname.close();
            bname.close();
            wname.close();
        } catch (IOException e ) {
            System.out.println("IO Exception!");
        } 
        try {
            ArrayList<Integer> name = new ArrayList<Integer>();
            name.add(5);
            name.addFirst(6);
            name.addLast(7);
            Collections.sort(name);
            for(int i = 0; i < name.size(); i++) {
                System.out.println(name.get(i));
            } 
            Collections.sort(name, new ComparingStuff());
            for(int i = 0; i < name.size(); i++) {
                System.out.println(name.get(i));
            } 
            LinkedList<Integer> listname = new LinkedList<Integer>();
            for(int i = 0; i < 100; i++) {
                listname.add(i);
            }
            Iterator<Integer> iname = listname.iterator();
            while(iname.hasNext()) {
                String a = Integer.toString(iname.next());
                System.out.println(a);
            }
            ListIterator<Integer> liname = listname.listIterator();
            while (liname.hasNext()) {
                String a = Integer.toString(liname.next());
                System.out.println(a);
            }
            while (liname.hasPrevious()) {
                String a = Integer.toString(liname.previous());
                System.out.println(a);
            }
        } catch (IndexOutOfBoundsException e ) {
            System.out.println("No index here!");
        }
        try {
            TreeMap<Integer, Integer> forest = new TreeMap<Integer, Integer>();
            forest.put(4, 7);         
            for(int i = 0; i < 10; i++) {
                forest.put(i, i+5);
            }
            for(int i = 0; i < forest.size(); i++) {
                System.out.println(forest.get(i));
            }
            System.out.println(forest.values());
            System.out.println("-----------------");
            forest.reversed();
            for(int i = 0; i < forest.size(); i++) {
                System.out.println(forest.get(i));
            }
            System.out.println(forest.values());
            System.out.println(forest.keySet());
            TreeSet<Integer> shrub = new TreeSet<Integer>();
            for(int i = 0; i < 10; i++) {
                shrub.add(i+100);
            }
            String out = shrub.toString();
            System.out.println(out);
        } catch (Exception e) {
            System.out.println("something broke badly!");
        } 
    }
}
