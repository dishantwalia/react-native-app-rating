package com.apprating;

import android.content.Intent;
import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Created by punchh_dishant on 19,June,2019
 */
@ReactModule(name = "RNAppRating")
public class RNAppRating extends ReactContextBaseJavaModule {
    private ReactApplicationContext reactContext;


    public RNAppRating(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNAppRating";
    }

    @ReactMethod
    public void showAppRatingDialog(String applicationID){
        try {
            reactContext.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + applicationID)));
        } catch (android.content.ActivityNotFoundException e) {
            reactContext.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + applicationID)));
        }
    }
}
