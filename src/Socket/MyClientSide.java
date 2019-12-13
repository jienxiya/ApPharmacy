/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.*;
import java.net.*;

/**
 *
 * @author pallerma_sd2022
 */
public class MyClientSide {

    public static void main(String[] args) throws Exception {
        MyClientSide CLIENT = new MyClientSide();
        CLIENT.run();
    }

    public void run() throws Exception {
        Socket SOCK = new Socket("172.16.11.42", 444);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println("Hello form the other side!");
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String MESSAGE = BR.readLine();
        System.out.println(MESSAGE);
    }
}
