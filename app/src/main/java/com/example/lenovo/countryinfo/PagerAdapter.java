package com.example.lenovo.countryinfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Lenovo on 12-07-2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    String Titles[] = { "Home" , "Regions"};
    @Override
    public int getCount() {
        return 2;
    }

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

  /*  @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }
*/
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new Fragment_About_Page();
            case 1 : return new Fragment_Regions();
            default: break;
        }
        return null;
    }
}
