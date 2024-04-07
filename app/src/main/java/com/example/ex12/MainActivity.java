package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    double num1 = 0, result = 0;
    String mark = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
    }

    public void result() {
        if (ValidNum()){
            if (mark!="=") {
                num1 = Double.parseDouble(edt1.getText().toString());
            }else{
                num1=0;
            }
            if (mark=="+"){
                result=result+num1;
            }
            if (mark=="-"){
                result=result-num1;
            }
            if (mark=="*"){
                result=result*num1;
            }
            if (mark=="/" ){
                if (num1!=0){
                    result=result/num1;
                }else{
                    Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
                    result=0;
                    mark="+";
                }
            }
        }else{
            Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
            result=0;
            num1=0;
            mark="+";
        }




    }

    public boolean ValidNum(){
        String input = edt1.getText().toString();
        int counter=0;
        if (!input.isEmpty()) {
            if ((input.charAt(0) == '-' && input.length()>1) || (input.charAt(0) <= '9' && input.charAt(0) >= '0') || (input.charAt(0) == '.')) {
                if (input.charAt(0) == '.') {
                    counter++;
                }
                for (int i = 1; i < input.length(); i++) {
                    if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                        if (input.charAt(i) == '.') {
                            counter++;
                        }else{
                            return false;
                        }
                    }

                    if (counter > 1) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    public void clicked1(View view) {
        if (!edt1.getText().toString().isEmpty()){
            result();
            edt1.setText("");
        }
        mark="+";
    }


    public void clicked2(View view) {
        if (!edt1.getText().toString().isEmpty()){
            result();
            edt1.setText("");
        }
        mark="-";
    }

    public void clicked3(View view) {
        if (!edt1.getText().toString().isEmpty()) {
            result();
            edt1.setText("");
        }
        mark="*";
    }

    public void clicked4(View view) {
        if (!edt1.getText().toString().isEmpty()) {
            result();
            edt1.setText("");
        }
        mark="/";
    }

    public void clicked5(View view) {
        result = 0;
        num1 = 0;
        mark = "+";
        edt1.setText("");
    }

    public void clicked6(View view) {
        if (!edt1.getText().toString().isEmpty()) {
            num1 = Double.parseDouble(edt1.getText().toString());
            result();
        }
        edt1.setText(String.valueOf(result));
        mark = "=";
    }

    public void clicked7(View view) {
        Intent intent = new Intent(this, credits.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }
}