package studio.irisdesigns.roulettepredictor;


public class SendDatatoFragmentB {

    private int[] groupPA1 = new int[4];
    private int[] groupR1 = new int[4];
    private int[] groupPB1 = new int[4];

    // Total Loss & Last Loss counter Number
    private int[][] groupPA2 = new int[4][2];
    private int[][] groupR2 = new int[4][2];
    private int[][] groupPB2 = new int[4][2];

    // Loss Percentage
    private double[] groupPA3 = new double[4];
    private double[] groupR3 = new double[4];
    private double[] groupPB3 = new double[4];

    public int[] getGroupPA1() {
        return groupPA1;
    }

    public int[] getGroupR1() {
        return groupR1;
    }

    public int[] getGroupPB1() {
        return groupPB1;
    }

    public int[][] getGroupPA2() {
        return groupPA2;
    }

    public int[][] getGroupR2() {
        return groupR2;
    }

    public int[][] getGroupPB2() {
        return groupPB2;
    }

    public double[] getGroupPA3() {
        return groupPA3;
    }

    public double[] getGroupR3() {
        return groupR3;
    }

    public double[] getGroupPB3() {
        return groupPB3;
    }

    public void setData(int[] groupPA1, int[] groupR1, int[] groupPB1, int[][] groupPA2, int[][] groupR2, int[][] groupPB2, double[] groupPA3, double[] groupR3, double[] groupPB3) {
        this.groupPA1 = groupPA1;
        this.groupR1 = groupR1;
        this.groupPB1 = groupPB1;
        this.groupPA2 = groupPA2;
        this.groupR2 = groupR2;
        this.groupPB2 = groupPB2;
        this.groupPA3 = groupPA3;
        this.groupR3 = groupR3;
        this.groupPB3 = groupPB3;
    }
}
