package com.example.admin.handlingfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener{

    private static final String RED_FRAGMENT_TAG = "RedFragment" ;
    private static final String YELLOW_FRAGMENT_TAG = "YellowFragment";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragment";
    TextView tvFromBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFromBlue = (TextView) findViewById(R.id.tvFromBlue);
    }

    public void addFragments(View view){

        switch(view.getId()) {

            case R.id.sbtn:
                RedFragment redFragment = new RedFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFrag1, redFragment, RED_FRAGMENT_TAG)
                        .addToBackStack(RED_FRAGMENT_TAG)
                        .commit();
                break;
            case R.id.ybtn:
                YellowFragment yFrag = YellowFragment.newInstance("John", "Doe");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFrag1, yFrag, YELLOW_FRAGMENT_TAG)
                        .addToBackStack(YELLOW_FRAGMENT_TAG)
                        .commit();
                break;
            case R.id.bbtn:
                BlueFragment bFrag = new BlueFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFrag1, bFrag, BLUE_FRAGMENT_TAG)
                        .addToBackStack(BLUE_FRAGMENT_TAG)
                        .commit();
                break;
        }
    }

    public void removeFragments(View view){
        switch (view.getId()) {
            case R.id.removeR:

                //if(getSupportFragmentManager().getBackStackEntryCount()>1)
                //getSupportFragmentManager().popBackStackImmediate(RED_FRAGMENT_TAG, 0);
                Fragment fragmentRed = getSupportFragmentManager().findFragmentByTag(RED_FRAGMENT_TAG);
                getSupportFragmentManager().beginTransaction()
                        .remove(fragmentRed)
                        .commit();
                break;
            case R.id.removeY:
                //getSupportFragmentManager().popBackStackImmediate();
                Fragment fragmentYellow = getSupportFragmentManager().findFragmentByTag(YELLOW_FRAGMENT_TAG);
                getSupportFragmentManager().beginTransaction()
                        .remove(fragmentYellow)
                        .commit();
                break;
            case R.id.removeB:
                //getSupportFragmentManager().popBackStackImmediate();
                Fragment fragmentBlue = getSupportFragmentManager().findFragmentByTag(BLUE_FRAGMENT_TAG);
                getSupportFragmentManager().beginTransaction()
                        .remove(fragmentBlue)
                        .commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(String string) {
        tvFromBlue.setText(string);
    }
}
