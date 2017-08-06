package studio.irisdesigns.roulettepredictor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class RouletteStageFragment extends Fragment implements View.OnClickListener {

    public RouletteStageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUserVisibleHint(false);
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
        int temp = Integer.parseInt(((Button) v.findViewById(v.getId())).getText().toString());
        CalcPredict1 cp = new CalcPredict1();
        cp.setWinningNumber(temp);
        EventBus.getDefault().post(cp);
    }

}
