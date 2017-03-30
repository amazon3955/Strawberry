package com.example.purplebeen.firebasetest.models;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by purplebeen on 2017-01-12.
 */

public class Auth {

    public FirebaseAuth mAuth;
    public FirebaseUser user;
    public String userName;
    public Uri photoUrl;
    public User finalUser;
    public FirebaseAuth.AuthStateListener mAuthListener;
    private Auth() {};
    private static final Auth singleAuth = new Auth();
    public void initializing() {
        mAuth = FirebaseAuth.getInstance();
    }
    public static  Auth getSingleAuth() {
        return singleAuth;
    }


}
