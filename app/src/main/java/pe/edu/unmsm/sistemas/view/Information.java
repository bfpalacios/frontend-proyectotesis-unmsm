package pe.edu.unmsm.sistemas.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pe.edu.unmsm.sistemas.R;


public class Information extends AppCompatActivity {

    String[] lista = new String[]{};
    ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        listView = findViewById(R.id.recyclerInformation);

        lista = getResources().getStringArray(R.array.texttest);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);
        this.initConfig();
    }

    private void initConfig() {
        TextView title = findViewById(R.id.toolbar_base_text);
        title.setText("Información");
    }


}