import java.io.*;
import java.util.*;

/**
 * Problem   = cf200B
 * Date      = Sat Apr 30 21:14:20 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf200B {

    public void run() {
        int n = in.nextInt();
        int p = 0;
        for(int i = 0; i < n; ++i){
            p+=in.nextInt();
        }
        out.println((double)p/(double)n);
    }



    /***********************************************************/
    public InputReader in = new InputReader(System.in); public
    PrintWriter out = new PrintWriter(System.out); public void close()
    {out.close();} static class InputReader {public BufferedReader
    reader; public StringTokenizer tokens = null; public
    InputReader(InputStream stream) {reader = new BufferedReader(new
    InputStreamReader(stream), 32768);} private boolean prime() {while
    (tokens == null || !tokens.hasMoreTokens()) {try {String line =
    reader.readLine(); if(line==null) return false; tokens = new
    StringTokenizer(line);} catch (IOException e) {throw new
    RuntimeException(e);}} return true;} public boolean hasNext()
    {return prime();} public String next() {prime(); return tokens
    .nextToken();} public int nextInt() {return Integer.parseInt(
    next());} public long nextLong() {return Long.parseLong(next());}
    public double nextDouble() {return Double.parseDouble(next());}}
    public static void main(String[] args) {cf200B task = new
    cf200B(); task.run(); task.close();}
    /***********************************************************/
}
