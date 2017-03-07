package com.example.sukesh.inapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String fruitvalue,vegvalue,flowervalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button checkout = (Button)findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup rg = (RadioGroup)findViewById(R.id.fruitgroup);
                try {
                      fruitvalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                }catch (NullPointerException e){
                    fruitvalue="";
                }
                RadioGroup rg1 = (RadioGroup)findViewById(R.id.vegeGroup);
                try {
                    vegvalue = ((RadioButton) findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
                }catch(NullPointerException e){
                    vegvalue="";
                }
                RadioGroup rg2 = (RadioGroup)findViewById(R.id.flowergroup);
                try {
                    flowervalue = ((RadioButton) findViewById(rg2.getCheckedRadioButtonId())).getText().toString();
                }catch(NullPointerException e){
                    flowervalue="";
                }
                if (fruitvalue.isEmpty() && vegvalue.isEmpty() && flowervalue.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Select atleast one item!",Toast.LENGTH_SHORT).show();
                }else {


                    Intent intent = new Intent(MainActivity.this, CheckOut.class);
                    intent.putExtra("fruit", fruitvalue);
                    intent.putExtra("veg", vegvalue);
                    intent.putExtra("flower", flowervalue);
                    intent.putExtra("check", "one");
                    startActivity(intent);
                }
            }
        });
    }
}
