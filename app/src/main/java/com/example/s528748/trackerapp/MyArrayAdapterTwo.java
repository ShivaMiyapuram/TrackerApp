package com.example.s528748.trackerapp;


import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by S528748 on 10/4/2017.
 */

public class MyArrayAdapterTwo extends ArrayAdapter {

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param resource           The resource ID for a layout file containing a layout to use when
     *                           instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects            The objects to represent in the ListView.
     */
    public MyArrayAdapterTwo(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<User> objects) {

        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = super.getView(position, convertView, parent);
        TextView tv1 = (TextView) v.findViewById(R.id.txt_email);
        ImageView iv = (ImageView) v.findViewById(R.id.imageView);
        User e = (User) getItem(position);

        tv1.setText(e.getEmail());
//        tv2.setText(e.getCount() + "");
//        //e.setRating();
//        tv3.setText(e.getRating() + "");

        return v;


    }
}
