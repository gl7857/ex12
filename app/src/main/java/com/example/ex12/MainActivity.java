package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    double num1 = 0, result = 0;
    String math_sign = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
    }

    public void result() {
        if (ValidNum()){
            if (math_sign!="=") {
                num1 = Double.parseDouble(edt1.getText().toString());
            }else{
                num1=0;
            }
            if (math_sign=="+"){
                result=result+num1;
            }
            if (math_sign=="-"){
                result=result-num1;
            }
            if (math_sign=="*"){
                result=result*num1;
            }
            if (math_sign=="/" ){
                if (num1!=0){
                    result=result/num1;
                }else{
                    Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
                    result=0;
                    math_sign="+";
                }
            }
        }else{
            Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
            result=0;
            num1=0;
            math_sign="+";
        }
    }

    public boolean ValidNum() {
        String input = edt1.getText().toString();
        return !(input.equals("") ||
                input.equals("-") ||
                input.equals(".") ||
                input.equals("+") ||
                input.equals("-."));
    }

    public void clicked1(View view) {
        if (!edt1.getText().toString().isEmpty()){
            result();
            edt1.setText("");
        }
        math_sign="+";
    }

    public void clicked2(View view) {
        if (!edt1.getText().toString().isEmpty()){
            result();
            edt1.setText("");
        }
        math_sign="-";
    }

    public void clicked3(View view) {
        if (!edt1.getText().toString().isEmpty()) {
            result();
            edt1.setText("");
        }
        math_sign="*";
    }

    public void clicked4(View view) {
        if (!edt1.getText().toString().isEmpty()) {
            result();
            edt1.setText("");
        }
        math_sign="/";
    }

    public void clicked5(View view) {
        result = 0;
        num1 = 0;
        math_sign = "+";
        edt1.setText("");
    }

    public void clicked6(View view) {
        if (!edt1.getText().toString().isEmpty()) {
            num1 = Double.parseDouble(edt1.getText().toString());
            result();
        }
        edt1.setText(String.valueOf(result));
        math_sign = "=";
    }

    public void clicked7(View view) {
        Intent intent = new Intent(this, credits.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }
}