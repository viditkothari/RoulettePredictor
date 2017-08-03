package studio.irisdesigns.roulettepredictor;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RouletteStageFragment -> newInstance} factory method to
 * create an instance of this fragment.
 */
public class RouletteStageFragment extends Fragment implements View.OnClickListener {
    /*// TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
*/
    private OnFragmentInteractionListener mListener;

    public RouletteStageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * <p>
     * param param1 Parameter 1.
     * param param2 Parameter 2.
     * return A new instance of fragment RouletteStageFragment.
     * <p>
     * // TODO: Rename and change types and number of parameters
     * public static RouletteStageFragment newInstance(String param1, String param2) {
     * RouletteStageFragment fragment = new RouletteStageFragment();
     * Bundle args = new Bundle();
     * args.putString(ARG_PARAM1, param1);
     * args.putString(ARG_PARAM2, param2);
     * fragment.setArguments(args);
     * return fragment;
     * }
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + ", OnFragmentInteractionListener missing!");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedUI = inflater.inflate(R.layout.fragment_roulette_stage, container, false);
        (inflatedUI.findViewById(R.id.btn00)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn01)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn02)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn03)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn04)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn05)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn06)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn07)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn08)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn09)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn10)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn11)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn12)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn13)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn14)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn15)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn16)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn17)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn18)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn19)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn20)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn21)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn22)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn23)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn24)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn25)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn26)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn27)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn28)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn29)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn30)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn31)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn32)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn34)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn35)).setOnClickListener(this);
        (inflatedUI.findViewById(R.id.btn36)).setOnClickListener(this);
        return inflatedUI;
    }

    @Override
    public void onClick(View v) {
        // getId for the v, cast it to Button type, get/extract its text, convert it to String, parse it into Integer type.
        mListener.updateInfo(Integer.parseInt(((Button) v.findViewById(v.getId())).getText().toString()));

/*

        @Override
        public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);
            view.findViewById(R.id.btn00).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("clicked!----", "Button 0");
                }
            });
            view.findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("clicked!----", "Button 1");
                }
            });
        }

        Can be used in to faciliate Undo / UNDO / Un Do request
        mListener.undo();

        Log.i("parseInt ------", Integer.toString(v.getId()));
        Log.i("Fragment Log: ", ((Button) v.findViewById(v.getId())).getText().toString());

        switch (v.getId()) {
            case R.id.btn00:
                Log.i("parseInt ------", Integer.toString(v.getId()));
                break;
            case R.id.btn01:
                Log.i("parseInt ------", Integer.toString(v.getId()));
                break;
        }
*/

    }
}
