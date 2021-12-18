package ex3;

import java.io.*;

import java.util.*;

class ex3 {
    public static void main(String[] args) throws IOException {
        FileInputStream f = new FileInputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex3/date.in");

        InputStreamReader fchar = new InputStreamReader(f);
        BufferedReader buf = new BufferedReader(fchar);

        int m, n, i, j, s;

        String linie;

        StringTokenizer t;

        linie = buf.readLine();

        t = new StringTokenizer(linie);

        m = Integer.parseInt(t.nextToken());

        n = Integer.parseInt(t.nextToken());

        int a[][] = new int[m + 1][];

        for (i = 1; i <= m; i++) a[i] = new int[n + 1];

        for (i = 1; i <= m; i++) {

            linie = buf.readLine();

            t = new StringTokenizer(linie);

            for (j = 1; j <= n; j++) a[i][j] = Integer.parseInt(t.nextToken());

        }

        fchar.close();

        s = 0;

        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++) s += a[i][j];

        FileOutputStream g = new FileOutputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex3/date.out");
        PrintStream gchar = new PrintStream(g);

        for (i = 1; i <= m; i++) {
            linie = "";

            for (j = 1; j <= n; j++) linie = linie + " " + a[i][j];
            gchar.println(linie);
        }

        linie = "";
        linie = linie + s;

        gchar.println(linie);
        gchar.close();
    }
}