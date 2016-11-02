package com.example.lenovo.countryinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 12-07-2016.
 */
public class Fragment_Regions_Adapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> data;
    public Fragment_Regions_Adapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
        this.context = context;
        data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.region_content_item , parent ,false);
        TextView text = (TextView) v.findViewById(R.id.textview_region_content_item);
        ImageView image = (ImageView) v.findViewById(R.id.imageview_region);
        text.setText(data.get(position));
        if(position==1){
             Picasso.with(context).load("https://www.chathamhouse.org/sites/files/chathamhouse/field/field_region_page_image/map-asia_0.png").into(image);
        }
        else if(position==0){
            Picasso.with(context).load("https://www.chathamhouse.org/sites/files/chathamhouse/field/field_region_page_image/map-africa.png").into(image);

        }
        else if(position==2){
            Picasso.with(context).load("https://www.chathamhouse.org/sites/files/chathamhouse/field/field_region_page_image/map-europe.png").into(image);

        }else if(position==3){
            Picasso.with(context).load("https://www.chathamhouse.org/sites/files/chathamhouse/field/field_region_page_image/map-americas.png").into(image);

        }



        return v;

    }
}
