import java.io.*;
import java.net.*;
import java.util.Date;

//1. Create a basic client server program where the server that tells the client the current date and time whenever a client is connected.
public class Server {

    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(6666);
                System.out.println("Server is running...");
                Socket s = ss.accept();
                System.out.println("Client is connected...");

                new ServerThread(s).start();

                ss.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
