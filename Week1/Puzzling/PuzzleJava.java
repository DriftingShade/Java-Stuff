import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    // If this was D&D, these rolls wouldn't be too bad mostly!
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomRolls = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(20) + i;
            randomRolls.add(randomNumber);
        }
        return randomRolls;
    }
    // Pick a letter, any letter!
    public char getRandomLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random rand = new Random();
        int randomIndex = rand.nextInt(26);
        char randomLetter = alphabet[randomIndex];
        return randomLetter;
    }
    // Generates an 8 character long string
    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            char randomLetter = getRandomLetter();
            password.append(randomLetter);
        }
        return password.toString();
    }
    // New Password Set Method
    public String[] getNewPasswordSet(int length) {
        String[] passwordSet = new String[length];
        for (int i = 0; i < length; i++) {
            passwordSet[i] = generatePassword();
        }
        return passwordSet;
    }
    // Sensei Bonus!  I think I did this right?  It seems to work lol
    public void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int randomIndex = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
}
