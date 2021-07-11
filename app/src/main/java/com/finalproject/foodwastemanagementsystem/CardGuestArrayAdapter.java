package com.finalproject.foodwastemanagementsystem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.finalproject.foodwastemanagementsystem.model.GuestCard;

import java.util.ArrayList;
import java.util.List;

public class CardGuestArrayAdapter extends ArrayAdapter<GuestCard> {
    private static final String TAG = "CardArrayAdapter";
    private List<GuestCard> cardList = new ArrayList<GuestCard>();
    static class CardViewHolder {
        TextView line1;
        TextView line2;
    }

    public CardGuestArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(GuestCard object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public GuestCard getItem(int index) {
        return this.cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardGuestArrayAdapter.CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.guest_list_card, parent, false);
            viewHolder = new CardGuestArrayAdapter.CardViewHolder();
            viewHolder.line1 = (TextView) row.findViewById(R.id.food_name);
            viewHolder.line2 = (TextView) row.findViewById(R.id.intereted_count);
            row.setTag(viewHolder);
        } else {
            viewHolder = (CardGuestArrayAdapter.CardViewHolder)row.getTag();
        }
        GuestCard card = getItem(position);
        viewHolder.line1.setText(card.getLine1());
        viewHolder.line2.setText(card.getLine2());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
