package com.andi.seekbar_times_tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBarTimeTables = findViewById(R.id.seekbarTimeTables);
        seekBarTimeTables.setMax(20);
        seekBarTimeTables.setProgress(10);

        final ListView listViewTimeTables = findViewById(R.id.listTimeTables);

        seekBarTimeTables.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTablesNumber;

                if (progress < min) {
                    timeTablesNumber = min;
                    seekBarTimeTables.setProgress(min);
                } else {
                    timeTablesNumber = progress;
                }

                Log.i("seekbar value: ", Integer.toString(timeTablesNumber));
                ArrayList<String> timesTableContent = new ArrayList<>();

                for (int i = 1; i <= 10; i++){
                    timesTableContent.add(Integer.toString(i * timeTablesNumber));
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, timesTableContent);
                listViewTimeTables.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
