/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author troy
 */
import java.io.*;
import java.net.*;
public class server {
  
    /**
     * @param args the command line arguments
     */
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

            socket = server.accept();
            System.out.println("Client accepted");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            double radius = in.readDouble();
            System.out.println("The radius is " + radius);
            out.writeDouble(radius * Math.PI * 2);

            socket.close();
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }  
}
