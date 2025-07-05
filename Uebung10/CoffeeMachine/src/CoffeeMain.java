import java.util.Scanner;
public class CoffeeMain {
    public static void main(String[] args) throws Exception {
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Please imput desired max coffee container size: ");
        int coffee = input.nextInt();
        System.out.println("Please imput desired max water container size: ");
        int water = input.nextInt();
        CoffeeMachine a = new CoffeeMachine(water, coffee);
        while(!exit) {
            a.printStats();
            System.out.println("1. Make coffee \n2. Clean machine \n3. Refill water \n4. Refill coffee \n5. Exit simulation");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    if(a.getCleanCounter() > 0) {
                        a.makeCup();
                    } else {
                        System.out.println("Please clean machine before next use!");
                        Thread.sleep(4000); //kind of optional but its aesthetic
                    }
                    break;
                case 2:
                    a.clean();
                    Thread.sleep(2000); //kind of optional but its aesthetic
                    break;
                case 3:
                    System.out.println("How much water would you like to add?");
                    int b = input.nextInt();
                    a.fillWater(b);
                    Thread.sleep(2000); //kind of optional but its aesthetic
                    break;
                case 4:
                    System.out.println("How much coffee would you like to add?");
                    int c = input.nextInt();
                    a.fillCoffee(c);
                    Thread.sleep(2000); //kind of optional but its aesthetic
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }
}
