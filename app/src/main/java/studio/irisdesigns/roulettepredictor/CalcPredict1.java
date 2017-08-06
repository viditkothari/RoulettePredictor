package studio.irisdesigns.roulettepredictor;

import android.app.Application;

public class CalcPredict1 extends Application {
    private static int spinCounter = 0;
    private int winningNumber;

    public int getSpinCounter() {
        return spinCounter;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(int winningNumber) {
        this.winningNumber = winningNumber;
        spinCounter++;
    }
}