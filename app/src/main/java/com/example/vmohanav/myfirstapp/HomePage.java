package com.example.vmohanav.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageButton myButton = (ImageButton) findViewById(R.id.patientRetrival);
    }
    public void patientRetrivalfunc(View button){
        Intent intent = new Intent(this, damienpost.class);
        startActivity(intent);
    }
}
