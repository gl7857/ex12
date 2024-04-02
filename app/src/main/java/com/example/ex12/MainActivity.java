package com.example.ex12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    double num1 = 0, calculation = 0;
    String mark = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
    }

    public void result() {
        if (validNum()) {
            if (mark != "=") {
                num1 = Double.parseDouble(edt1.getText().toString());
            } else {
                num1 = 0;
            }
            if (mark == "+") {
                calculation = calculation + num1;
            }
            if (mark == "-") {
                calculation = calculation - num1;
            }
            if (mark == "*") {
                calculation = calculation * num1;
            }
            if (mark == "/") {
                if (num1 != 0) {
                    calculation = calculation / num1;
                } else {
                    Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
                    calculation = 0;
                    mark = "+";
                }
            }
        }
    }

    public boolean validNum() {
        String input = edt1.getText().toString();
        int counter = 0;
        if (!input.isEmpty()) {
            if (input.charAt(0) == '-' || (input.charAt(0) <= '9' && input.charAt(0) >= '0') || (input.charAt(0) == '.')) {
                if (input.charAt(0) == '.') {
                    counter++;
                }
                for (int i = 1; i < input.length(); i++) {
                    if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                        return false;
                    }
                    if (input.charAt(i) == '.') {
                        counter++;
                    }
                    if (counter > 1) {
                        return false;
                    }
                }
            }else {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

    public void clicked1(View view) {
        result();
        edt1.setText("");
        mark = "+";
    }

    public void clicked2(View view) {
        result();
        edt1.setText("");
        mark = "-";
    }

    public void clicked3(View view) {
        result();
        edt1.setText("");
        mark = "*";
    }

    public void clicked4(View view) {
        result();
        edt1.setText("");
        mark = "/";
    }

    public void clicked5(View view) {
        calculation = 0;
        num1 = 0;
        mark = "+";
        edt1.setText("");
    }

    public void clicked6(View view) {
        if (!edt1.getText().toString().isEmpty()) {
            num1 = Double.parseDouble(edt1.getText().toString());
            result();
            edt1.setText(String.valueOf(calculation));
            mark = "=";
        } else {
            mark = "+";
        }
    }



    public void clicked7(View view) {
        Intent intent = new Intent(this, credits.class);
        intent.putExtra("result", String.valueOf(calculation));
        startActivity(intent);
    }
}