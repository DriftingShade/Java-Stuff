import java.util.Arrays;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		System.out.println("Random Rolls: " + generator.getTenRolls());
        System.out.println("Random Letter: " + generator.getRandomLetter());
        System.out.println("Random Password: " + generator.generatePassword());
        int length = 10;
        String[] passwordSet = generator.getNewPasswordSet(length);
        System.out.println("Password Set:");
        for (String password : passwordSet) {
            System.out.println(password);
        }
        // -----Below is the Sensei Bonus Stuff-----
        int[] arrayToShuffle1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        generator.shuffleArray(arrayToShuffle1);
        System.out.println("Shuffled Array 1: " + Arrays.toString(arrayToShuffle1));
        int[] arrayToShuffle2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        generator.shuffleArray(arrayToShuffle2);
        System.out.println("Shuffled Array 2: " + Arrays.toString(arrayToShuffle2));
	}
}
