package sample;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 3306);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("hello");
        pr.flush();
    }
}
