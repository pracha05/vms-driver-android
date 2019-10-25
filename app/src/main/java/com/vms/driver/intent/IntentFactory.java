package com.vms.driver.intent;

import android.content.Context;
import android.content.Intent;

import com.vms.driver.activities.SignInActivity;

public class IntentFactory {

    /**
     * return sign in activity intent
     */
    public static Intent returnSignInIntent(Context ctx){
        return new Intent(ctx, SignInActivity.class);
    }
}