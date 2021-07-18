import java.io.*;
import java.util.*;

/**
 * Problem At209C
 */
public class At209C {
    long mod = (long) Math.pow(10,9) + 7;
    public void run() {
        int n = in.nextInt();
        long[] c = new long[n];
        for(int i = 0; i < n; ++i) c[i]=in.nextLong();
        Arrays.sort(c);
        long a = 1;
        for(int i = 0; i < n; ++i){
            a=(a*Math.max(0,c[i]-i))%mod;
        }
        out.println(a);
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
        At209C task = new At209C(); task.run(); task.close();}
}
