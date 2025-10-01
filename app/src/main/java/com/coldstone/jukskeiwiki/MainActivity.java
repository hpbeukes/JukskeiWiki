package com.coldstone.jukskeiwiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.splashscreen.SplashScreen; // SplashScreen API

public class MainActivity extends AppCompatActivity {

    private Button btnOpenCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenCalculator = findViewById(R.id.btnOpenCalculator);

        btnOpenCalculator.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThrowCalculatorActivity.class);
            startActivity(intent);
        });

        // Set version programmatically (optional)
        TextView tvVersion = findViewById(R.id.tvVersion);
        tvVersion.setText("Version 1.0"); // Or dynamically via BuildConfig.VERSION_NAME
    }
}