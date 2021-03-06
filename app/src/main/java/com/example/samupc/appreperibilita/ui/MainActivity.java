package com.example.samupc.appreperibilita.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.samupc.appreperibilita.R;
import com.example.samupc.appreperibilita.logic.LocationSystem;
import com.example.samupc.appreperibilita.logic.SetMap;
import com.example.samupc.appreperibilita.ui.MainActivityFragment.PagerAdapter;
import com.google.android.gms.maps.GoogleMap;

import static com.example.samupc.appreperibilita.logic.LocationSystem.REQUEST_FINE_LOCATION;


public class MainActivity extends AppCompatActivity implements SetMap {


    private GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.RL);  //relative layout contenente il viewpager per i fragment
        resetPaddingSliderBar(rl);
        createTabSlider(tabLayout);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    //metodi localizzazione


    //fine


    //correzzione padding top dei fragment sulla main activity
    private void resetPaddingSliderBar(RelativeLayout rl) {
        //acquisizione valori dimensioni standar di un'action bar
        //https://stackoverflow.com/questions/7165830/what-is-the-size-of-actionbar-in-pixels
        final TypedArray styledAttributes = this.getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        int mActionBarSize = (int) styledAttributes.getDimension(0, 0);

        rl.setPadding(rl.getPaddingLeft(), mActionBarSize, rl.getPaddingRight(), rl.getPaddingBottom());

    }

    //generazione della finestra slider con aggiunte tab, gestione delle tab lasciata al
    //pager adapter
    private void createTabSlider(TabLayout tabLayout) {

        tabLayout.addTab(tabLayout.newTab().setText("Lista Impianti"));
        tabLayout.addTab(tabLayout.newTab().setText("Mappa"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }




    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        switch (requestCode) {
            case REQUEST_FINE_LOCATION : {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    LocationSystem locationSystem = new LocationSystem(this, this);
                    map.getUiSettings().setMyLocationButtonEnabled(true);
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    map.setMyLocationEnabled(true);
                    locationSystem.startLocationUpdates();

                    Button button = findViewById(R.id.buttonStartLocation);
                    button.setVisibility(View.GONE);
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    Log.i("@TEST", "FALSE");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    @Override
    public void setMap(GoogleMap map) {
        this.map=map;
    }
}

