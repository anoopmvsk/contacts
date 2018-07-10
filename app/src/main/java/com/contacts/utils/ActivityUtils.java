package com.contacts.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by anoop on 6/8/18.
 */

public class ActivityUtils {
    /**
     * Add the given fragment to given fragmentid
     *
     * @param fragmentManager
     * @param fragment
     * @param fragmentId
     */
    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment, int fragmentId) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragmentId, fragment);
        fragmentTransaction.commit();
    }
}
