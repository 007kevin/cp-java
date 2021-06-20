import java.io.*;
import java.util.*;

/**
 * Problem Uva10617AgainPalindrome
 */
public class Uva10617AgainPalindrome {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            char[] s = in.next().toCharArray();
            int n = s.length;
            out.println(find(new long[n][n], s, 0, n-1));
        }
    }

    private long find(long[][] dp, char[] s, int i, int j) {
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        long cnt = 0;
        for(int k = i; k <= j; ++k){
            for(int l = k; l <= j; ++l){
                if(s[k]==s[l]){
                    cnt+=1 + find(dp,s,k+1, l-1);
                }
            }
        }
        return dp[i][j] = cnt;
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
        Uva10617AgainPalindrome task = new Uva10617AgainPalindrome(); task.run(); task.close();}
}