package com.indigocorp.san.butraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //Dim
    private TextView titalTextView,detailTextView;
    private ImageView trafficImagrView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindWidget();

        // Receiver Values friom intent

        receiverFromIntent();

    } //Main Mathod

    private void receiverFromIntent() {
        String strTitle =getIntent().getStringExtra("Title");
        titalTextView.setText(strTitle);

        int intImage = getIntent().getIntExtra("Image", R.drawable.traffic_01);
        trafficImagrView.setImageResource(intImage);

        String[] strDetail = getResources().getStringArray(R.array.detail);
        int intIndex = getIntent().getIntExtra("Index", 0);
        detailTextView.setText(strDetail[intIndex]);



    }


    private void bindWidget() {
        titalTextView = (TextView) findViewById(R.id.textView3);
        detailTextView = (TextView) findViewById(R.id.textView4);
        trafficImagrView = (ImageView) findViewById(R.id.imageView2);
    }

}  //Main Class
