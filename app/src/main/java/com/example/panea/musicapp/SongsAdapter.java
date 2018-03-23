package com.example.panea.musicapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by panea on 3/19/2018.
 */

    public class SongsAdapter extends ArrayAdapter<Songs> {


        /**
         * This is our own custom constructor (it doesn't mirror a superclass constructor).
         * The context is used to inflate the layout file, and the list is the data we want
         * to populate into the lists.
         *
         * @param context     The current context. Used to inflate the layout file.
         * @param songs       A List of songs objects to display in a list
         */
        public SongsAdapter(Activity context, ArrayList<Songs> songs) {
            // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
            // the second argument is used when the ArrayAdapter is populating a single TextView.
            // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
            // going to use this second argument, so it can be any value. Here, we used 0.
            super(context, 0, songs);
        }



        /**
         * Provides a view for an AdapterView (ListView, GridView, etc.)
         *
         * @param position The position in the list of data that should be displayed in the
         *                 list item view.
         * @param convertView The recycled view to populate.
         * @param parent The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }

            // Get the {@link Songs} object located at this position in the list
            Songs currentSong = getItem(position);

            // Find the TextView in the list_item.xml layout with the ID artist_name
            TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_name);
            // Get the first item from the current Songs object and
            // set this text on the name TextView
            artistTextView.setText(currentSong.getItemOne());

            // Find the TextView in the list_item.xml layout with the ID song_name
            TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name);
            // Get the second item from the current Songs object and
            // set this text on the name TextView
            songTextView.setText(currentSong.getItemTwo());

            // Find the ImageView in the list_item.xml layout with the ID songs_image
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.songs_image);
            // Get the image resource ID from the current Songs object and
            // set the image to iconView

            iconView.setImageResource(currentSong.getImageResourceId());

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        }

    }
