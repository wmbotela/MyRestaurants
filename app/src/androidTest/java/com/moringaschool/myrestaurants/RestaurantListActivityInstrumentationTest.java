//package com.moringaschool.myrestaurants;
//
//import android.support.test.rule.ActivityTestRule;
//import android.view.View;
//
//import com.moringaschool.myrestaurants.ui.RestaurantsListActivity;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static android.support.test.espresso.Espresso.onData;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static org.hamcrest.CoreMatchers.anything;
//import static org.hamcrest.core.IsNot.not;
//
///**
// * Created by william on 5/24/17.
// */
//
//public class RestaurantListActivityInstrumentationTest {
//    @Rule
//    public ActivityTestRule<RestaurantsListActivity> activityTestRule =
//            new ActivityTestRule<>(RestaurantsListActivity.class);
//
//    @Test
//    public void listItemClickDisplaysToastWithCorrectRestaurant() {
//        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
//        String restaurantName = "Carnivore";
//        onData(anything())
//                .inAdapterView(withId(R.id.listView))
//                .atPosition(0)
//                .perform(click());
//        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
//                .check(matches(withText(restaurantName)));
//    }
//
//}
