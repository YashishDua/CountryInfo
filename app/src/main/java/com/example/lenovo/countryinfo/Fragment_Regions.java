package com.example.lenovo.countryinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lenovo on 12-07-2016.
 */

public class Fragment_Regions extends Fragment {
    ArrayList<String> data ;
    Fragment_Regions_Adapter adapter;
    ListView listview ;
    Fragment_Regions_Listener mlistener;

    public interface Fragment_Regions_Listener{
        void regionClicked(String name);
    }

    public void Set_Fragment_Regions_Listener(Fragment_Regions_Listener listener){
        mlistener = listener;

    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_regions , container , false);
        listview = (ListView) v.findViewById(R.id.listview_fragment_regions);
        data = new ArrayList<>();
        data.add(0,"Africa");
        data.add(1,"Asia");
        data.add(2,"Europe");
        data.add(3,"America");
        adapter = new Fragment_Regions_Adapter(getActivity() , data);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("----","Item Clicked");
                Toast.makeText(getActivity() , "Not Available" , Toast.LENGTH_SHORT).show();
            //   mlistener.regionClicked(data.get(position));
            }
        });

        return v;
    }
}
