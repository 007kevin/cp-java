import java.io.*;
import java.util.*;

/**
 * Problem Uva10003CuttingSticks
 */
public class Uva10003CuttingSticks {

    public void run() {
        while(true){
            int l = in.nextInt();
            if(l==0) return;
            int n = in.nextInt();
            int[] len = new int[l];
            for(int i = 0; i < n; ++i) {
                len[in.nextInt()]=1;
            }
            int[][] dp = new int[l][l];
            Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
            out.println(String.format(
                    "The minimum cutting is %d.",
                    cost(dp, len, 0, l-1)));
        }
    }


    private int cost(int[][] dp, int[] len, int i, int j) {
        if(j-i+1<=1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int c = Integer.MAX_VALUE;
        for(int k = i; k <= j; ++k){
            if(len[k]==1){
                len[k]=0;
                c=Math.min(c,
                        (j-i+1) +
                        cost(dp, len, i, k-1) +
                        cost(dp, len, k, j));
                len[k]=1;
            }
        }
        return dp[i][j]=c == Integer.MAX_VALUE ? 0 : c;
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
        Uva10003CuttingSticks task = new Uva10003CuttingSticks(); task.run(); task.close();}
}
