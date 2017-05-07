package com.chibire.terence.cakehut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chibire.terence.cakehut.drawer.FeedbackFragment;
import com.chibire.terence.cakehut.drawer.FragmentDrawer;
import com.chibire.terence.cakehut.drawer.HomeFragment;
import com.chibire.terence.cakehut.drawer.LogoutActivity;
import com.chibire.terence.cakehut.drawer.OrdersFragment;
import com.chibire.terence.cakehut.drawer.OurProductsFragment;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    public Toolbar mToolbar;

    private FragmentDrawer drawerFragment;

    // used to store app title
    private CharSequence mTitle;
    Fragment fragment;
    private Boolean restore = false;
    Boolean action = false;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {

            //Restore the fragment's instance
            fragment = getSupportFragmentManager().getFragment(savedInstanceState, "currentFragment");

            restore = savedInstanceState.getBoolean("restore");
            mTitle = savedInstanceState.getString("mTitle");

        } else {

            fragment = new Fragment();

            restore = false;
            mTitle = getString(R.string.app_name);
        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(mTitle);

        drawerFragment = (FragmentDrawer) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        if (!restore) {

            displayView(1);
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putBoolean("restore", true);
        outState.putString("mTitle", getSupportActionBar().getTitle().toString());
        getSupportFragmentManager().putFragment(outState, "currentFragment", fragment);
    }
    @Override
    public void onDrawerItemSelected(View view, int position) {

        displayView(position);
    }

    private void displayView(int position) {

        action = false;

        switch (position) {

            case 0: {

                break;
            }
            case 1: {

                page = 1;
                fragment = new HomeFragment();
                getSupportActionBar().setTitle(R.string.page_1);


                action = true;

                break;
            }
            case 2: {

                page = 2;

                fragment = new OurProductsFragment();
                getSupportActionBar().setTitle(R.string.page_2);

                action = true;

                break;
            }

            case 3: {

                page = 3;

                fragment = new OrdersFragment();
                getSupportActionBar().setTitle(R.string.page_3);
                action = true;

                break;
            }

            case 4: {

                page = 4;

                fragment = new FeedbackFragment();
                getSupportActionBar().setTitle(R.string.page_4);
                action = true;

                break;
            }

            case 5: {

                Intent settings = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(settings);

                break;
            }
            case 6: {

                Intent i = new Intent(MainActivity.this, LogoutActivity.class);
                startActivity(i);
                finish();
                break;
            }

            default: {

                Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settings);
            }
        }
        if (action) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_body, fragment)
                    .commit();
        }
    }
    @Override
    public void onBackPressed() {

        if (drawerFragment.isDrawerOpen()) {

            drawerFragment.closeDrawer();

        } else {

            super.onBackPressed();
        }
    }

    @Override
    public void setTitle(CharSequence title) {

        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }
}
