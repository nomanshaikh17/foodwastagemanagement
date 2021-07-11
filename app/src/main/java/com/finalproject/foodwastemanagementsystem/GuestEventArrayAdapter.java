package com.finalproject.foodwastemanagementsystem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.finalproject.foodwastemanagementsystem.model.guestEventCard;

import java.util.ArrayList;
import java.util.List;

public class GuestEventArrayAdapter extends ArrayAdapter<guestEventCard> {
    private static final String TAG = "CardArrayAdapter";
    private List<guestEventCard> cardList = new ArrayList<guestEventCard>();

    static class CardViewHolder {
        TextView line1;
    }

    public GuestEventArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(guestEventCard object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public guestEventCard getItem(int index) {
        return this.cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        GuestEventArrayAdapter.CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.guest_event_list, parent, false);
            viewHolder = new GuestEventArrayAdapter.CardViewHolder();
            viewHolder.line1 = (TextView) row.findViewById(R.id.guest_eventName);
            row.setTag(viewHolder);
        } else {
            viewHolder = (GuestEventArrayAdapter.CardViewHolder)row.getTag();
        }
        guestEventCard card = getItem(position);
        viewHolder.line1.setText(card.getLine1());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
