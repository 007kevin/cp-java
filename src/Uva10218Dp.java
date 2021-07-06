import java.io.*;
import java.util.*;

/**
 * Problem Uva10218Dp
 */
public class Uva10218Dp {
    int m,w,c;
    double[][] dp;

    public void run() {
        while(true){
            m = in.nextInt();
            w = in.nextInt();
            if(m==0&&w==0) return;
            c = in.nextInt();
            dp = new double[1001][101];
            out.println(String.format("%.7f", find(0,c)));
        }
    }

    double find(int men, int rem){
        if(rem==0) return (men+1)%2;
        if(dp[men][rem]!=0) return dp[men][rem];
        return dp[men][rem] =
            d(m)/d(m+w) * find(men+1, rem-1) + d(w)/d(m+w) * find(men, rem-1);
    }
    double d(int i) {return (double) i;}

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
        Uva10218Dp task = new Uva10218Dp(); task.run(); task.close();}
}
