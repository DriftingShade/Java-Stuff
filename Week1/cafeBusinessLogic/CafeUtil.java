package Week1.cafeBusinessLogic;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CafeUtil {

    public int getStreakGoal() {
        return getStreakGoal(20);
    }

    // Calculating the Streak Goal, with numWeeks able to be edited!
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }
    // Get The Order Total!
    public double getOrderTotal(double[] lineItems) {
        double orderTotal = 0.0;
        for (double price : lineItems) {
            orderTotal += price;
        }
        return orderTotal;
    }
    // Displays The Menu!
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }
    // Adding Customers Method!
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        System.out.println("Hello, " + username + "!");
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(username);
        System.out.println(customers);
    }
    // Bonuses 1, 2 and 3 Implemented Here!
    public void printPriceChart(String product, double price, int maxQuantity) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double discountedPrice = price - (i - 1) * 0.50;
            System.out.println(i + " - " + currencyFormat.format(discountedPrice));
        }
    }
    // Bonus 4 Implemented Here!
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i) + " -- " + NumberFormat.getCurrencyInstance(Locale.US).format(prices.get(i)));
        }
        return true;
    }
    // Bonus 5 Implemented Here!
    public void addCustomers(ArrayList<String> customers) {
        while (true) {
            System.out.println("Please enter your name or 'q' to quit:");
            String input = System.console().readLine();
            if ("q".equalsIgnoreCase(input)) {
                break;
            }
            customers.add(input);
        }
    }
}
