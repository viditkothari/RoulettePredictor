package studio.irisdesigns.roulettepredictor;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    // private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int spinCounter;
    private ArrayList<Integer> currentWin = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Code for the UI starts
         */
        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        try {
        Log.i("tabl_0", (tabLayout.getTabAt(0)).toString());
            tabLayout.getTabAt(0).setIcon(R.drawable.dice);
            tabLayout.getTabAt(1).setIcon(R.drawable.predict);
            tabLayout.getTabAt(2).setIcon(R.drawable.stats);
            tabLayout.getTabAt(3).setIcon(R.drawable.gear);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabLayout.setSelectedTabIndicatorHeight(16);
        // tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_green_dark));
        /*
         * Code for the UI ends
         */
    }

    @Override
    public void updateInfo(int a) {
        this.spinCounter++;
        this.currentWin.add(a);
        /*Log.i("updateInfo:",Integer.toString(a) + " &&& " + currentWin.size());
        Log.i("Size of currentWin:", String.valueOf(currentWin.size()));*/
    }

    @Override
    public void undo() {
        Log.i("Size of currentWin:", String.valueOf(currentWin.size()));
        if (currentWin.size() > 0) {
            currentWin.remove(currentWin.size() - 1);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RouletteStageFragment(), "Stage");
        adapter.addFragment(new PredictorFragment(), "Predict");
        adapter.addFragment(new StatisticsFragment(), "Stats");
        adapter.addFragment(new MethodologyFragment(), "Method");
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        // private final List<String> mFragmentTitleList = new ArrayList<>();

        private ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        private void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            // mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            /* Un-comment the statement below to display Page title on the Tabs / headers */
            // return mFragmentTitleList.get(position);
            return null;
        }
    }
}
