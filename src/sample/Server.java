package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
        public static void main(String[] args) throws IOException{
            ServerSocket ss = new ServerSocket(3306);
            Socket s = ss.accept();
            System.out.println("Client connected");

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String str = br.readLine();
            System.out.println("client :"+str);
        }
    }
