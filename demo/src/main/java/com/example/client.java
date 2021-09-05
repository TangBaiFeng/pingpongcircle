package com.example;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author troy
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int port = 5000;
        String host = "127.0.0.1";
        DataInputStream in;
        DataOutputStream out;
        Socket socket;
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Trying connection . . .");
            socket = new Socket(host, port);
            System.out.println("Connected");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("What is the radius?");
            out.writeDouble(reader.nextDouble());
            System.out.println("The circumference is " + in.readDouble());

            socket.close();
            reader.close();
            in.close();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
