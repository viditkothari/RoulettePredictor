package studio.irisdesigns.roulettepredictor;

/**
 * Created by viditkothari on 8/2/2017.
 */

public class Prediction {
    private int value;
    private float winPercent;
    private int lastWin;

    public void setValues(int value, float winPercent, int lastWin) {
        this.value = value;
        this.winPercent = winPercent;
        this.lastWin = lastWin;
    }

    public int getValue() {
        return value;
    }

    public float getWinPercent() {
        return winPercent;
    }

    public int getLastWin() {
        return lastWin;
    }
}
