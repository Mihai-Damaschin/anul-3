package ex_1;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        try {
            InetAddress address = InetAddress.getByName("localhost");

            socket = new Socket(address, 79);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream())), true);

            out.println("Client -> test");
            System.out.println(in.readLine());

            out.println("Client -> testCR_LF");
            System.out.println(in.readLine());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
