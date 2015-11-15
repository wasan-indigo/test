package com.indigocorp.san.butraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by student on 11/14/2015.
 */
public class MyAdapter extends BaseAdapter {

    //ประกาศตัวแปล
    private Context objContact;
    private String[] titelStrings;
    private int[] iconInts;

    public MyAdapter(Context objContact, String[] titelStrings, int[] iconInts) {
        this.objContact = objContact;
        this.titelStrings = titelStrings;
        this.iconInts = iconInts;
    } //Constructor

    @Override
    public int getCount() {
        return titelStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContact.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.my_listview,parent,false);
        //Setup Title
        TextView titleTextView = (TextView) objView1.findViewById(R.id.textView2);
        titleTextView.setText(titelStrings[position]);
        //titleTextView.setText(titelStrings[**int position**]);

        //Setup Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imageView);
        iconImageView.setImageResource(iconInts[position]);

        return objView1;
    }
} // Main Class
