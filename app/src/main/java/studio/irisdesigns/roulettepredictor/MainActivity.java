package studio.irisdesigns.roulettepredictor;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import studio.irisdesigns.roulettepredictor.utility.Node;
import studio.irisdesigns.roulettepredictor.utility.CircularCounter;

public class MainActivity extends AppCompatActivity {

    public static final int class_to_primary = 34;
    private static int spinCounter;
    private static ArrayList<Integer> WinHistory = new ArrayList<>(); // the last value in this list will be the 'current winning number'
    private static int currentWinningNumber;

    // Predict ROW 1
    private static int[][] P1 = {{26, 32, 5, 10}, {2, 3, 20, 33}, {1, 3, 21, 25}, {1, 2, 26, 35}, {5, 6, 19, 21}, {4, 6, 10, 24}, {4, 5, 27, 34}, {8, 9, 28, 29}, {7, 9, 23, 30}, {7, 8, 22, 31}, {11, 12, 5, 23}, {10, 12, 30, 36}, {10, 11, 28, 35}, {14, 15, 27, 36}, {13, 15, 20, 31}, {13, 14, 19, 32}, {17, 18, 24, 33}, {16, 18, 25, 34}, {16, 17, 22, 29}, {20, 21, 4, 15}, {19, 21, 1, 14}, {19, 20, 2, 4}, {23, 24, 9, 18}, {22, 24, 8, 10}, {22, 23, 5, 16}, {26, 27, 2, 17}, {25, 27, 0, 3}, {25, 26, 6, 13}, {29, 30, 7, 12}, {28, 30, 7, 18}, {28, 29, 8, 11}, {32, 33, 9, 14}, {31, 33, 0, 15}, {31, 32, 1, 16}, {35, 36, 6, 17}, {34, 36, 3, 12}, {34, 35, 11, 13}};
    private static int[][] P2 = {{26, 32, 5, 10, -1, -1, -1, -1, -1}, {2, 3, 13, 14, 15, 25, 26, 27, 0}, {1, 3, 13, 14, 15, 25, 26, 27, 0}, {1, 2, 13, 14, 15, 25, 26, 27, 0}, {5, 6, 16, 17, 18, 28, 29, 30, 0}, {4, 6, 16, 17, 18, 28, 29, 30, 0}, {4, 5, 16, 17, 18, 28, 29, 30, 0}, {8, 9, 19, 20, 21, 31, 32, 33, 0}, {7, 9, 19, 20, 21, 31, 32, 33, 0}, {7, 8, 19, 20, 21, 31, 32, 33, 0}, {11, 12, 22, 23, 24, 34, 35, 36, 0}, {10, 12, 22, 23, 24, 34, 35, 36, 0}, {10, 11, 22, 23, 24, 34, 35, 36, 0}, {1, 2, 3, 14, 15, 25, 26, 27, 0}, {1, 2, 3, 13, 15, 25, 26, 27, 0}, {1, 2, 3, 13, 14, 25, 26, 27, 0}, {4, 5, 6, 17, 18, 28, 29, 30, 0}, {4, 5, 6, 16, 18, 28, 29, 30, 0}, {4, 5, 6, 16, 17, 28, 29, 30, 0}, {7, 8, 9, 20, 21, 31, 32, 33, 0}, {7, 8, 9, 19, 21, 31, 32, 33, 0}, {7, 8, 9, 19, 20, 31, 32, 33, 0}, {10, 11, 12, 23, 24, 34, 35, 36, 0}, {10, 11, 12, 22, 24, 34, 35, 36, 0}, {10, 11, 12, 22, 23, 34, 35, 36, 0}, {1, 2, 3, 13, 14, 15, 26, 27, 0}, {1, 2, 3, 13, 14, 15, 25, 27, 0}, {1, 2, 3, 13, 14, 15, 25, 26, 0}, {4, 5, 6, 16, 17, 18, 29, 30, 0}, {4, 5, 6, 16, 17, 18, 28, 30, 0}, {4, 5, 6, 16, 17, 18, 28, 29, 0}, {7, 8, 9, 19, 20, 21, 32, 33, 0}, {7, 8, 9, 19, 20, 21, 31, 33, 0}, {7, 8, 9, 19, 20, 21, 31, 32, 0}, {10, 11, 12, 22, 23, 24, 35, 36, 0}, {10, 11, 12, 22, 23, 24, 34, 36, 0}, {10, 11, 12, 22, 23, 24, 34, 35, 0}};
    // for P3
    private static ArrayList<Node> loopCounter = (new CircularCounter().getCircularCounter());
    private static Node currentLoopCounter = loopCounter.get(0);
    private static int[][] P4 = {{20, 33}, {21, 25}, {26, 35}, {19, 21}, {10, 24}, {27, 34}, {28, 29}, {23, 30}, {22, 31}, {5, 23}, {30, 36}, {28, 35}, {27, 36}, {20, 31}, {19, 32}, {24, 33}, {25, 34}, {22, 29}, {4, 15}, {1, 14}, {2, 4}, {9, 18}, {8, 10}, {5, 16}, {2, 17}, {0, 3}, {6, 13}, {7, 12}, {7, 18}, {8, 11}, {9, 14}, {0, 15}, {1, 16}, {6, 17}, {3, 12}, {11, 13}, {26, 32}}

    // Predict ROW 3
    // for PA
    //private static ArrayList<Node> loopCounterPA = (new CircularCounter().getCircularCounter());
    private static Node currentLoopCounterPA = loopCounter.get(16);

    private static int[][] PD = {{26, 32, 3, 15, -1}, {2, 3, 4, 7, 10}, {1, 3, 5, 8, 11}, {1, 2, 6, 9, 12}, {5, 6, 1, 7, 10}, {4, 6, 2, 8, 11}, {4, 5, 3, 9, 12}, {8, 9, 1, 4, 10}, {7, 9, 2, 5, 11}, {7, 8, 3, 6, 12}, {11, 12, 1, 4, 7}, {10, 12, 2, 5, 8}, {10, 11, 3, 6, 9}, {14, 15, 16, 19, 22}, {13, 15, 17, 20, 23}, {13, 14, 18, 21, 24}, {17, 18, 13, 19, 22}, {16, 18, 14, 20, 23}, {16, 17, 15, 21, 24}, {20, 21, 13, 16, 22}, {19, 21, 14, 17, 23}, {19, 20, 15, 18, 24}, {23, 24, 13, 16, 19}, {22, 24, 14, 17, 20}, {22, 23, 15, 18, 21}, {26, 27, 28, 31, 34}, {25, 27, 29, 32, 35}, {25, 26, 30, 33, 36}, {29, 30, 25, 31, 34}, {28, 30, 26, 32, 35}, {28, 29, 27, 33, 36}, {32, 33, 25, 28, 34}, {31, 33, 26, 29, 35}, {31, 32, 27, 30, 36}, {35, 36, 25, 28, 31}, {34, 36, 26, 29, 32}, {34, 35, 27, 30, 33}};

    private static int[] groupPA1 = new int[4];
    private static int[] groupR1 = new int[4];
    private static int[] groupPB1 = new int[4];

    // Total Loss & Last Loss counter Number
    private static int[][] groupPA2 = new int[4][2];
    private static int[][] groupR2 = new int[4][2];
    private static int[][] groupPB2 = new int[4][2];

    // Loss Percentage
    private static double[] groupPA3 = new double[4];
    private static double[] groupR3 = new double[4];
    private static double[] groupPB3 = new double[4];

    // private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

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
        Log.i("OnCreate: ", "Main Activity");
    }

    @Subscribe
    public void onEvent(CalcPredict1 cp) {
        spinCounter = cp.getSpinCounter();
        WinHistory.add(cp.getWinningNumber());
        currentWinningNumber = WinHistory.get(WinHistory.size() - 1);
        /*
         * Adding a construct to limit list size of @link ArrayList<Integer> WinHistory to 37
         */
        // WinHistory.add(a);

        StringBuilder sb = new StringBuilder();
        for (int i : WinHistory) {
            sb.append(i);
            sb.append("\n");
        }
        Toast.makeText(getApplicationContext(), "sadsad" + spinCounter + " | " + WinHistory.get(WinHistory.size() - 1), Toast.LENGTH_SHORT).show();
        Log.i("Updated array list", sb.toString());
    }

    /**

    // Provisioned Undo function in case client needs it in future.
     @ Override
    public void undo() {
        // Removing the last winning number from the WinHistory ArrayList<Integer>
        if (WinHistory.size() > 0) {
            WinHistory.remove(WinHistory.size() - 1);
        }

        // Decreasing spin count by 1
        spinCounter--;

        Log.i("WinHistory & spinCount:", String.valueOf(WinHistory.size()) + " & " + spinCounter);
    }

    */

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RouletteStageFragment(), "Stage");
        adapter.addFragment(new PredictorFragment(), "Predict");
        adapter.addFragment(new StatisticsFragment(), "Stats");
        adapter.addFragment(new MethodologyFragment(), "Method");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("OnResume: ", "Main Activity");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("OnStart: ", "Main Activity");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("OnDestroy: ", "Main Activity");
    }

    private class PredictionValues extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // Primary predictions
            groupPA1 = PredictGroup1();
            groupR1 = Random1();
            groupPB1 = PredictGroup2();

            // Loss / Win
            // groupPA2
            if (currentWinningNumber == groupPA1[0]) {
                groupPA2[0][0]++;
                groupPA2[0][1] = spinCounter;
            }
            if (currentWinningNumber == groupPA1[1]) {
                groupPA2[1][0]++;
                groupPA2[1][1] = spinCounter;
            }
            if (currentWinningNumber == groupPA1[2]) {
                groupPA2[2][0]++;
                groupPA2[2][1] = spinCounter;
            }
            if (currentWinningNumber == groupPA1[3]) {
                groupPA2[3][0]++;
                groupPA2[3][1] = spinCounter;
            }

            // groupR2
            if (currentWinningNumber == groupR1[0]) {
                groupR2[0][0]++;
                groupR2[0][1] = spinCounter;
            }
            if (currentWinningNumber == groupR1[1]) {
                groupR2[1][0]++;
                groupR2[1][1] = spinCounter;
            }
            if (currentWinningNumber == groupR1[2]) {
                groupR2[2][0]++;
                groupR2[2][1] = spinCounter;
            }
            if (currentWinningNumber == groupR1[3]) {
                groupR2[3][0]++;
                groupR2[3][1] = spinCounter;
            }

            // groupPB2
            if (currentWinningNumber == groupPB1[0]) {
                groupPB2[0][0]++;
                groupPB2[0][1] = spinCounter;
            }
            if (currentWinningNumber == groupPB1[1]) {
                groupPB2[1][0]++;
                groupPB2[1][1] = spinCounter;
            }
            if (currentWinningNumber == groupPB1[2]) {
                groupPB2[2][0]++;
                groupPB2[2][1] = spinCounter;
            }
            if (currentWinningNumber == groupPB1[3]) {
                groupPB2[3][0]++;
                groupPB2[3][1] = spinCounter;
            }

            // Loss / Win · groupPA3 %
            groupPA3[0] = groupPA2[0][0] / spinCounter;
            groupPA3[1] = groupPA2[1][0] / spinCounter;
            groupPA3[2] = groupPA2[2][0] / spinCounter;
            groupPA3[3] = groupPA2[3][0] / spinCounter;

            // Loss / Win · groupR3 %
            groupR3[0] = groupR2[0][0] / spinCounter;
            groupR3[1] = groupR2[1][0] / spinCounter;
            groupR3[2] = groupR2[2][0] / spinCounter;
            groupR3[3] = groupR2[3][0] / spinCounter;

            // Loss / Win · groupPB3 %
            groupPB3[0] = groupPB2[0][0] / spinCounter;
            groupPB3[1] = groupPB2[1][0] / spinCounter;
            groupPB3[2] = groupPB2[2][0] / spinCounter;
            groupPB3[3] = groupPB2[3][0] / spinCounter;
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

        int[] PredictGroup1() {
            int predict1[] = {-1, -1, -1, -1};

            predict1[0] = P1[currentWinningNumber][(new Random()).nextInt(4)];

            do {
                predict1[1] = P2[currentWinningNumber][(new Random()).nextInt(9)];
            } while (predict1[1] == predict1[0]);

            predict1[2] = currentLoopCounter.getData();
            currentLoopCounter.setLinkNext(currentLoopCounter.getLinkNext());

            do {
                predict1[3] = P4[currentWinningNumber][(new Random()).nextInt(2)];
            }
            while (predict1[3] == predict1[0] || predict1[3] == predict1[1] || predict1[3] == predict1[2]);
            return predict1;
        }

        int[] PredictGroup2() {

            int predict2[] = {-1, -1, -1, -1};

            predict2[0] = currentLoopCounterPA.getData();
            currentLoopCounterPA.setLinkNext(currentLoopCounterPA.getLinkNext());

            do {
                predict2[1] = (new Random()).nextInt(4);
            } while (predict2[1] == predict2[0]);

            do {
                predict2[2] = (new Random()).nextInt(4);
            } while (predict2[1] == predict2[0]);

            do {
                predict2[3] = (new Random()).nextInt(37);
            }
            while (predict2[3] == predict2[0] || predict2[3] == predict2[1] || predict2[3] == predict2[2]);

            return predict2;
        }
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
