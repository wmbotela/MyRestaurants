package com.moringaschool.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;

    private String[] restaurants = new String[] {"Carnivore", "Brew Bistro",
            "About Thyme", "Rendez-Vous", "Asmara", "Cake City",
            "Caramel", "Mama Rocks", "Nyama Mama", "Big Square",
            "Spur", "Tamarind", "Mayura", "Artcaffe", "Bobos"};

    private String[] cuisines = new String[] {"BBQ", "Fast Food", "Fishs n Dishs","Vegan", "Breakfast", "Cakes",
            "Drinks","BBQ", "Dishs","Fast Food", "BBQ", "Fishs n Dishs", "Dishes", "Breakfast", "Fast Food"};
//    public static final String TAG = RestaurantsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near: " + location);


    }
}
