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

    public static final int class_to_primary = 34;
    private static int spinCounter;
    private static ArrayList<Integer> WinHistory = new ArrayList<>(); // the last value in this list will be the 'current winning number'
    // private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Log.i("onPageScrolled : --- ", "int i=" + i + ", float v=" + v + "int i1=" + i1);
            }

            @Override
            public void onPageSelected(int i) {
                Log.i("onPageSelected : --- ", "int i=" + i);
                // Switch case code should probably go here.
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Log.i("onPageScrollSChanged :", "int i=" + i);
            }
        });
    }

    @Override
    public void updateInfo(int a) {
        spinCounter++;

        /*
         * Adding a construct to limit list size of @link ArrayList<Integer> WinHistory to 37
         */
        WinHistory.add(a);

        StringBuilder sb = new StringBuilder();
        for (int i : WinHistory) {
            sb.append(i);
            sb.append("\n");
        }

        Log.i("Updated array list", sb.toString());
    }

    // Provisioned Undo function in case client needs it in future.
    @Override
    public void undo() {
        // Removing the last winning number from the WinHistory ArrayList<Integer>
        if (WinHistory.size() > 0) {
            WinHistory.remove(WinHistory.size() - 1);
        }

        // Decreasing spin count by 1
        spinCounter--;

        Log.i("WinHistory & spinCount:", String.valueOf(WinHistory.size()) + " & " + spinCounter);
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
