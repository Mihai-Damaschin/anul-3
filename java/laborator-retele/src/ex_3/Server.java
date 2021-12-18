package ex_3;

import java.net.*;
import java.io.*;

public class Server {
    public static final int PORT = 7;

    void startServer() {
        try (ServerSocket ss = new ServerSocket(PORT)) {

            while (true) {
                Socket socket = ss.accept();
                new TratareClient(socket).start();
            }
        } catch (IOException ex) {
            System.err.println("Eroare :" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Server smf = new Server();
        smf.startServer();
    }
}

class TratareClient extends Thread {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    TratareClient(Socket socket) throws IOException {
        this.socket = socket;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())), true);
    }

    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str.equals("END")) break;
                System.out.println("Echoing: " + str);
                out.println(str);
            }

            System.out.println("closing...");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}
