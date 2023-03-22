package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView api;
    private RadioButton male;
    private RadioButton female;
    private EditText age;
    private EditText feet;
    private EditText inches;
    private EditText weight;
    private Button calculate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupClickListener();
    }

    private void setupClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bmiResult = bmiCalculator();
                displayResult(bmiResult);

                String ageText = age.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(bmiResult);


                } else {
                    displayGuidance(bmiResult);

                }


            }

        });


    }


    private void findViews() {
        api = findViewById(R.id.text_view);
        male = findViewById(R.id.radio_button_male);
        female = findViewById(R.id.radio_button_female);
        age = findViewById(R.id.edit_text_age);
        feet = findViewById(R.id.edit_text_feet);
        inches = findViewById(R.id.edit_text_inches);
        weight = findViewById(R.id.edit_text_weight);
        calculate = findViewById(R.id.button_calculate);
        result = findViewById(R.id.text_result);


    }

    private double bmiCalculator() {
        String feetText = feet.getText().toString();
        String inchesText = inches.getText().toString();
        String weightText = weight.getText().toString();

        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;
        double heightInMeters = totalInches * 0.0254;
        double bmi = weight / (heightInMeters * heightInMeters);
        return bmi;

    }

    private void displayResult(double bmi) {
        DecimalFormat myDecimal = new DecimalFormat("0.00");
        String bmiResultText = myDecimal.format(bmi);
        String fullDataAccess;

        if (bmi < 18.5) {
            fullDataAccess = bmiResultText + " -You are underweight! ";
        } else if (bmi > 25) {
            fullDataAccess = bmiResultText + " -You are overweight! ";
        } else {
            fullDataAccess = bmiResultText + " - You are heahlth weight! ";
        }
        result.setText(fullDataAccess);


    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimal = new DecimalFormat("0.00");
        String bmiResultText = myDecimal.format(bmi);
        String fullDataAcces;

        if (male.isChecked()){
            fullDataAcces = bmiResultText + " -as you are under 18,you have to consult with your doctor for guidance of boys! ";
        }else if (female.isChecked()) {
             fullDataAcces = bmiResultText + " -as you are under 18,you have to consult with your doctor for guidance of girls! ";

        }else {
            fullDataAcces = bmiResultText + " -as you are under 18,you have to consult with your doctor for guidance! ";
        } result.setText(fullDataAcces);



    }


}









