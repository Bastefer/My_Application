package com.example.myapplication;

import android.widget.Switch;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Boolean isNew = true;
    EditText editText;
    String oldNumber;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        Button buequals = findViewById(R.id.buequals);
        buequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDistance(v);
            }
        });
    }

    public void Number(View view) {
        if (isNew)
            editText.setText("");
        isNew = false;
        String number = editText.getText().toString();
        if (view.getId() == R.id.bu0) {
            number = number + "0";
        } else if (view.getId() == R.id.bu1) {
            number = number + "1";
        } else if (view.getId() == R.id.bu2) {
            number = number + "2";
        } else if (view.getId() == R.id.bu3) {
            number = number + "3";
        } else if (view.getId() == R.id.bu4) {
            number = number + "4";
        } else if (view.getId() == R.id.bu5) {
            number = number + "5";
        } else if (view.getId() == R.id.bu6) {
            number = number + "6";
        } else if (view.getId() == R.id.bu7) {
            number = number + "7";
        } else if (view.getId() == R.id.bu8) {
            number = number + "8";
        } else if (view.getId() == R.id.bu9) {
            number = number + "9";
        } else if (view.getId() == R.id.budot) {
            number = number + ".";
        }
        editText.setText(number);
    }

    // Объявите переменную для хранения исходного значения
    public void convertDistance(View view) {
        String distance = editText.getText().toString();
        double value = Double.parseDouble(distance);
        boolean isMilesEnabled = ((Switch) findViewById(R.id.swiAC)).isChecked();

        if (isMilesEnabled) {
            // Переключено на мили
            if (value > 0) {
                double miles = value * 0.621371;
                editText.setText(String.valueOf(miles));
            }
        } else {
            // Переключено на километры
            if (value > 0) {
                double kilometers = value / 0.621371;
                editText.setText(String.valueOf(kilometers));
            }
        }
    }
    private double originalValue = 0;

    public void clearDistance(View view) {
        editText.setText("0");
        isNew = true;
    }
    public void deleteCharacter(View view) {
        String currentText = editText.getText().toString();
        if (currentText.length() > 0) {
            editText.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
}
