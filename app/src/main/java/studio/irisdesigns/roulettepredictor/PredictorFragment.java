package studio.irisdesigns.roulettepredictor;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PredictorFragment OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PredictorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PredictorFragment extends Fragment {

    CalcPredict1 cp = new CalcPredict1();
    // private OnFragmentInteractionListener mListener;
    private int spinCounter = -1;
    private View toInflate;


    public PredictorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * param param1 Parameter 1.
     * param param2 Parameter 2.
     * return A new instance of fragment PredictorFragment.

    // TODO: Rename and change types and number of parameters
    public static PredictorFragment newInstance(String param1, String param2) {
        PredictorFragment fragment = new PredictorFragment();
     Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
     fragment.setArguments(args);
        return fragment;
    }
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUserVisibleHint(false);
        Log.i("OnCreate: ", "Predictor Fragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.toInflate = inflater.inflate(R.layout.fragment_predictor, container, false);
        Log.i("Testing a view: ~", ((TextView) toInflate.findViewById(R.id.predict_A1)).getText().toString());
        ((TextView) this.toInflate.findViewById(R.id.predict_A1)).setText("Away");

        Log.i("OnCreateView: ", "Predictor Fragment");
        return this.toInflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);/*

        CalcPredict1 c=new CalcPredict1();
        int randomVals[] = c.Random1();
        ((TextView)view.findViewById(R.id.randomplaceholder1)).setText(String.valueOf(randomVals[0]));
        ((TextView)view.findViewById(R.id.randomplaceholder2)).setText(String.valueOf(randomVals[1]));
        ((TextView)view.findViewById(R.id.randomplaceholder3)).setText(String.valueOf(randomVals[2]));
        ((TextView)view.findViewById(R.id.randomplaceholder4)).setText(String.valueOf(randomVals[3]));

        // Create an array of 38 numbers (0-36) + 1 number to save the spinCount (which will work as a flag to see if user is coming to this screen with a new spin
        savedInstanceState.putIntArray("randomArray",randomVals);*/
    }

    @Override
    public void onResume() {
        super.onResume();
        if (spinCounter != cp.getSpinCounter()) {
            spinCounter = cp.getSpinCounter();
            int randomVals[] = Random1();
            ((TextView) toInflate.findViewById(R.id.predict_B1)).setText(String.valueOf(randomVals[0]));
            ((TextView) toInflate.findViewById(R.id.predict_B2)).setText(String.valueOf(randomVals[1]));
            ((TextView) toInflate.findViewById(R.id.predict_B3)).setText(String.valueOf(randomVals[2]));
            ((TextView) toInflate.findViewById(R.id.predict_B4)).setText(String.valueOf(randomVals[3]));
            Log.d("Reached: ", " onEvent_Predictor");
            Log.i("OnResume: ", "Predictor Fragment");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("OnPause: ", "Predictor Fragment");
    }

    @Subscribe
    public void onEvent(CalcPredict1 cp) {
        this.cp = cp;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("OnStart: ", "Predictor Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("OnDestroy: ", "Predictor Fragment");
    }
}
