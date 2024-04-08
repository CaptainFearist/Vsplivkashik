package com.example.vsplivkashik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToNextPage1(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    public void goToNextPage2(View view) {
        Intent i2 = new Intent(this, MainActivity3.class);
        startActivity(i2);
    }

    public void goToNextPage3(View view) {
        Intent i = new Intent(this, MainActivity4.class);
        startActivity(i);
    }
}