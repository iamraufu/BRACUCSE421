import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket ss = new ServerSocket(6666);
                System.out.println("Server is running...");
                Socket s = ss.accept();
                System.out.println("Client is connected...");

                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                PrintWriter writer = new PrintWriter(output,true);

                String today = new Date().toString();
                writer.println(today);

                ss.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
