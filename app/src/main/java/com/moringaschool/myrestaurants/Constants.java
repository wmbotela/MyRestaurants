package com.moringaschool.myrestaurants;

/**
 * Created by william on 6/6/17.
 */

public class Constants {
    public static final String PREFERENCES_LOCATION_KEY = "location";
    public static final String YELP_CLIENT_ID = BuildConfig.YELP_CLIENT_ID;
    public static final String YELP_CLIENT_SECRET = BuildConfig.YELP_CLIENT_SECRET;
    public static final String YELP_ACCESS_TOKEN = BuildConfig.YELP_ACCESS_TOKEN;
    public static final String YELP_BASE_URL = "https://api.yelp.com/v3/businesses/search?term=food";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";
    public static final String FIREBASE_CHILD_SEARCHED_LOCATION = "searchedLocation";
    public static final String FIREBASE_CHILD_RESTAURANTS = "restaurants";
}
