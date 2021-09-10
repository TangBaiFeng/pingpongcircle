/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 * @author Troy
 * Socket Program. The client file will send a radius and height to receive the volume of the matching cylinder  
 */
import java.io.*;
import java.net.*;
public class server {
    public static void main(String args[]) {
        int port = 5000;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            // Client and streams connected
            socket = server.accept();
            System.out.println("Client accepted");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            //Assign variables 
            double radius = in.readDouble();
            double height = in.readDouble();
            double volume = Math.PI * radius * radius * height;
            //Return Variables
            out.writeDouble(radius);
            out.writeDouble(height);
            out.writeDouble(volume);
            //Close streams
            socket.close();
            in.close();
            out.close();
        } catch (Exception e) {
            //Socket Failed
            System.out.println(e);
        }

    }  
}
