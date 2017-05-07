package com.chibire.terence.cakehut.data;

import android.content.Context;

/**
 * Created by root on 4/16/17.
 */

public class restMenu {
    public String name;
    public String imageName;
    public String price;
    public boolean isFav;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}
