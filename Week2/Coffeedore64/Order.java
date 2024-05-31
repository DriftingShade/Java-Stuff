import java.util.ArrayList;

public class Order {
    
    private String name;
    private boolean ready;
    private ArrayList<Item> items;
    
    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<>();
    }
    
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }
    
    // GETTERS & SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isReady() {
        return ready;
    }
    
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    // METHOD TO ADD ITEM TO ORDER
    public void addItem(Item item) {
        items.add(item);
    }
    
    // METHOD TO GET STATUS MESSAGE
    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    
    // METHOD TO CALCULATE ORDER TOTAL
    public double getOrderTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    // METHOD TO DISPLAY ORDER INFORMATION
    public void displayOrder() {
        System.out.println("Customer Name: " + name);
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());
    }
}



