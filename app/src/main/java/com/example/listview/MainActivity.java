package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button addList;
    private EditText listName;
    private ListView shoppingListView;
    private ArrayList<String> shoppingList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addList = findViewById(R.id.newList);
        listName = findViewById(R.id.nameList);
        shoppingListView = findViewById(R.id.shoppingList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, shoppingList);

        shoppingListView.setAdapter(adapter);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String listItem = listName.getText().toString();
                if (listItem.isEmpty())
                    Snackbar.make(shoppingListView, "Adj nevet a listának!", Snackbar.LENGTH_LONG).show();
                else adapter.add(listItem);
            }
        });

        shoppingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray sparseBooleanArray = shoppingListView.getCheckedItemPositions();
                //adapter.remove(adapter.getItem(position));
            }
        });
    }


}