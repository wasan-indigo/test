package com.indigocorp.san.butraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // พื้นที่ ประกาศตัวแปล
    private ListView trafficListView;
    private Button aboutMeButton;

    // พื้นที่ ประกาศตัวแปล

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Button Controler
        buttonControler();

        //Create ListView
        createListView();

    }  //main method
    public  void clickExercise(View View){
            startActivity(new Intent(MainActivity.this,ExerciseActivity.class));

    }


    private void createListView() {

        //Setup Array
        final String[] strTitle = new String[20];
        strTitle[0]="ห้ามเลี้ยวซ้าย";
        strTitle[1]="ห้ามเลี่ยวขวา";
        strTitle[2]="ตรงไป";
        strTitle[3]="เลี้ยวขวา";
        strTitle[4]="เลี้ยวซ้าย";
        strTitle[5]="ทางออก";
        strTitle[6]="ทางเข้า";
        strTitle[7]="ทางออก";
        strTitle[8]="หยุด";
        strTitle[9]="จำกัดความสูง 2.5 ม.";
        strTitle[10]="ทางแยก";
        strTitle[11]="ห้ามกลับรถ";
        strTitle[12]="ห้ามจอด";
        strTitle[13]="รถวิ่งสวนทาง";
        strTitle[14]="ห้ามแซง";
        strTitle[15]="ทางเข้า";
        strTitle[16]="หยุดตรวจ";
        strTitle[17]="จำกัดความเร็ว";
        strTitle[18]="จำกัดความกว้าง";
        strTitle[19]="จำกัดความสูง 5.0 ม.";

        final int[] intIcon={R.drawable.traffic_01,R.drawable.traffic_02
                      ,R.drawable.traffic_03,R.drawable.traffic_04
                      ,R.drawable.traffic_05,R.drawable.traffic_06
                      ,R.drawable.traffic_07,R.drawable.traffic_08
                      ,R.drawable.traffic_09,R.drawable.traffic_11
                      ,R.drawable.traffic_11,R.drawable.traffic_12
                      ,R.drawable.traffic_13,R.drawable.traffic_14
                      ,R.drawable.traffic_15,R.drawable.traffic_16
                      ,R.drawable.traffic_17,R.drawable.traffic_18
                      ,R.drawable.traffic_19,R.drawable.traffic_20};


        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this,strTitle,intIcon);
        trafficListView.setAdapter(objMyAdapter);

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent objIntent = new Intent(MainActivity.this,DetailActivity.class);
                objIntent.putExtra("Title", strTitle[position]);
                objIntent.putExtra("Image", intIcon[position]);
                objIntent.putExtra("Index", position);
                startActivity(objIntent);

            }// Event click
        });

    } //Create ListView

    private void buttonControler() {
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sound ef
                MediaPlayer buttonPlayer = MediaPlayer.create(getBaseContext(), R.raw.dog);
                buttonPlayer.start();

                //Intent To Web
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("https://youtube.com"));
                startActivity(objIntent);

            }
        });
    }

    private void bindWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);
    }

}    //main class
