package com.devzamse.tesis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devzamse.tesis.R;

import java.util.ArrayList;
import java.util.List;

public class Information extends AppCompatActivity {

    List<String> lista = new ArrayList();
    ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        listView = findViewById(R.id.recyclerInformation);

        lista.add(getResources().getString(R.string.text_test));
        lista.add(getResources().getString(R.string.text_test));
        lista.add(getResources().getString(R.string.text_test));
        lista.add(getResources().getString(R.string.text_test));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);

    }


}