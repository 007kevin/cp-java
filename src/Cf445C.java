import java.io.*;
import java.util.*;

/**
 * Problem Cf445C
 */
public class Cf445C {

    public void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        double ans = 0;
        double[] a = new double[n+1];
        for(int i = 1; i <= n; ++i) a[i]=in.nextDouble();
        for(int i = 0; i < m; ++i){
            int u = in.nextInt();
            int v = in.nextInt();
            double c = in.nextDouble();
            ans = Math.max(ans, (a[u]+a[v])/c);
        }
        out.println(ans);
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
        Cf445C task = new Cf445C(); task.run(); task.close();}
}
