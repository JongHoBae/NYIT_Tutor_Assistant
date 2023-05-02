package com.bers.nyittutorassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.ComponentActivity;

public class AskQActivity2 extends ComponentActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask_q_activity2);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.category);
//create a list of items for the spinner.
        String[] items = new String[]{"Select Category", "For Loop", "While Loop", "Class Declaration"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Button askQ = findViewById(R.id.next);
        if(position==1) {


        }
        else if(position==2){

        }
        else if(position == 3){

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
