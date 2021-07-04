package com.finalproject.foodwastemanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listview extends AppCompatActivity {

    private static final String TAG = "CardListActivity";
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        getSupportActionBar().setTitle("Event List");
        listView = (ListView) findViewById(R.id.card_listView);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GuestList.class);
                startActivity(intent);
            }
        });

        cardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.list_item_card);

        for (int i = 0; i < 2; i++) {
            Card card = new Card("Event Name:  Name", "Guest count" + (i+1),"Food Item Count");
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);
    }
}