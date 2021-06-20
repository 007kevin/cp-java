import java.io.*;
import java.util.*;

/**
 * Problem Cf610B
 */
public class Cf610B {

    public void run() {
        int n = in.nextInt();
        int[] a = new int[n];
        int low = 0;
        for(int i = 0; i < n; ++i){
            a[i]=in.nextInt();
            if(a[i]<a[low])
                low=i;
        }
        int last=0,len=0;
        for(int i = (low+1)%n; i != low; i=(i+1)%n){
            if(a[i]==a[low]) continue;
            if(a[prev(i, n)]==a[low]){
                last=i;
            }
            if(a[(i+1)%n]==a[low]){
                len=Math.max(len, range(last, i, n));
            }
        }
        long ans = ((long) a[low])*((long) n) + len;
        out.println(ans);

    }

    int prev(int i, int n){
        return i == 0 ? n-1 : i-1;
    }

    int range(int i, int j, int n){
        if(i<=j) return j-i+1;
        return (j+n)-i+1;
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
        Cf610B task = new Cf610B(); task.run(); task.close();}
}
