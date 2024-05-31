package Week1.MapOfTheHashmatique;
import java.util.HashMap;
import java.util.Set;

public class HashMapTracks {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Dancy`s Dream", "Every night the Devil comes and walks through Dancy`s dream");
        trackList.put("Below The Belt", "So beat my like a punching bag I can take more hits than you`ll ever get");
        trackList.put("Ghost of Perdition", "To see a beloved son in despair of what`s to come");
        trackList.put("Take Me Back To Eden", "My my those eyes like fire I`m a winged insect you`re a funeral pyre");
        String track = trackList.get("Dancy`s Dream");
        System.out.println(track);
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}
