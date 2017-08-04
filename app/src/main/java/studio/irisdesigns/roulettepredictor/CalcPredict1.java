package studio.irisdesigns.roulettepredictor;

import java.util.ArrayList;
import java.util.Random;

import studio.irisdesigns.roulettepredictor.utility.CircularCounter;
import studio.irisdesigns.roulettepredictor.utility.Node;

/*
 * Created by viditkothari on 8/2/2017.
 */

public class CalcPredict1 {
    int spinCounter;
    int[][] currentWinningNum;
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
        /*currentNode = currentNode.getLinkPrev();
        currentNode = currentNode.getLinkNext();*/
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

    int[] Random1() {
        int randomNum[] = {-1, -1, -1, -1};
        randomNum[0] = (new Random()).nextInt(37);

        do {
            randomNum[1] = (new Random()).nextInt(37);
        } while (randomNum[1] == randomNum[0]);

        do {
            randomNum[2] = (new Random()).nextInt(37);
        } while (randomNum[2] == randomNum[0] || randomNum[2] == randomNum[1]);

        do {
            randomNum[3] = (new Random()).nextInt(37);
        }
        while (randomNum[3] == randomNum[0] || randomNum[3] == randomNum[1] || randomNum[3] == randomNum[2]);
        return randomNum;
    }
}