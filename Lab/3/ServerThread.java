public class ServerThread extends Thread {
    Socket socket;

    ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        PrintWriter w = new PrintWriter(output, true);

        InputStream input = socket.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(input));

        String today = new Date().toString();
        w.println(today);

        while (true) {
            String response_from_client = r.readLine();
            if (response_from_client.equalsIgnoreCase("end game")) {
                writer.println("Good Bye!");
                break;
            } else {
                writer.println(response_from_client);
            }
        }
    }
}
