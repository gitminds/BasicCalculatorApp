package com.training.magiccalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText result;
    private EditText enternewNumber;
    private TextView displayOperation;

    //variables for calculations
    private Double operand1 = null;
    private Double operand2 = null;
    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.results);
        enternewNumber = (EditText) findViewById(R.id.newNumber);
        displayOperation = (TextView) findViewById(R.id.operationdtl);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        Button buttonDecimal = (Button) findViewById(R.id.buttonDecimal);
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonDevide = (Button) findViewById(R.id.buttonDevide);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button buttonAllClear = (Button) findViewById(R.id.buttonAllClear);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                enternewNumber.append(b.getText().toString());
            }
        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDecimal.setOnClickListener(listener);


        View.OnClickListener oplistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = enternewNumber.getText().toString();
                if (value.length() != 0) {
                    performOperation(value, op);
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };

        buttonPlus.setOnClickListener(oplistener);
        buttonMinus.setOnClickListener(oplistener);
        buttonMultiply.setOnClickListener(oplistener);
        buttonDevide.setOnClickListener(oplistener);
        buttonEqual.setOnClickListener(oplistener);

        View.OnClickListener clearlistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand1 = null;
                operand2 = null;
                enternewNumber.setText("");
                displayOperation.setText("");
                result.setText("");
            }
        };
        buttonAllClear.setOnClickListener(clearlistener);
    }

    private void performOperation(String value, String operation) {
        if (null == operand1) {
            operand1 = Double.valueOf(value);
        } else {
            operand2 = Double.valueOf(value);
            if (pendingOperation.equals("=")) {
                pendingOperation = operation;
            }
            switch (pendingOperation) {
                case "=":
                    operand1 = operand2;
                    break;
                case "+":
                    operand1 += operand2;
                    break;
                case "-":
                    operand1 -= operand2;
                    break;
                case "*":
                    operand1 *= operand2;
                    break;
                case "/":
                    if (operand2 == 0) {
                        operand1 = 0.0;
                    } else {
                        operand1 /= operand2;
                    }
                    break;
            }
        }
        result.setText(operand1.toString());
        enternewNumber.setText("");
    }


}