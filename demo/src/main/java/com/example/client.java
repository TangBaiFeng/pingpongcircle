package com.example;
 /**
  * @author Troy Boone
  * Socket Program. The client file will send a radius and height to receive the volume of the matching cylinder  
  */
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client {
    
    public static void main(String args[]) {
        int port = 5000;
        String host = "127.0.0.1";
        DataInputStream in;
        DataOutputStream out;
        Socket socket;
        Scanner reader = new Scanner(System.in);
        System.out.println("Trying connection . . .");
        try {
            //Try and connect to server and streams
            socket = new Socket(host, port);
            System.out.println("Connected");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            //Send details
            System.out.println("What is the radius?");
            out.writeDouble(reader.nextDouble());
            System.out.println("What is the height?");
            out.writeDouble(reader.nextDouble());
            //Receive details
            System.out.println("The radius is " + in.readDouble());
            System.out.println("The height is " + in.readDouble());
            System.out.println("The volume is " + in.readDouble());

            //Close all the streams
            socket.close();
            reader.close();
            in.close();
            out.close();

        } catch (Exception e) {
            //Connection Failed
            System.out.println(e);
        }

    }
}
