package studio.irisdesigns.roulettepredictor;

import android.app.Application;

public class CalcPredict1 extends Application {
    private static int spinCounter = 0;
    private static int winningNumber;

    public int getSpinCounter() {
        return spinCounter;
    }

    public void setSpinCounter(int sCounter) {
        spinCounter = sCounter;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(int winNumber) {
        winningNumber = winNumber;
    }

    public void addSpinCounter() {
        spinCounter++;
    }
}