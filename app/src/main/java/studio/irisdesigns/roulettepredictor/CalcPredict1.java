package studio.irisdesigns.roulettepredictor;

import android.app.Application;

import java.util.ArrayList;
import java.util.Random;

import studio.irisdesigns.roulettepredictor.utility.CircularCounter;
import studio.irisdesigns.roulettepredictor.utility.Node;

/*
 * Created by viditkothari on 8/2/2017.
 */

public class CalcPredict1 extends Application {
    private static int spinCounter = 0;
    private static ArrayList<Integer> winningNumbers = new ArrayList<>();
    int[][] P1 = {{26, 32, 5, 10}, {2, 3, 20, 33}, {1, 3, 21, 25}, {1, 2, 26, 35}, {5, 6, 19, 21}, {4, 6, 10, 24}, {4, 5, 27, 34}, {8, 9, 28, 29}, {7, 9, 23, 30}, {7, 8, 22, 31}, {11, 12, 5, 23}, {10, 12, 30, 36}, {10, 11, 28, 35}, {14, 15, 27, 36}, {13, 15, 20, 31}, {13, 14, 19, 32}, {17, 18, 24, 33}, {16, 18, 25, 34}, {16, 17, 22, 29}, {20, 21, 4, 15}, {19, 21, 1, 14}, {19, 20, 2, 4}, {23, 24, 9, 18}, {22, 24, 8, 10}, {22, 23, 5, 16}, {26, 27, 2, 17}, {25, 27, 0, 3}, {25, 26, 6, 13}, {29, 30, 7, 12}, {28, 30, 7, 18}, {28, 29, 8, 11}, {32, 33, 9, 14}, {31, 33, 0, 15}, {31, 32, 1, 16}, {35, 36, 6, 17}, {34, 36, 3, 12}, {34, 35, 11, 13}};
    int[][] P2 = {{26, 32, 5, 10, -1, -1, -1, -1, -1}, {2, 3, 13, 14, 15, 25, 26, 27, 0}, {1, 3, 13, 14, 15, 25, 26, 27, 0}, {1, 2, 13, 14, 15, 25, 26, 27, 0}, {5, 6, 16, 17, 18, 28, 29, 30, 0}, {4, 6, 16, 17, 18, 28, 29, 30, 0}, {4, 5, 16, 17, 18, 28, 29, 30, 0}, {8, 9, 19, 20, 21, 31, 32, 33, 0}, {7, 9, 19, 20, 21, 31, 32, 33, 0}, {7, 8, 19, 20, 21, 31, 32, 33, 0}, {11, 12, 22, 23, 24, 34, 35, 36, 0}, {10, 12, 22, 23, 24, 34, 35, 36, 0}, {10, 11, 22, 23, 24, 34, 35, 36, 0}, {1, 2, 3, 14, 15, 25, 26, 27, 0}, {1, 2, 3, 13, 15, 25, 26, 27, 0}, {1, 2, 3, 13, 14, 25, 26, 27, 0}, {4, 5, 6, 17, 18, 28, 29, 30, 0}, {4, 5, 6, 16, 18, 28, 29, 30, 0}, {4, 5, 6, 16, 17, 28, 29, 30, 0}, {7, 8, 9, 20, 21, 31, 32, 33, 0}, {7, 8, 9, 19, 21, 31, 32, 33, 0}, {7, 8, 9, 19, 20, 31, 32, 33, 0}, {10, 11, 12, 23, 24, 34, 35, 36, 0}, {10, 11, 12, 22, 24, 34, 35, 36, 0}, {10, 11, 12, 22, 23, 34, 35, 36, 0}, {1, 2, 3, 13, 14, 15, 26, 27, 0}, {1, 2, 3, 13, 14, 15, 25, 27, 0}, {1, 2, 3, 13, 14, 15, 25, 26, 0}, {4, 5, 6, 16, 17, 18, 29, 30, 0}, {4, 5, 6, 16, 17, 18, 28, 30, 0}, {4, 5, 6, 16, 17, 18, 28, 29, 0}, {7, 8, 9, 19, 20, 21, 32, 33, 0}, {7, 8, 9, 19, 20, 21, 31, 33, 0}, {7, 8, 9, 19, 20, 21, 31, 32, 0}, {10, 11, 12, 22, 23, 24, 35, 36, 0}, {10, 11, 12, 22, 23, 24, 34, 36, 0}, {10, 11, 12, 22, 23, 24, 34, 35, 0}};

    public int getSpinCounter() {
        return spinCounter;
    }

    public void setSpinCounter(int counter) {
        spinCounter += counter;
    }

    public int getWinningNumber() {
        return winningNumbers.get(winningNumbers.size() - 1);
    }

    public void setWinningNumber(int winningNumber) {
        winningNumbers.add(winningNumber);
        spinCounter++;
    }

    /*   int[][] currentWinningNum;
    int[] winningHistory;
    int[][] classNum_primaryNum;
    int[][] primaryNum_classNum;
    int[][][] adjacentNum;
    int p_counter; //0-36;
    int[] lossCount_forPercent;
    int[][] not_in_37counts;
    // numTableForPD;

    private static Prediction calcP3(Prediction a) {
        CircularCounter c = new CircularCounter();
        c.createCircularList();
        ArrayList<Node> cL = c.getCircularCounter();
        Node currentNode = cL.get(0);
        *//*currentNode = currentNode.getLinkPrev();
        currentNode = currentNode.getLinkNext();*//*
        return null;
    }

    private Prediction calcP1(Prediction a) {
        return null;
    }

    private Prediction calcP2(Prediction a) {
        return null;
    }

    private Prediction calcP4(Prediction a) {
        return null;
    }

*/

}