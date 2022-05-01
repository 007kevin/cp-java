import java.io.*;
import java.util.*;

/**
 * Problem   = cf276A
 * Date      = Sat Apr 30 21:25:28 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf276A {

    public void run() {
        long n = in.nextLong();
        long k = in.nextLong();
        Long[] j = new Long[(int)n];
        for(int i = 0; i < n; ++i) {
            long f = in.nextLong();
            long t = in.nextLong();
            j[i]=t<=k?f:f-t+k;
        }
        out.println(Collections.max(Arrays.asList(j)));
    }

    /***************************************************************/
    public IR in = new IR(System.in); public PrintWriter out = new
    PrintWriter(System.out); public void close() {out.close();}
    static class IR {public BufferedReader r; public StringTokenizer
    t = null; public IR(InputStream s) {r = new BufferedReader(new
    InputStreamReader(s), 32768);} private boolean p() {while (t ==
    null || !t.hasMoreTokens()) {try {String l = r.readLine(); if (l
    == null) return false; t = new StringTokenizer(l);} catch
    (IOException e) {throw new RuntimeException(e);}} return true;}
    public boolean hasNext() {return p();} public String next() {p();
    return t.nextToken();} public int nextInt() {return Integer
    .parseInt(next());} public long nextLong() {return Long.parseLong
    (next());} public double nextDouble() {return Double.parseDouble(
    next());}} public static void main(String[] args) {cf276A t =
    new cf276A(); t.run(); t.close();}
    /***************************************************************/
}
