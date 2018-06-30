package com.example.stud.musicapp.favorites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.stud.musicapp.R;
import com.example.stud.musicapp.database.Favorite;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Favorite> favorites = realm.where(Favorite.class).sort("date", Sort.DESCENDING).findAll();

        if (favorites.size() > 0) {
            Toast.makeText(this, "Pobrano ulubione", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Brak ulubionych", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }
}
