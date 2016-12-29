import java.util.ArrayList;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class OdberneMisto {
    private int EAN;
    private ArrayList<Character> adresa;

    public OdberneMisto(int EAN, ArrayList<Character> adresa) {
        this.EAN = EAN;
        this.adresa = adresa;
    }

    public int getEAN() {
        return EAN;
    }

    public ArrayList<Character> getAdresa() {
        return adresa;
    }
}
