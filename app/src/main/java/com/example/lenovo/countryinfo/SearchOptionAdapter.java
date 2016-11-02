package com.example.lenovo.countryinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 10-07-2016.
 */
public class SearchOptionAdapter extends ArrayAdapter<String> {
    ArrayList<String> data;
    Context context;
    public SearchOptionAdapter(Context context,  ArrayList<String> objects) {
        super(context, 0, objects);
        this.context = context;
        data = objects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            v = LayoutInflater.from(this.context).inflate(R.layout.search_option_item,parent,false);
        }
        TextView text = (TextView) v.findViewById(R.id.textview_search_option_item);
        text.setText(data.get(position));
        return v;
    }
}
