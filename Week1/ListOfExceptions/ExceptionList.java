package Week1.ListOfExceptions;
import java.util.ArrayList;

public class ExceptionList {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        
        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Successfully casted value: " + castedValue);
            } catch (ClassCastException e) {
                System.out.println("Error occurred at index: " + i);
                System.out.println("Value causing the error: " + myList.get(i));
                System.out.println("Error message: " + e.getMessage());
            }
        }
    }
}
