import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        int index = menu.size(); // Assigning index based on current size of menu
        Item newItem = new Item(name, price, index);
        menu.add(newItem);
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() {
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Create a new order instance with the given customer name
        Order newOrder = new Order(name);

        System.out.println("Here is the menu:");
        displayMenu();
        
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        while (!itemNumber.equals("q")) {
            try {
                int index = Integer.parseInt(itemNumber);
                if (index >= 0 && index < menu.size()) {
                    Item orderedItem = menu.get(index);
                    newOrder.addItem(orderedItem);
                    System.out.println("Item added to order: " + orderedItem.getName());
                } else {
                    System.out.println("Invalid menu item index. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid menu item index or q to quit.");
            }
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }

        orders.add(newOrder);

        System.out.println("Order placed successfully!");
        System.out.println("Order details:");
        newOrder.displayOrder();
    }
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        // Adding some sample menu items
        kiosk.addMenuItem("Banana", 2.00);
        kiosk.addMenuItem("Coffee", 1.50);
        kiosk.addMenuItem("Latte", 4.50);
        kiosk.addMenuItem("Cappuccino", 3.00);
        kiosk.addMenuItem("Muffin", 4.00);

        // Prompting for new orders
        kiosk.newOrder();
    }
}

