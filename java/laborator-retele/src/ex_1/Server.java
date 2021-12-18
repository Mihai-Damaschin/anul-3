package ex_1;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        Socket socket = null;

        try {
            String line = "";
            ss = new ServerSocket(79);
            socket = ss.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(
                            socket.getOutputStream())), true);

            while (line != null) {
                line = in.readLine();

                System.out.println(line);

                if (line.endsWith("CR_LF")) {
                    out.println("Server => " + line);
                }


                if (line != null) {
                    out.println("Server => ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ss.close();
            if (socket != null) socket.close();
        }
    }
}
