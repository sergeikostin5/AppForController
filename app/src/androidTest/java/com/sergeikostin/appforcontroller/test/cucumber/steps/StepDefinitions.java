package com.sergeikostin.appforcontroller.test.cucumber.steps;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.sergeikostin.appforcontroller.MainActivity;
import com.sergeikostin.appforcontroller.R;
import com.sergeikostin.appforcontroller.test.cucumber.Globals;
import com.sergeikostin.appforcontroller.test.cucumber.pages.MainScreen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by sergeikostin on 2/6/16.
 */
public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    public static final String ESPRESSO_TAG = "Espresso";
    private MainScreen mCurrenScreen;

    private ServerSocket server = null;
    Socket client=null;

    DataInputStream in;
    DataOutputStream out;


    public StepDefinitions() {
        super(MainActivity.class);
        mCurrenScreen = new MainScreen();

  //      new Thread(initializeConnection).start();
        Log.d(ESPRESSO_TAG, "Instantiating connection");
        initializeConnection1();
    }


    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\" on first screen on device (\\d+)$")
    public void I_enter_and_on_first_screen_on_device(String arg1, String arg2, int device){
        if(Globals.deviceId.equals("49f2ab21ab580b49") && device == 1){
            Log.d(ESPRESSO_TAG, "Inside device 1");
            getPermission();
            onView(withId(R.id.edit_text1)).perform(typeText(arg1));
            onView(withId(R.id.edit_text2)).perform(typeText(arg2));
        }else if(Globals.deviceId.equals("9a7dce0a74306064") && device == 2){
            getPermission();
            onView(withId(R.id.edit_text1)).perform(typeText(arg1));
            onView(withId(R.id.edit_text2)).perform(typeText(arg2));
        }
    }

    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\" on second screen on device (\\d+)$")
    public void I_enter_and_on_second_screen_on_device(String arg1, String arg2, int device){
        if(Globals.deviceId.equals("49f2ab21ab580b49") && device == 1){
            Log.d(ESPRESSO_TAG, "Inside device 1");
            getPermission();
            onView(withId(R.id.edit_text3)).perform(typeText(arg1));
            onView(withId(R.id.edit_text4)).perform(typeText(arg2));
        }else if(Globals.deviceId.equals("9a7dce0a74306064") && device == 2){
            getPermission();
            onView(withId(R.id.edit_text3)).perform(typeText(arg1));
            onView(withId(R.id.edit_text4)).perform(typeText(arg2));
        }
    }

    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\" on third screen on device (\\d+)$")
    public void I_enter_and_on_third_screen_on_device(String arg1, String arg2, int device){
        if(Globals.deviceId.equals("49f2ab21ab580b49") && device == 1){
            Log.d(ESPRESSO_TAG, "Inside device 1");
            getPermission();
            onView(withId(R.id.edit_text5)).perform(typeText(arg1));
            onView(withId(R.id.edit_text6)).perform(typeText(arg2));
        }else if(Globals.deviceId.equals("9a7dce0a74306064") && device == 2){
            getPermission();
            onView(withId(R.id.edit_text5)).perform(typeText(arg1));
            onView(withId(R.id.edit_text6)).perform(typeText(arg2));
        }
    }

    public void getPermission(){
        Log.d(ESPRESSO_TAG, "waitning for permission");
        try {in.readUTF();}
        catch (IOException e) {e.printStackTrace();}
    }

    public void givePermission(){
        try {out.writeUTF("Device 2 go ahead");}
        catch (IOException e) {e.printStackTrace();}
    }

    public void initializeConnection1(){
            if(Globals.deviceId.equals("49f2ab21ab580b49")) {
                Log.d(ESPRESSO_TAG,"Creating server on 38306");
                try {server = new ServerSocket(38306);}
                catch (IOException e) {
                    Log.d(ESPRESSO_TAG,"Failed to create server on 38306");
                    e.printStackTrace();}
            }else{
                Log.d(ESPRESSO_TAG,"Creating server on 38307");
                try {server = new ServerSocket(38307);}
                catch (IOException e) {e.printStackTrace();}
            }

            try {client = server.accept();}
            catch (IOException e) {e.printStackTrace();}

            Log.d(ESPRESSO_TAG, "Accepted");

            InputStream inFromServer = null;
            try {inFromServer = client.getInputStream();}
            catch (IOException e) {e.printStackTrace();}
            in = new DataInputStream(inFromServer);

            OutputStream outToServer = null;
            try {outToServer = client.getOutputStream();
            } catch (IOException e) {e.printStackTrace();}
            out = new DataOutputStream(outToServer);
    }

    @And("^I let device (\\d+) to finish its step$")
    public void I_let_device_to_finish_its_step(int device){
        if(Globals.deviceId.equals("49f2ab21ab580b49") && device == 2){
            Log.d(ESPRESSO_TAG, "Sending permission for device 2");
            try {out.writeUTF("Device 2 go ahead");}
            catch (IOException e) {e.printStackTrace();}
        }else if(Globals.deviceId.equals("9a7dce0a74306064") && device == 1){
            try {out.writeUTF("Device 1 go ahead");}
            catch (IOException e) {e.printStackTrace();}
        }
    }


    @Then("^I press submit on first screen on device (\\d+)$")
    public void I_press_submit_on_first_screen_on_device_on_device(int device){
        if(Globals.deviceId.equals("49f2ab21ab580b49") && device == 1) {
            getPermission();
            onView(withId(R.id.button1)).perform(click());
        }else if(Globals.deviceId.equals("9a7dce0a74306064") && device == 2) {
            getPermission();
            onView(withId(R.id.button1)).perform(click());
        }
    }

    @Then("^I press submit on second screen on device (\\d+)$")
    public void I_press_submit_on_second_screen_on_device_on_device(int device){
        if(Globals.deviceId.equals("49f2ab21ab580b49") && device == 1) {
            getPermission();
            onView(withId(R.id.button2)).perform(click());
        }else if(Globals.deviceId.equals("9a7dce0a74306064") && device == 2) {
            getPermission();
            onView(withId(R.id.button2)).perform(click());
        }
    }

    @Then("^I press submit on third screen on device (\\d+)$")
    public void I_press_submit_on_third_screen_on_device_on_device(int device){
        if(Globals.deviceId.equals("49f2ab21ab580b49") && device == 1) {
            getPermission();
            onView(withId(R.id.button3)).perform(click());
        }else if(Globals.deviceId.equals("9a7dce0a74306064") && device == 2) {
            getPermission();
            onView(withId(R.id.button3)).perform(click());
        }
    }
}
