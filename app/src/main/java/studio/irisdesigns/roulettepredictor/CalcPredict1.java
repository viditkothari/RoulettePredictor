package studio.irisdesigns.roulettepredictor;

import android.app.Application;

public class CalcPredict1 extends Application {
    private static int spinCounter = 0;
    private static int[] groupPA1 = new int[4];
    private static int[] groupR1 = new int[4];
    private static int[] groupPB1 = new int[4];
    // Total Loss & Last Loss counter Number
    private static int[][] groupPA2 = new int[4][2];
    private static int[][] groupR2 = new int[4][2];
    private static int[][] groupPB2 = new int[4][2];
    // Loss Percentage
    private static double[] groupPA3 = new double[4];
    private static double[] groupR3 = new double[4];
    private static double[] groupPB3 = new double[4];
    int[] groupPA2Array = new int[8];
    int[] groupR2Array = new int[8];
    int[] groupPB2Array = new int[8];
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