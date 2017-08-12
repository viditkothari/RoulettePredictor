package studio.irisdesigns.roulettepredictor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DecimalFormat;

import static studio.irisdesigns.roulettepredictor.R.id.predict_A1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_A2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_A3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_A4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_B1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_B2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_B3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_B4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_C1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_C2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_C3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_C4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_A1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_A2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_A3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_A4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_B1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_B2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_B3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_B4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_C1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_C2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_C3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_C4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_A1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_A2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_A3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_A4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_B1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_B2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_B3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_B4;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_C1;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_C2;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_C3;
import static studio.irisdesigns.roulettepredictor.R.id.predict_lastloss_percent_C4;

public class PredictorFragment extends Fragment {
    private View toInflate;

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

    public PredictorFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUserVisibleHint(false);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.toInflate = inflater.inflate(R.layout.fragment_predictor, container, false);
        return this.toInflate;
    }

    @Subscribe
    public void onEvent(SendDatatoFragmentB sd) {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder sbldr = new StringBuilder(" ");

        groupPA1 = sd.getGroupPA1();
        groupR1 = sd.getGroupR1();
        groupPB1 = sd.getGroupPB1();

        groupPA2 = sd.getGroupPA2();
        groupR2 = sd.getGroupR2();
        groupPB2 = sd.getGroupPB2();

        groupPA3 = sd.getGroupPA3();
        groupR3 = sd.getGroupR3();
        groupPB3 = sd.getGroupPB3();

        /*
        Prediction A
        */

        // Prediction A - Row 1
        ((TextView) this.toInflate.findViewById(predict_A1)).setText(String.valueOf(groupPA1[0]));
        ((TextView) this.toInflate.findViewById(predict_A2)).setText(String.valueOf(groupPA1[1]));
        ((TextView) this.toInflate.findViewById(predict_A3)).setText(String.valueOf(groupPA1[2]));
        ((TextView) this.toInflate.findViewById(predict_A4)).setText(String.valueOf(groupPA1[3]));

        // Prediction A - Row 2
        ((TextView) this.toInflate.findViewById(predict_lastloss_A1)).setText(String.valueOf(groupPA2[0][0]) + " · " + groupPA2[0][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_A2)).setText(String.valueOf(groupPA2[1][0]) + " · " + groupPA2[1][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_A3)).setText(String.valueOf(groupPA2[2][0]) + " · " + groupPA2[2][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_A4)).setText(String.valueOf(groupPA2[3][0]) + " · " + groupPA2[3][1]);

        // Prediction A - Row 3
        sbldr.replace(0, sbldr.length(), df.format(groupPA3[0]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_A1)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupPA3[1]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_A2)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupPA3[2]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_A3)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupPA3[3]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_A4)).setText(sbldr.toString());


        /*
        Random
        */

        // Random - Row 1
        ((TextView) this.toInflate.findViewById(predict_B1)).setText(String.valueOf(groupR1[0]));
        ((TextView) this.toInflate.findViewById(predict_B2)).setText(String.valueOf(groupR1[1]));
        ((TextView) this.toInflate.findViewById(predict_B3)).setText(String.valueOf(groupR1[2]));
        ((TextView) this.toInflate.findViewById(predict_B4)).setText(String.valueOf(groupR1[3]));

        // Random - Row 2
        ((TextView) this.toInflate.findViewById(predict_lastloss_B1)).setText(String.valueOf(groupR2[0][0]) + " · " + groupR2[0][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_B2)).setText(String.valueOf(groupR2[1][0]) + " · " + groupR2[1][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_B3)).setText(String.valueOf(groupR2[2][0]) + " · " + groupR2[2][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_B4)).setText(String.valueOf(groupR2[3][0]) + " · " + groupR2[3][1]);

        // Random - Row 3
        sbldr.replace(0, sbldr.length(), df.format(groupR3[0]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_B1)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupR3[1]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_B2)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupR3[2]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_B3)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupR3[3]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_B4)).setText(sbldr.toString());

        /*
        Prediction B
        */

        // Prediction B - Row 1
        ((TextView) this.toInflate.findViewById(predict_C1)).setText(String.valueOf(groupPB1[0]));
        ((TextView) this.toInflate.findViewById(predict_C2)).setText(String.valueOf(groupPB1[1]));
        ((TextView) this.toInflate.findViewById(predict_C3)).setText(String.valueOf(groupPB1[2]));
        ((TextView) this.toInflate.findViewById(predict_C4)).setText(String.valueOf(groupPB1[3]));

        // Prediction B - Row 2
        ((TextView) this.toInflate.findViewById(predict_lastloss_C1)).setText(String.valueOf(groupPB2[0][0]) + " · " + groupPB2[0][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_C2)).setText(String.valueOf(groupPB2[1][0]) + " · " + groupPB2[1][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_C3)).setText(String.valueOf(groupPB2[2][0]) + " · " + groupPB2[2][1]);
        ((TextView) this.toInflate.findViewById(predict_lastloss_C4)).setText(String.valueOf(groupPB2[3][0]) + " · " + groupPB2[3][1]);

        // Prediction B - Row 3
        sbldr.replace(0, sbldr.length(), df.format(groupPB3[0]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_C1)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupPB3[1]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_C2)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupPB3[2]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_C3)).setText(sbldr.toString());
        sbldr.replace(0, sbldr.length(), df.format(groupPB3[3]) + "%");
        ((TextView) this.toInflate.findViewById(predict_lastloss_percent_C4)).setText(sbldr.toString());

    }
}
