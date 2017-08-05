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
    // private OnFragmentInteractionListener mListener;
    private static int spinCounter = -1;

    public PredictorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PredictorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PredictorFragment newInstance(String param1, String param2) {
        PredictorFragment fragment = new PredictorFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUserVisibleHint(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View toInflate = inflater.inflate(R.layout.fragment_predictor, container, false);
        Log.i("Testing a view: ~", ((TextView) toInflate.findViewById(R.id.predict_A1)).getText().toString());
        ((TextView) toInflate.findViewById(R.id.predict_A1)).setText("sdsd");
        return toInflate;
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

    }

    public void initilizeValues(int spinCounter) {
        PredictorFragment.spinCounter = spinCounter;
    }

    private class PredictionValues extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return "0";
        }

        @Override
        protected void onPostExecute(String result) {

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
}
