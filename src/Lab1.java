import java.util.ArrayList; //import ArrayList

import static java.lang.System.console;

public class Lab1 {
    public static void main(String[] args) {
        ArrayList<Item> store = createCart(args);
        printReceiptInOrder(store);
        emptyCartReverseOrder(store);
    }
        public static ArrayList<Item> createCart(String[] args) { // NEED HELP WITH THIS METHOD how do i add to cart from command line and check for errors
            ArrayList<Item> cart = new ArrayList<>();
            int i;
            if (args.length == 0) {
                // end
            }
            // for loop iterates overall all command line arguments
            // check if each argument passed is a valid store item
            // if it is, add to our cart
            // if it not, print an "error" message
            //exception if out of index
            Item[] store = setupStore();

            for (i = 0; i < args.length; i++) {
                 // dont know what this means
                // String name = console().readLine(); TRYING TO READ INPUT FROM COMMAND LINE
                try {
                    int idx = Integer.parseInt(args[i]);
                    if (idx > 14) {
                        System.out.println("The store does not have an item of index " + idx);
                    }
                    else {
                        // Integer integer = Integer.parseInt();
                        cart.add(store[idx]);
                    }
                }
                catch(Exception e) {
                    System.out.println(args[i] + " is not a valid integer");

                }

            }
            // iterate through args, add Item to cart
            return(cart);
        }
        public static void printReceiptInOrder(ArrayList<Item> receipt) {
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

    public static Item [] setupStore() {
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
    public static void emptyCartReverseOrder(ArrayList<Item> receipt) {
        System.out.println("Removing all items from the cart in \"Last In First Out\" order...");
        for (int i = receipt.size() - 1; i >= 0; i--) { // how do i access items purchased in the receipt and go backwards i just declared it twice is that okay?
            System.out.println("Removing: " + receipt.get(i).getItemName());
        }
        System.out.println("Your cart has been emptied!");


    }
}
