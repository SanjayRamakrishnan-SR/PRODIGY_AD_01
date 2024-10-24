package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                display.append(button.getText().toString());
            }
        };

        int[] numberIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                           R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

        for (int id : numberIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorButtonListeners() {
        findViewById(R.id.btnAdd).setOnClickListener(operatorListener);
        findViewById(R.id.btnSub).setOnClickListener(operatorListener);
        findViewById(R.id.btnMul).setOnClickListener(operatorListener);
        findViewById(R.id.btnDiv).setOnClickListener(operatorListener);
        findViewById(R.id.btnEqual).setOnClickListener(equalListener);
        findViewById(R.id.btnClear).setOnClickListener(clearListener);
    }

    private final View.OnClickListener operatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            operator = button.getText().toString();
            num1 = Double.parseDouble(display.getText().toString());
            display.setText("");
        }
    };

    private final View.OnClickListener equalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            num2 = Double.parseDouble(display.getText().toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
        }
    };

    private final View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        }
    };
}
