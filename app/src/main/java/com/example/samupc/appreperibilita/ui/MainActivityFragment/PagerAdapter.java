package com.example.samupc.appreperibilita.ui.MainActivityFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by samuPC on 16/02/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int nTabs;

    public PagerAdapter(FragmentManager fm, int nTabs) {
        super(fm);
        this.nTabs = nTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                ListaImpiantiFragment listaImpianti = new ListaImpiantiFragment();
                return listaImpianti;
            }
            case 1: {
                MapFragment map = new MapFragment();
                return map;
            }
            default:{
                return null;
            }
        }


    }

    @Override
    public int getCount() {
        return nTabs;
    }
}
