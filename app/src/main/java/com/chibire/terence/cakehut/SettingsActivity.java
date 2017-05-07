package com.chibire.terence.cakehut;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.chibire.terence.cakehut.drawer.SettingsFragment;

/**
 * Created by root on 4/16/17.
 */

public class SettingsActivity extends ActivityBase {

    PreferenceFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        if (savedInstanceState != null) {

            fragment = (PreferenceFragment) getFragmentManager().getFragment(savedInstanceState, "currentFragment");

        } else {

            fragment = new SettingsFragment();
        }

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.settings_content, fragment).commit();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        getFragmentManager().putFragment(outState, "currentFragment", fragment);
    }
}
