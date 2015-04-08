package com.heidescrimeproducts.darts4dudes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tak3r07 on 4/8/15.
 */
public class ShotAdapter<String> extends ArrayAdapter<String> {

    //List holding all shots which are to be displayed
    ArrayList<String> shots;

    public ShotAdapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
        this.shots = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String shot = shots.get(position);


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_shots, parent, false);
        }
        // Lookup view for data population
        TextView shotTextView = (TextView) convertView.findViewById(R.id.textview_listitem_shot);

        // Populate the data into the template view using the data object
        shotTextView.setText((CharSequence) shot);
        // Return the completed view to render on screen
        return convertView;
    }
}
