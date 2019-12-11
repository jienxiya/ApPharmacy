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
public class MyServerSide {
    public static void main(String[] args) throws Exception{
        MyServerSide SERVER = new MyServerSide();
        SERVER.run();
    }
    
    public void run() throws Exception{
        ServerSocket S_SOCK = new ServerSocket();
        Socket SOCK = new Socket("localhost", 444);
        
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println("Hello form the other side!");
        
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String MESSAGE = BR.readLine();
        System.out.println(MESSAGE);
    }
}
