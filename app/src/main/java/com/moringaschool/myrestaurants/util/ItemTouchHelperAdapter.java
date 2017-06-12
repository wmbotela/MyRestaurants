package com.moringaschool.myrestaurants.util;

/**
 * Created by william on 6/12/17.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);

}

