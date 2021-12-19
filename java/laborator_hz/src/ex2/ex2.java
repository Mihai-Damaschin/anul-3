package ex2;

import java.io.*;

import java.util.*;

public class ex2 {
    public static void main(String[] args) throws IOException {
        FileInputStream f = new FileInputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex2/date.in");
        InputStreamReader fchar = new InputStreamReader(f);
        BufferedReader buf = new BufferedReader(fchar);

        int n, i, j;
        String linie;
        linie = buf.readLine();

        n = Integer.parseInt(linie);

        linie = buf.readLine();
        StringTokenizer t = new StringTokenizer(linie);

        int v[] = new int[n + 1];

        for (j = 1; j <= n; j++)
            v[j] = Integer.parseInt(t.nextToken());

        fchar.close();
        int max = 0;
        String linief = "";

        for (i = 1; i <= n; i++)
            if (v[i] > max) max = v[i];

        for (i = 1; i <= n; i++)
            if (v[i] == max) linief = linief + i + " ";

        FileOutputStream g = new FileOutputStream("/Users/mihaidamaschin/UST/anul-3/java/laborator2/src/ex2/date.out");
        PrintStream gchar = new PrintStream(g);

        linie = "";
        linie = linie + max;

        gchar.println(linie);
        gchar.println(linief);
        gchar.close();
    }
} 