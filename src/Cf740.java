import java.io.*;
import java.util.*;

/**
 * Problem Cf740
 */
public class Cf740 {

    public void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; ++i){
            int l = in.nextInt();
            int r = in.nextInt();
            min=Math.min(min, (r-l)+1);
        }
        out.println(min);
        for(int i = 0; i < n; ++i){
            out.print((i%min) + " ");
        }
        out.println();
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public InputReader in = new InputReader(System.in);
    public PrintWriter out = new PrintWriter(System.out);
    public void close() {out.close();}
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokens = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);}
        private boolean prime() {
            while (tokens == null || !tokens.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokens = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            } return true;}
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokens.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
    public static void main(String[] args) {
        Cf740 task = new Cf740(); task.run(); task.close();}
}
