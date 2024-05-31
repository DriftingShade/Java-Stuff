import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    // This method determines whether the current time is evening or morning!
    public String guestGreeting(String name) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(dateFormat.format(now));

        String dayPeriod;
        if (hour >= 0 && hour < 12) {
            dayPeriod = "morning";
        } else if (hour >= 12 && hour < 18) {
            dayPeriod = "afternoon";
        } else {
            dayPeriod = "evening";
        }

        return "Good " + dayPeriod + ", " + name + "! Lovely to see you.";
    }
    // This method displays good day/evening according to the current time.
    public String guestGreeting(String name, String dayPeriod) {
        return "Good " + dayPeriod + ", " + name + ". Lovely to see you.";
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return String.format("The time is currently: %s", date.toString());
    }
    // This method checks to see if Alexis, Alfred or neither are present in the conversation and responds accordingly!
    public String respondBeforeAlexis(String conversation) {
        if (conversation.contains("Alexis")) {
            return "Right away friend!  Although, you have little need of that scrap heap...";
        }
        else if (conversation.contains("Alfred")) {
            return "At your service, my friend!  I always strive to serve!";
        }
        else {
            return "Very well!  With that, I shall retire.";
        }
    }
    // Implementing the ability for AlfredBot to tell us a random joke from this array!
    private String[] jokes = {
        "Why did the scarecrow win an award? Because he was outstanding in his field!",
        "I told my wife she was drawing her eyebrows too high. She looked surprised.",
        "Parallel lines have so much in common. It`s a shame they`ll never meet.",
        "I'm reading a book on anti-gravity. It`s impossible to put down!",
        "Why did the math book look sad? Because it had too many problems."
    };

    public String tellJoke() {
        Random rand = new Random();
        int index = rand.nextInt(jokes.length);
        return jokes[index];
    }
}


