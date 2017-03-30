package com.example.purplebeen.firebasetest;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by purplebeen on 2017-01-12.
 */
//a

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);


    }
}
