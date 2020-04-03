package com.example.smartpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SmartPosts smartPosts = SmartPosts.getInstance();

    private TextView textViewSpinner;
    private TextView textView;
    private Spinner spinner;
    SmartPostInfo choice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
        final ArrayList<SmartPostInfo> post = smartPosts.getSmartList();

        ArrayAdapter<SmartPostInfo> smartPostInfoArrayAdapter = new ArrayAdapter<SmartPostInfo>(this, android.R.layout.simple_spinner_item,smartPosts.getSmartList());
        smartPostInfoArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(smartPostInfoArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choice = post.get(position);
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: "+ item, Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}



