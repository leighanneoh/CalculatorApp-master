package com.example.bme590.calculatorapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

import java.util.ArrayList;

import static com.example.bme590.calculatorapp.R.id.layout;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    boolean audio = false;
    ToggleButton t;
    RelativeLayout r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t= (ToggleButton) findViewById(R.id.toggleButton2);
        r = (RelativeLayout) findViewById(R.id.layout);
        t.setOnCheckedChangeListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void changestate (View v)
    {
        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    //System.out.println("Toggle On");
                    audio = true; //audio is on
                } else {
                    // The toggle is disabled
                    //System.out.println("Toggle Off");
                    audio = false;
                }
            }
        });

    }


    ArrayList<String> arrayList = new ArrayList<String>();
    String string = "";
    String string1 = "";

    public void onClick1(View v) {

        TextView textView_commands = (TextView) findViewById(R.id.textView_commands);

        Button button = (Button) v;

        string = (String) button.getText().toString();

        if (!string.contains("+") && !string.contains("-") && !string.contains("/") && !string.contains("*")) {
            string1 = string1 + string;

          /*  if (audio = true)
            {
                if (string.equals("+"))
                {
                    play plus sound
                }
                else if (string.equals("-"))
                {

                }
            } */

            if (arrayList.size() > 0) {

                arrayList.remove((arrayList.size() - 1));
            }
            arrayList.add(string1);

        } else {

            arrayList.add(string);
            arrayList.add(string);
            string1 = "";
        }


        textView_commands.setText(textView_commands.getText().toString() + string);
//        textView_commands.setText(arrayList.toString());


    }

    public void onClick(View v) {

        TextView textView_results = (TextView) findViewById(R.id.textView_results);

        int calc_result = 0;
        int calc_size = arrayList.size();

        while (calc_size != 1) {
            if (calc_size > 3) {

                if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {

                    if (arrayList.get(3).contains("*")) {
                        calc_result = Integer.parseInt(arrayList.get(2)) * Integer.parseInt(arrayList.get(4));
                    }

                    if (arrayList.get(3).contains("/")) {
                        calc_result = Integer.parseInt(arrayList.get(2)) / Integer.parseInt(arrayList.get(4));
                    }

                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.remove(2);
                    arrayList.add(2, Integer.toString(calc_result));
                    calc_size = arrayList.size();
                } else {

                    if (arrayList.get(1).contains("+")) {
                        calc_result = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(2));
                    }

                    if (arrayList.get(1).contains("-")) {
                        calc_result = Integer.parseInt(arrayList.get(0)) - Integer.parseInt(arrayList.get(2));
                    }

                    if (arrayList.get(1).contains("*")) {
                        calc_result = Integer.parseInt(arrayList.get(0)) * Integer.parseInt(arrayList.get(2));
                    }

                    if (arrayList.get(1).contains("/")) {
                        calc_result = Integer.parseInt(arrayList.get(0)) / Integer.parseInt(arrayList.get(2));
                    }

                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.add(0, Integer.toString(calc_result));
                    calc_size = arrayList.size();

                }

            } else {
                if (arrayList.get(1).contains("+")) {
                    calc_result = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(2));
                }

                if (arrayList.get(1).contains("-")) {
                    calc_result = Integer.parseInt(arrayList.get(0)) - Integer.parseInt(arrayList.get(2));
                }

                if (arrayList.get(1).contains("*")) {
                    calc_result = Integer.parseInt(arrayList.get(0)) * Integer.parseInt(arrayList.get(2));
                }

                if (arrayList.get(1).contains("/")) {
                    calc_result = Integer.parseInt(arrayList.get(0)) / Integer.parseInt(arrayList.get(2));
                }

                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.remove(0);
                arrayList.add(0, Integer.toString(calc_result));
                calc_size = arrayList.size();
            }

        }

        textView_results.setText(Integer.toString(calc_result));

    }

    public void clear(View v) {
        TextView textView_results = (TextView) findViewById(R.id.textView_results);
        TextView textView_commands = (TextView) findViewById(R.id.textView_commands);

        string1 = "";
        string = "";
        textView_results.setText("0");
        textView_commands.setText("");
        arrayList.clear();


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {
            r.setBackgroundColor(Color.rgb(86,160,211));

        }
        else
        {
            r.setBackgroundColor(Color.rgb(0,0,156));

        }

    }
};

