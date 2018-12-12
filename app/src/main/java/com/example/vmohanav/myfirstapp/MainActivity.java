package com.example.vmohanav.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String msg="Android--";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg,"--------------------------------------------oncreate event--------------------------------------------");
    }
    protected void onStart(Bundle savedInstanceState){
        super.onStart();
        Log.d(msg,"--------------------------------------------onStart event---------------------------------------------");
    }

    protected void onResume(Bundle savedInstanceStage){
        super.onResume();
        Log.d(msg,"-------------------------------------------onResume event---------------------------------------------");
    }
    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "----------------------------------------The onStop() event-------------------------------------------");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "---------------------------------------The onDestroy() event-----------------------------------------");
    }
    public void sendFeedback(View button) {
        // Do click handling here
        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
        String email = emailField.getText().toString();

        final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
        String feedback = feedbackField.getText().toString();

        final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        String feedbackType = feedbackSpinner.getSelectedItem().toString();

        final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
        boolean bRequiresResponse = responseCheckbox.isChecked();

        Log.d(msg,"****************"+name+email+feedback+feedbackType+bRequiresResponse+"*****************");
    }
}
