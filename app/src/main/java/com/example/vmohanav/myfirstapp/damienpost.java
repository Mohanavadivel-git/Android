package com.example.vmohanav.myfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class damienpost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damienpost);
    }

    public void submitclick(View button){
        postrequest();
    }

    public void postrequest(){
        String url = "https://webapp-181209061846.azurewebsites.net/Leprosy/";
        Log.e("request:","request started");
        RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        JSONObject json = new JSONObject();
        //TextView StateName = (TextView) findViewById(R.id.StateText);
        Log.e("request:","correct response");
        try {
            TextView PatientName = (TextView) findViewById(R.id.NameText);
            String content = PatientName.getText().toString();
            Log.e("request:","---------------"+content);
            json.put("Name",content);
            //json.put("state",StateName.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest (Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.
                Log.e("request:","correct response");
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Profile updated successfully",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //This code is executed if there is an error.
                Log.e("request:","Incorrect response");
                Toast toast = Toast.makeText(getApplicationContext(),
                        error.toString(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        MyRequestQueue.add(jsonObjectRequest );
    }
}
