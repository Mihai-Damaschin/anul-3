package ex1;

import java.io.*;

public class ex1 {
    public static void main(String[] args) throws IOException {
        int n;

        FileInputStream f = new FileInputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex1/date.in");
        InputStreamReader fchar = new InputStreamReader(f);
        BufferedReader buf = new BufferedReader(fchar);

        n = Integer.parseInt(buf.readLine());

        FileOutputStream g = new FileOutputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex1/date.out");
        PrintStream gchar = new PrintStream(g);

        gchar.println(n * n);
        gchar.println(n * n * n);
    }
}