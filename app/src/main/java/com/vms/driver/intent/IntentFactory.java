package com.vms.driver.intent;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;

import com.vms.driver.activities.AboutUsActivity;
import com.vms.driver.activities.DashBoardActivity;
import com.vms.driver.activities.EducationalVideoActivity;
import com.vms.driver.activities.ProfileActivity;
import com.vms.driver.activities.ReferenceCodeActivity;
import com.vms.driver.activities.SignInActivity;
import com.vms.driver.activities.SupportActivity;

public class IntentFactory {

    /**
     * return sign in activity intent
     */
    public static Intent returnSignInIntent(Context ctx){
        return new Intent(ctx, SignInActivity.class);
    }

    /**
     * start dashboard activity
     */
    public static Intent returnDashBoardActivity(Context ctx){
        return new Intent(ctx, DashBoardActivity.class);
    }

    /**
     * about us activity
     */

    public static Intent startAboutUsActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, AboutUsActivity.class);
        return moreActivity;
    }

    /**
     * support activity
     */

    public static Intent startSupportActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, SupportActivity.class);
        return moreActivity;
    }

    /**
     * educational video activity
     */

    public static Intent startEducationalVideo(Context ctx){
        Intent moreActivity = new Intent(ctx, EducationalVideoActivity.class);
        return moreActivity;
    }

    /**
     * create reference code activity
     */
    public static Intent createReferenceCodeActivity(Context context) {
        Intent intent = new Intent(context, ReferenceCodeActivity.class);
        return intent;
    }


    /**
     * create profile activity
     */
    public static Intent createProfileActivity(Context context) {
        Intent intent = new Intent(context, ProfileActivity.class);
        return intent;
    }

}
