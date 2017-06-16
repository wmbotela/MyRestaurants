package com.moringaschool.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;

import com.moringaschool.myrestaurants.Constants;
import com.moringaschool.myrestaurants.R;
import com.moringaschool.myrestaurants.adapters.RestaurantListAdapter;
import com.moringaschool.myrestaurants.models.Restaurant;
import com.moringaschool.myrestaurants.services.YelpService;
import com.moringaschool.myrestaurants.util.OnRestaurantSelectedListener;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantsListActivity extends AppCompatActivity implements OnRestaurantSelectedListener {
    private Integer mPosition;
    ArrayList<Restaurant>mRestaurants;
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;
//    private String mRecentAdress;


//    public static final String TAG = RestaurantsListActivity.class.getSimpleName();

//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
//
//    private RestaurantListAdapter mAdapter;
//
//    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        if (savedInstanceState != null) {

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                mPosition = savedInstanceState.getInt(Constants.EXTRA_KEY_POSITION);
                mRestaurants = Parcels.unwrap(savedInstanceState.getParcelable(Constants.EXTRA_KEY_RESTAURANTS));

                if (mPosition != null && mRestaurants != null) {
                    Intent intent = new Intent(this, RestaurantDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition);
                    intent.putExtra(Constants.EXTRA_KEY_RESTAURANTS, Parcels.wrap(mRestaurants));
                    startActivity(intent);
                }

            }

        }

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mPosition != null && mRestaurants != null) {
            outState.putInt(Constants.EXTRA_KEY_POSITION, mPosition);
            outState.putParcelable(Constants.EXTRA_KEY_RESTAURANTS, Parcels.wrap(mRestaurants));
        }

    }

    @Override
    public void onRestaurantSelected(Integer position, ArrayList<Restaurant> restaurants) {
        mPosition = position;
        mRestaurants = restaurants;
    }
//        ButterKnife.bind(this);

//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");
//
//        getRestaurants(location);
//
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAdress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
//        if (mRecentAdress !=null){
//            getRestaurants(mRecentAdress);
//        }
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search, menu);
//        ButterKnife.bind(this);
//
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                addToSharedPreferences(query);
//                getRestaurants(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//
//        });
//        return true;
//    }
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void getRestaurants(String location) {
//        final YelpService yelpService = new YelpService();
//
//        yelpService.findRestaurants(location, new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                mRestaurants = yelpService.processResults(response);
//
//                RestaurantsListActivity.this.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        mAdapter = new RestaurantListAdapter(getApplicationContext(), mRestaurants);
//                        mRecyclerView.setAdapter(mAdapter);
//                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantsListActivity.this);
//                        mRecyclerView.setLayoutManager(layoutManager);
//                        mRecyclerView.setHasFixedSize(true);
//                    }
//                });
//            }
//        });
//    }
//
//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }
}