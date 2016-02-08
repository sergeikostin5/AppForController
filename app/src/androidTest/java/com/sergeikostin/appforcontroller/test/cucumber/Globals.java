package com.sergeikostin.appforcontroller.test.cucumber;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sergeikostin on 2/7/16.
 */
public class Globals {

    public static String deviceId;
    public static boolean allowed= false;

    public static ServerSocket server = null;
    public static Socket client=null;

    public static DataInputStream in = null;
    public static DataOutputStream out = null;

    public static InputStream inFromServer = null;
    public static OutputStream outToServer = null;
}
