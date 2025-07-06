import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class drawing extends Frame {
    CoffeeMachine machine = new CoffeeMachine(500, 500);
    CheckboxGroup radio;

    public static void main(String[] args) {
            drawing mainFrame = new drawing();
            mainFrame.setVisible(true);
    }

    
    
    public drawing() {
        setTitle("Coffee Machine Sim Gui");
        setSize(600, 400);
        setLayout(new FlowLayout());
        Button lockIn = new Button("Execute!");
        Button clean = new Button("Clean Machine!");
        radio = new CheckboxGroup();
        Checkbox makeCup = new Checkbox("Make coffe!", radio, true);
        Checkbox fillWater = new Checkbox("Refill Water!", radio, false);
        Checkbox fillCoffee = new Checkbox("Refill Coffee!", radio, false);
        TextField amount = new TextField("g/ml to fill with");
        String[] outp = machine.printStats();
        Label outpL1 = new Label(outp[0]);
        outpL1.setAlignment(Label.LEFT);
        Label outpL2 = new Label(outp[1]);
        outpL2.setAlignment(Label.LEFT);
        Label outpL3 = new Label(outp[2]);
        outpL3.setAlignment(Label.LEFT);
        Label outpL4 = new Label(outp[3]);
        outpL4.setAlignment(Label.LEFT);
        Label outpL5 = new Label(outp[4]);
        outpL5.setAlignment(Label.LEFT);
        PopupMenu pop = new PopupMenu();       //add stuff to this!
        MenuItem pMenu1 = new MenuItem();
        Button showLogs = new Button("show log file!");
        
        lockIn.addActionListener(e -> {
            try {
                if(makeCup.getState()) {
                    machine.makeCup();
                }
                int a = Integer.parseInt(amount.getText());
                if (fillWater.getState()) {
                    machine.fillWater(a);
                }
                if (fillCoffee.getState()) {
                    machine.fillCoffee(a);
                }
                String[] outptemp = machine.printStats();
                outpL1.setText(outptemp[0]);
                outpL2.setText(outptemp[1]);
                outpL3.setText(outptemp[2]);
                outpL4.setText(outptemp[3]);
                outpL5.setText(outptemp[4]);
            } catch (InsufficientMaterialsException c) {
                System.err.println("Machine is empty!");
            } catch (NumberFormatException c) {
                System.err.println("Please use an actual number!");
            } catch (ArrayIndexOutOfBoundsException c) {
                System.err.println("IndexOutOfBoundsException detected!");
            }
            try {
                ArrayList<String> list = machine.logReader();
                for(int i = 0; i < list.size(); i++) {
                    Label temp = new Label(list.get(i));
                    add(temp);
                }
            } catch (IOException c) {
                
            } catch (IndexOutOfBoundsException c) {
    
            }
        });
        clean.addActionListener(e -> {
            assert machine != null;
            machine.clean();
            try {
                String[] outptemp = machine.printStats();
                outpL1.setText(outptemp[0]);
                outpL2.setText(outptemp[1]);
                outpL3.setText(outptemp[2]);
                outpL4.setText(outptemp[3]);
                outpL5.setText(outptemp[4]);
            } catch (ArrayIndexOutOfBoundsException c) {
                System.err.println("IndexOutOfBoundsException detected!");
            }
        });
        showLogs.addActionListener(e -> {
            logMenu log = new logMenu();
            log.setVisible(true);
        });
        add(makeCup);
        add(fillCoffee);
        add(fillWater);
        add(amount);
        add(lockIn);
        add(clean);
        add(outpL1);
        add(outpL2);
        add(outpL3);
        add(outpL4);
        add(outpL5);
        add(showLogs);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class logMenu extends Frame {
        logMenu() {
            setTitle("Coffee Machine Sim logs");
            setSize(500, 1200);
            setLayout(new FlowLayout());            
            try {
                ArrayList<String> list = machine.logReader();
                for(int i = 0; i < list.size(); i++) {
                    Label temp = new Label(list.get(i));
                    add(temp);
                }
            } catch (IOException e) {
                
            } catch (IndexOutOfBoundsException e) {
    
            }
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }
    }

}
