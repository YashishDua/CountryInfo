package com.example.lenovo.countryinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 12-07-2016.
 */
public class CountryContentAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> data ;
    public CountryContentAdapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
        this.context = context;
        data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            v = LayoutInflater.from(context).inflate(R.layout.country_content_item , parent ,false);
        }

        TextView text = (TextView) v.findViewById(R.id.textview_country_content_item);
        text.setText(data.get(position));
        return v;

    }
}
