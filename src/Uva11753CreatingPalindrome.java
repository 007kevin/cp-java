import java.io.*;
import java.util.*;

/**
 * Problem Uva11753CreatingPalindrome
 */
public class Uva11753CreatingPalindrome {

    int c = 1,k;

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            k = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            int d = find(a, 0, n-1, 0);
            if(d==0) out.println(String.format("Case %s: Too easy", c));
            else if (d>k) out.println(String.format("Case %s: Too difficult", c));
            else out.println(String.format("Case %s: %s", c, d));
            c++;
        }
    }

    public int find(int[] a, int i, int j, int sum){
        if(i>=j) return sum;
        if(sum > k) return 30;
        if (a[i]==a[j]) return find(a,i+1,j-1, sum);
        return Math.min(find(a,i+1,j,sum+1), find(a,i,j-1, sum+1));
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
        Uva11753CreatingPalindrome task = new Uva11753CreatingPalindrome(); task.run(); task.close();}
}
