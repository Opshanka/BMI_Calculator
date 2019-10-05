package com.androidopshanka.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText) findViewById(R.id.weight);
        //count=(TextView) findViewById(R.id.count);
        status=(TextView) findViewById(R.id.status);
    }

    public void BMIConverter(View view){
        String heightStr=height.getText().toString();
        String weightStr=weight.getText().toString();

        if(heightStr!=null && !"".equals(heightStr) && weightStr!=null && !"".equals(weightStr)){
            float heightValue= Float.parseFloat(heightStr)/100;
            float weightValue=Float.parseFloat(weightStr);

            float bmi=weightValue/(heightValue*heightValue);
            displayBMI(bmi);
        }

    }

    private void displayBMI(float bmi){


        String bmiLabel="";
        if(bmi<=15){
            bmiLabel=getString(R.string.label_status_Very_severely_Underweight);
        }
        else if (bmi<=16){
            bmiLabel=getString(R.string.label_status_severely_Underweight);
        }
        else if (bmi<=18.5){
            bmiLabel=getString(R.string.label_status_Underweight);
        }
        else if (bmi<=25){
            bmiLabel=getString(R.string.label_status_Normal);
        }
        else if (bmi<=30){
            bmiLabel=getString(R.string.label_status_Overweight);
        }
        else if (bmi<=35){
            bmiLabel=getString(R.string.obese_class_i);
        }
        else if (bmi<=40){
            bmiLabel=getString(R.string.obese_class_ii);
        }
        else {
            bmiLabel=getString(R.string.obese_class_iii);
        }
        bmiLabel=bmi+"\n"+bmiLabel;
        status.setText((bmiLabel));
    }

}
