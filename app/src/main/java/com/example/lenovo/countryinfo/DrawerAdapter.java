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
 * Created by Lenovo on 12-07-2016.
 */
public class DrawerAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> data;
    public DrawerAdapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
        this.context = context;
        data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.drawer_list_item , parent ,false);

        TextView text = (TextView) v.findViewById(R.id.textview_drawer_item);
        text.setText(data.get(position));
        return v;
    }
}
