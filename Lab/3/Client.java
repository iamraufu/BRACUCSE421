import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {  
            Socket s = new Socket("localhost:", 6666);
            
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Scanner sc = new Scanner (System.in);
            
            while(true){
                System.out.println("Write something to server = ");
                String user_input = sc.nextLine();
                writer.println(user_input);
                String from_server = reader.readLine();
                
                if(from_server.equalsIgnoreCase("GoodBYE!"))
                    break;
                else
                    System.out.println("Response from server: " + reader.readLine());
            }
            
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
