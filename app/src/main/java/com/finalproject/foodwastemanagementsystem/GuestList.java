package com.finalproject.foodwastemanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.finalproject.foodwastemanagementsystem.model.GuestCard;
import com.google.firebase.auth.FirebaseAuth;

public class GuestList extends AppCompatActivity {
    private static final String TAG = "GuestListActivity";
    private CardGuestArrayAdapter cardArrayAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_list);
        getSupportActionBar().setTitle("Food List");
        listView = (ListView) findViewById(R.id.guest_list);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

        cardArrayAdapter = new CardGuestArrayAdapter(getApplicationContext(), R.layout.guest_list_card);

        for (int i = 0; i < 2; i++) {
            GuestCard card = new GuestCard("Food Name:  Name","Guest Interesed 1");
            cardArrayAdapter.add(card);
        }
        listView.setAdapter(cardArrayAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflowmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.LogOut) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}