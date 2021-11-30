public class ServerThread extends Thread {
    Socket s;

    ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        PrintWriter writer = new PrintWriter(output, true);

        InputStream input = s.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String today = new Date().toString();
        writer.println(today);

        while (true) {
            String from_client = reader.readLine();
            if (from_client.equalsIgnoreCase("end game")) {
                writer.println("Good Bye!");
                break;
            } else {
                writer.println(from_client);
            }
        }
    }
}
