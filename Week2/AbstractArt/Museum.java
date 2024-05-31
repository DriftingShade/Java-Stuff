import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {
        ArrayList<Art> museum = new ArrayList<>();

        // Paintings
        Painting painting1 = new Painting("Starry Night", "Vincent van Gogh", "A famous painting depicting the night sky", "Oil");
        Painting painting2 = new Painting("The Persistence of Memory", "Salvador Dali", "A surreal painting featuring melting clocks", "Oil");
        Painting painting3 = new Painting("Girl with a Pearl Earring", "Johannes Vermeer", "A portrait of a girl wearing a pearl earring", "Oil");

        // Sculptures
        Sculpture sculpture1 = new Sculpture("David", "Michelangelo", "A marble sculpture of the biblical David", "Marble");
        Sculpture sculpture2 = new Sculpture("The Thinker", "Auguste Rodin", "A bronze sculpture of a man in deep thought", "Bronze");

        museum.add(painting1);
        museum.add(painting2);
        museum.add(painting3);
        museum.add(sculpture1);
        museum.add(sculpture2);

        // Shuffle the artworks in the museum!
        Collections.shuffle(museum);

        // Separating the artwork so it's more legible!
        for (Art art : museum) {
            art.viewArt();
            System.out.println("-------------------------------");
        }
    }
}