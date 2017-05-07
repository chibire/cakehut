package com.chibire.terence.cakehut;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * Created by root on 4/16/17.
 */

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simulateDayNight(/* DAY */ 0);
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Cake Hut is located at Lavington green shopping centre and Nairobi West shopping centre, Cake Hut prides itself in providing the highest quality and most delicious pastries, cakes, sandwiches, coffees, smoothies, juices, milkshakes among other tasty treats.\n" +
                        "\n" +
                        "A visit to Cake Hut guarantees an unforgetable experience form the friendly staff, to the cool ambience ideal for dates as well as business meetings, and of course the finger-licking good food.\n" +
                        "\n" +
                        "We maintain a very clean environment, and are thus not shy to have an open kitchen. But don’t just take our word for it, why not pay us a visit?\n" +
                        "\n" +
                        "We are open\n" +
                        "\n" +
                        "Mon-Sat 7:00am-8:30pm ,\n" +
                        "Sundays and Public holidays 9:00am-7:00pm\n" +
                        "Come experience Cake Hut today!")
                .setImage(R.drawable.logo)
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("info@cakehut.co.ke")
                .addWebsite("http://cakehut.co.ke/")
                .addFacebook("cakehutnairobi")
                .addTwitter("cakehut")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.imaya.dismas.cakehut")
                .addInstagram("cakehut_kenya")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }
}