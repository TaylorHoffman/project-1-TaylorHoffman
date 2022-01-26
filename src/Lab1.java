import java.util.ArrayList; //import ArrayList

import static java.lang.System.console;

public class Lab1 {
    public static void main(String[] args) {
        ArrayList<Item> store = createCart(args); // method calls
        printReceiptInOrder(store);
        emptyCartReverseOrder(store);
    }
public static ArrayList<Item> createCart(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();
        int i;
        if (args.length == 0) { } // if no arguments, end program
        Item[] store = setupStore();

        for (i = 0; i < args.length; i++) { // go through all command line arguments and if it is a valid store item add to cart, if not print appropriate error message
            try {
                int idx = Integer.parseInt(args[i]);
                if (idx > 14) {
                        System.out.println("The store does not have an item of index " + idx);
                }
                else {
                        cart.add(store[idx]);
                }
                }
            catch(Exception e) {
                System.out.println(args[i] + " is not a valid integer");
                }
            }
            return(cart);
        }
public static void printReceiptInOrder(ArrayList<Item> receipt) { // print receipt with appropriate outputs
        System.out.println("RECEIPT");
        System.out.println("------------------");
            for (int i =0; i < receipt.size(); i++) {
                System.out.print(receipt.get(i).getItemName());
                System.out.println("\t\t" + receipt.get(i).getItemPrice());
            }
            double sum = 0;
            for (int i = 0; i < receipt.size(); i++) {
                sum += receipt.get(i).getItemPrice();
            }
        System.out.println("------------------");
        System.out.println("Subtotal: " + sum);
        double salesTax = sum * 0.05;
        System.out.println("Sales Tax: 5%");
        double total = sum + salesTax;
        System.out.println("Total: " + total);
    }

public static Item [] setupStore() { // store method, added extra items to make more realistic
        Item[] store = new Item[15];
        store[0] = new Item("Bananas", 1.50);
        store[1] = new Item("Apple", 0.50);
        store[2] = new Item("Bread", 2.00);
        store[3] = new Item("Milk", 3.00);
        store[4] = new Item("Eggs", 2.50);
        store[5] = new Item("Potato Chips", 1.50);
        store[6] = new Item("Strawberries", 3.00);
        store[7] = new Item("Peanut Butter", 2.50);
        store[8] = new Item("Turkey slices", 4.00);
        store[9] = new Item("Cheese", 3.50);
        store[10] = new Item("Chicken Noodle Soup", 2.50);
        store[11] = new Item("Paper Towels", 1.00);
        store[12] = new Item("Oreos", 2.00);
        store[13] = new Item("Carrots", 2.50);
        store[14] = new Item("Beef", 5.50);
        return store;
    }
    public static void emptyCartReverseOrder(ArrayList<Item> receipt) { // method to empty the cart in reverse order
        System.out.println("Removing all items from the cart in \"Last In First Out\" order...");
            for (int i = receipt.size() - 1; i >= 0; i--) {
                System.out.println("Removing: " + receipt.get(i).getItemName());
            }
        System.out.println("Your cart has been emptied!");
    }
}
