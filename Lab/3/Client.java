import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost:", 6666);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            System.out.println("Response from server: " + reader.readLine());
            socket.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}