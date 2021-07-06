import java.io.*;
import java.util.*;

/**
 * Problem Cf189A
 */
public class Cf189A {

    public void run() {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        out.println(find(new int[n+1],n,a,b,c));
    }

    int find(int[] dp, int n, int a, int b, int c){
        if(n==0) return 0;
        if(n<0) return -5000;
        if(dp[n]!=0) return dp[n];
        int p = 1 + find(dp,n-a,a,b,c);
        p=Math.max(p, 1 + find(dp,n-b,a,b,c));
        p=Math.max(p, 1 + find(dp,n-c,a,b,c));
        return dp[n]=p;
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
        Cf189A task = new Cf189A(); task.run(); task.close();}
}
