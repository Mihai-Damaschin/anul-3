package ex4;

import java.io.*;

class ex4 {
    public static void main(String[] args) throws IOException {
        int n, i;
        StringBuilder line;

        FileInputStream f_in = new FileInputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex4/date.in");

        InputStreamReader fchar = new InputStreamReader(f_in);
        BufferedReader buf = new BufferedReader(fchar);

        FileOutputStream f_out = new FileOutputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex4/date.out");
        PrintStream f_out_class = new PrintStream(f_out);

        n = Integer.parseInt(buf.readLine());

        line = new StringBuilder();
        for (i = 0; i < n; i++) {
            line.append(i).append(" ");
        }

        f_out_class.println(line);

        System.out.println(buf.readLine());
    }
}