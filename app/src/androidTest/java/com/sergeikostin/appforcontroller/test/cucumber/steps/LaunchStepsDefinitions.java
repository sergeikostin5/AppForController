package com.sergeikostin.appforcontroller.test.cucumber.steps;

import android.content.Context;
import android.provider.Settings;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.sergeikostin.appforcontroller.MainActivity;
import com.sergeikostin.appforcontroller.test.cucumber.ActivityFinisher;
import com.sergeikostin.appforcontroller.test.cucumber.Globals;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by sergeikostin on 2/6/16.
 */
public class LaunchStepsDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    public static final String TAG = "Espresso";

    private Context mInstrumentationContext;

    private MainActivity mActivity;

    private Context mAppContext;

    public LaunchStepsDefinitions() {
        super(MainActivity.class);
        Log.d(TAG, "Launch Screen constructor called");
    }

    @Before
    public void setUp() throws Exception {
        Log.d(TAG, "setup");
        super.setUp();

        mInstrumentationContext = getInstrumentation().getContext();
        mAppContext = getInstrumentation().getTargetContext();

        Globals.deviceId = Settings.Secure.getString(mAppContext.getContentResolver(), Settings.Secure.ANDROID_ID);

        if(Globals.deviceId.equals("49f2ab21ab580b49")) {
            Globals.allowed = true;
        }

        mActivity = getActivity(); // Start Activity before each test scenario
        assertNotNull(mActivity);
    }

    @After
    public void tearDown() throws Exception {
        //TODO
        Log.d(TAG, "teardown");
        ActivityFinisher.finishOpenActivities(); // Required for testing App with multiple activities
        // All the clean up of application's data and state after each scenario must happen here
        super.tearDown(); // This step scrubs everything in this class so always call it last
    }
}
