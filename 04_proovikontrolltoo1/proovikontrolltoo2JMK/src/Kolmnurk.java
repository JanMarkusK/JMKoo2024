import java.util.ArrayList;
import java.util.List;

public class Kolmnurk {
    List<Integer> xKord = new ArrayList<Integer>();
    List<Integer> yKord = new ArrayList<Integer>();

    public Kolmnurk(List<Integer> xKord, List<Integer> yKord) {
        this.xKord = xKord;
        this.yKord = yKord;
    }
    //2.
    public int lisaKordinaadid (int newXKord,int newYKord ){
        xKord.add(newXKord);
        xKord.add(newYKord);

        int summa = 0;
        for(int x: xKord){
            summa+=x;
        }
        return summa;
    }
}
