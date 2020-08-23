package com.astra.melkovhw112;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* ListView */
        List<Design> design = Data.prepareContent(MainActivity.this);
        BaseAdapter adapter = new DesignAdapter(MainActivity.this, design);

        final ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}