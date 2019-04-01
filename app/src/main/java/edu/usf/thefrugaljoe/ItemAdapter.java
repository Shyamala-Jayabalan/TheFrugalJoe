package edu.usf.thefrugaljoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflator;
    String[] items;
    String[] price;
    String[] descriptionN;

    public ItemAdapter (Context c, String[] i, String[] p, String[] d){
        items = i;
        price = p;
        descriptionN = d;
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflator.inflate(R.layout.my_search_results, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.tvName);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.tvDescription);
        TextView priceTextView = (TextView) v.findViewById(R.id.tvPrice);

        String name = items[position];
        String cost = price[position];
        String description = descriptionN[position];

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        priceTextView.setText(cost);

        return v;
    }
}
