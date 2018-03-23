package com.example.panea.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout mDrawerLayout;
    public ActionBarDrawerToggle mToggle;

    // Setting up the navigation drawer
    public void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void createDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        setNavigationViewListner();
        createDrawer();

        //Create an array of songs
        ArrayList<Songs> songs = new ArrayList<Songs>();
        songs.add(new Songs("Florin Salam", "A iesit soarele din nori", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Migos", "Stir fry", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Migos", "Slippery", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Lil Forrest", "Gump", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Florin Salam", "Saint Tropez", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Adrian Minune", "Asa sunt zilele mele", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Susanu si Nicolae Guta", "Chel tu chel", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Matteo Islandezu", "Sunt talhar", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Lil Uzi Vert", "XO Tour Lif3", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Lil Pump", "Gucci Gang", R.drawable.ic_library_music_purple_600_24dp));
        songs.add(new Songs("Satra B.E.N.Z.", "Dubai", R.drawable.ic_library_music_purple_600_24dp));

        // Create an {@link SongsAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list.
        SongsAdapter adapter = new SongsAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_songs.xml and activity_albums.xml files
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each song.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {


            case R.id.albums: {
                Intent albumsIntent = new Intent(SongsActivity.this, AlbumsActivity.class);
                this.startActivity(albumsIntent);
                break;
            }
        }
        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

}


