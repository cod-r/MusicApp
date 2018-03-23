package com.example.panea.musicapp;

/**
 * Created by panea on 3/10/2018.
 */

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * {@link Songs} represents a song that the user wants to play.
 * It contains a the song name, the artist name and an image.
 */
public class Songs {

    /**
     * Artist name
     */
    private String mSongItemOne;

    /**
     * Song name
     */
    private String mSongItemTwo;

    /**
    Drawable resource ID
    */
    private int mImageResourceId;

    /**
     * Create a new Songs object.
     *
     * @param songItemOne is the name of the artist that made the song
     * @param songItemTwo   is the song name
     * @param imageResourceId is the resource of the image
     */


    public Songs(String songItemOne, String songItemTwo, int imageResourceId) {
        mSongItemOne = songItemOne;
        mSongItemTwo = songItemTwo;
        mImageResourceId = imageResourceId;

    }

    /**
     * Get the artist name.
     */
    public String getItemOne() {
        return mSongItemOne;
    }

    /**
     * Get the song name.
     */
    public String getItemTwo() {
        return mSongItemTwo;
    }

    /**
     * Get the image resource ID
     * */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
