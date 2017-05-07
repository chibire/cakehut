package com.chibire.terence.cakehut.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.chibire.terence.cakehut.util.LruBitmapCache;

/**
 * Created by root on 4/14/17.
 */

public class App extends Application {
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;
    private static App mInstance;

    @Override
    public void onCreate() {

        super.onCreate();
        mInstance = this;
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {

        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }
}