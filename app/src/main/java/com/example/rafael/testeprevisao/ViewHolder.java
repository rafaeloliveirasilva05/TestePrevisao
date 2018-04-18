package com.example.rafael.testeprevisao;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    final TextView date;
    final TextView day;
    final TextView high;
    final TextView low;

    public ViewHolder(View view) {
        super(view);

        date = view.findViewById(R.id.list_item_data);
        day  = view.findViewById(R.id.list_item_day);
        high = view.findViewById(R.id.list_item_high);
        low  = view.findViewById(R.id.list_item_low);
    }
}
