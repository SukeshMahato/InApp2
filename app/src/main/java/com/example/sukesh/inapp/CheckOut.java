package com.example.sukesh.inapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckOut extends AppCompatActivity {

    String fruit,veg,flower;
    String fruitvalue[],vegvalue[],flowervalue[];
    int fr,fl,v;
    TextView fruitView,fruitprice,flowerview,flowerprice,vegview,vegprice,total,fruitQ,flowerQ,vegQ,vsno,flsno,frsno;
    Button fruitD,fruitI,flowerD,flowerI,vegD,vegI;
    int fruitQuantity=1,flowerQuantity=1,vegQantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        fruitView = (TextView)findViewById(R.id.fitem);
        fruitprice = (TextView)findViewById(R.id.fvalue);
        flowerview = (TextView)findViewById(R.id.flitem);
        flowerprice = (TextView)findViewById(R.id.flvalue);
        vegview = (TextView)findViewById(R.id.vitem);
        vegprice = (TextView)findViewById(R.id.vvalue);
        total = (TextView)findViewById(R.id.totalvalue);
        fruitQ = (TextView)findViewById(R.id.fq);
        flowerQ = (TextView)findViewById(R.id.flq);
        vegQ = (TextView)findViewById(R.id.vq);
        frsno = (TextView)findViewById(R.id.frsno);
        flsno = (TextView)findViewById(R.id.flsno);
        vsno = (TextView)findViewById(R.id.vsno);

        fruitD = (Button)findViewById(R.id.fd);
        fruitI = (Button)findViewById(R.id.fi);
        flowerD = (Button)findViewById(R.id.fld);
        flowerI = (Button)findViewById(R.id.fli);
        vegD = (Button)findViewById(R.id.vd);
        vegI = (Button)findViewById(R.id.vi);

        fruitD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fruitQuantity>1){
                    fruitQuantity-=1;
                    fruitQ.setText(fruitQuantity+"");
                    //fr=fr*fruitQuantity;
                    int t=fr*fruitQuantity+fl*flowerQuantity+v*vegQantity;
                    total.setText(t+"");
                }
            }
        });
        fruitI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    fruitQuantity+=1;
                    fruitQ.setText(fruitQuantity+"");
                //fr=fr*fruitQuantity;
                int t=fr*fruitQuantity+fl*flowerQuantity+v*vegQantity;
                total.setText(t+"");
            }
        });
        flowerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flowerQuantity>1){
                    flowerQuantity-=1;
                    flowerQ.setText(flowerQuantity+"");
                    //fl=fl*flowerQuantity;
                    int t=fr*fruitQuantity+fl*flowerQuantity+v*vegQantity;
                    total.setText(t+"");
                }
            }
        });
        flowerI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flowerQuantity+=1;
                flowerQ.setText(flowerQuantity+"");
                //fl=fl*flowerQuantity;
                int t=fr*fruitQuantity+fl*flowerQuantity+v*vegQantity;
                total.setText(t+"");
            }
        });
        vegD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vegQantity>1){
                    vegQantity-=1;
                    vegQ.setText(vegQantity+"");
                    //v=v*vegQantity;
                    int t=fr*fruitQuantity+fl*flowerQuantity+v*vegQantity;
                    total.setText(t+"");
                }
            }
        });
        vegI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vegQantity+=1;
                vegQ.setText(vegQantity+"");
                //v=v*vegQantity;
                int t=fr*fruitQuantity+fl*flowerQuantity+v*vegQantity;
                total.setText(t+"");
            }
        });




        try{
            if (getIntent().getStringExtra("check")!=null){
                fruit = getIntent().getStringExtra("fruit");
                veg = getIntent().getStringExtra("veg");
                flower = getIntent().getStringExtra("flower");
                Log.e("fruit",fruit);
                Log.e("veg",veg);
                Log.e("flower",flower);
                if (!fruit.equals("")) {
                    fruitvalue = fruit.split(" ");
                    fr = Integer.parseInt(fruitvalue[1]);
                    fruitView.setText(fruitvalue[0]);
                    fruitprice.setText(fr+"");
                }else{
                    fr=0;
                    flsno.setText("1");
                    vsno.setText("2");
                    ((LinearLayout)findViewById(R.id.fruitLayout)).setVisibility(View.GONE);
                }
                if (!veg.equals("")) {
                    vegvalue = veg.split(" ");
                    v = Integer.parseInt(vegvalue[1]);
                    vegview.setText(vegvalue[0]);
                    vegprice.setText(v+"");

                }else{
                    v=0;

                    ((LinearLayout)findViewById(R.id.vegLayout)).setVisibility(View.GONE);
                }
                if (!flower.equals("")) {
                    flowervalue = flower.split(" ");
                    fl = Integer.parseInt(flowervalue[1]);
                    flowerview.setText(flowervalue[0]);
                    flowerprice.setText(fl+"");
                }else{
                    fl=0;
                    vsno.setText("2");
                    ((LinearLayout)findViewById(R.id.flowerLayout)).setVisibility(View.GONE);
                }
                if (fr==0 && fl==0){
                    vsno.setText("1");
                }

                Log.e("fruit",fr+"");
                Log.e("veg",fl+"");
                Log.e("flower",v+"");

                int t=fr+fl+v;
                total.setText(t+"");
            }
        }catch (NullPointerException e){

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
    }
}
