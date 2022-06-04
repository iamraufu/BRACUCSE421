import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {  
            Socket socket = new Socket("Is running at Localhost:", 6666);
            
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Scanner sc = new Scanner (System.in);
            
            while(true){
                System.out.println("Input to server: ");
                String user_input = sc.nextLine();
                writer.println(user_input);
                String from_server = reader.readLine();
                
                if(from_server.equalsIgnoreCase("Asta La Vist!a"))
                    break;
                else
                    System.out.println("You got response: " + reader.readLine());
            }
            
            socket.close();

        } catch (Exception error) {
            System.out.println(error);
        }
    }
}
