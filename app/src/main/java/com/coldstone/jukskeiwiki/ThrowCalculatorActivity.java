package com.coldstone.jukskeiwiki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.coldstone.jukskeiwiki.R;

public class ThrowCalculatorActivity extends AppCompatActivity {

    private NumberPicker npAge;
    private RadioGroup rgGender;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw_calculator);

        npAge = findViewById(R.id.npAge);
        rgGender = findViewById(R.id.rgGender);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Setup NumberPicker
        npAge.setMinValue(4);
        npAge.setMaxValue(100);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = npAge.getValue();
                int selectedGenderId = rgGender.getCheckedRadioButtonId();

                if (selectedGenderId == -1) {
                    tvResult.setText("Please select a gender.");
                    return;
                }

                RadioButton selectedGender = findViewById(selectedGenderId);
                String gender = selectedGender.getText().toString();

                // Example calculation (replace with real logic)
                double distance = calculateDistance(age, gender);

                tvResult.setText(String.format("Throwing Distance: %.0f meters", distance));
            }
        });
    }

    // Example calculation logic
    private double calculateDistance(int age, String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            if (age >= 4 && age <= 13) {
                return age; // For ages 4–13, distance equals age
            } else if (age == 14) {
                return 13;
            } else if (age == 15 || age == 16) {
                return 14;
            } else if (age == 17) {
                return 15;
            } else if (age == 18) {
                return 16;
            } else if (age >= 19 && age <= 49) {
                return 16;
            } else if (age >= 50 && age <= 64) {
                return 14;
            } else if (age > 64) {
                return 14;
            }
        } else if (gender.equalsIgnoreCase("Female")) {
            if (age >= 4 && age <= 11) {
                return age; // For ages 4–11, distance equals age
            } else if (age == 12 || age == 13 || age == 14) {
                return 12;
            } else if (age == 15 || age == 16 || age == 17) {
                return 13;
            } else if (age == 18) {
                return 14;
            } else if (age >= 19 && age <= 49) {
                return 14;
            } else if (age >= 50 && age <= 64) {
                return 12;
            } else if (age > 64) {
                return 11;
            }
        }

        // Fallback: invalid age or gender
        return 0;
    }
}
