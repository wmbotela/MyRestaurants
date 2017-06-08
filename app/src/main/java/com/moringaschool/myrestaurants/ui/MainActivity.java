package com.moringaschool.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.myrestaurants.Constants;
import com.moringaschool.myrestaurants.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;
    private DatabaseReference mSearchedLocationsReference;
    private ValueEventListener mSearchedLocationReferenceListener;

    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.savedRestaurantsButton) Button mSavedRestaurantsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedLocationsReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);
        mSearchedLocationsReference.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()){
                    String location = locationSnapshot.getValue().toString();
                    Log.d("Locations updated", "location: " + location);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
       Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrichregular.ttf");
       mAppNameTextView.setTypeface(ostrichFont);

        mFindRestaurantsButton.setOnClickListener(this);
        mSavedRestaurantsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();
            saveLocationToFirebase(location);
//            if(!(location).equals("")){
//            addToSharedPreferences(location);}
            Intent intent = new Intent(MainActivity.this, RestaurantsListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
        if(v == mSavedRestaurantsButton) {
            Intent intent = new Intent(MainActivity.this, SavedRestaurantListActivity.class);
            startActivity(intent);

        }
    }



    public void saveLocationToFirebase(String location){
        mSearchedLocationsReference.setValue(location);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedLocationsReference.removeEventListener(mSearchedLocationReferenceListener);
    }

//    private void addToSharedPreferences(String location){
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }
}
