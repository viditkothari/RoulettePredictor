package studio.irisdesigns.roulettepredictor.utility;

import java.util.ArrayList;

/**
 * Created by viditkothari on 8/4/2017.
 */

public class CircularCounter {
    private static ArrayList<Node> circularCounter = new ArrayList<>();

    public void createCircularList() {

        for (int i = 0; i < 37; i++) {
            circularCounter.add(new Node());
        }

        for (int i = 0; i < 37; i++) {
            circularCounter.get(i).setData(i);

            if (i == 36)
                circularCounter.get(i).setLinkNext(circularCounter.get(0));
            else
                circularCounter.get(i).setLinkNext(circularCounter.get(i + 1));

            if (i == 0)
                circularCounter.get(i).setLinkPrev(circularCounter.get(36));
            else
                circularCounter.get(i).setLinkPrev(circularCounter.get(i - 1));

        }
    }

    public ArrayList<Node> getCircularCounter() {
        return circularCounter;
    }
}
