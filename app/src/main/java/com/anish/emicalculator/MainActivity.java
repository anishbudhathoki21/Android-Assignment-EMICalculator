package com.anish.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etPrinciple, etRate, etYears;
    private TextView tvResult;
    private Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnCalculate.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        DecimalFormat output = new DecimalFormat("#.00");

        if(v.getId() == R.id.btnCalculate){
            if(isValid()){
                Double p = Double.parseDouble(etPrinciple.getText().toString());
                Double r = Double.parseDouble(etRate.getText().toString());
                Double y = Double.parseDouble(etYears.getText().toString());

                r = r / (12 * 100);
                y = y * 12;

                EMICalculator emiCalc = new EMICalculator(p, r, y);
                tvResult.setText("The monthly installment is: \n Nrs. " + output.format(emiCalc.getEmi()));
            }
            else
                showToast();
        }
    }


    private void showToast() {
        Toast.makeText(this, "Fill up all the fields", Toast.LENGTH_SHORT).show();
    }

    public void initView(){

        etPrinciple = findViewById(R.id.etPrinciple);
        etRate = findViewById(R.id.etRate);
        etYears = findViewById(R.id.etYears);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);

    }

    public boolean isValid(){
        if(etPrinciple.getText().toString().trim().isEmpty() || etRate.getText().toString().trim().isEmpty() || etYears.getText().toString().trim().isEmpty())
            return false;
        else
            return true;
    }





}