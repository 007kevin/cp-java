import java.io.*;
import java.util.*;

/**
 * Problem Cf1065C
 */
public class Cf1065C {

    public void run() {
        int n = in.nextInt();
        long k = in.nextLong();
        long[] h = new long[n];
        long[] l = new long[200001];
        int m = 0;
        for(int i = 0; i < n; ++i){
            h[i]=in.nextLong();
            l[(int)h[i]]++;
            if(h[i] < h[m]) m = i;
        }
        for(int i = 200000; i > 0; --i){
            l[i-1]+=l[i];
        }
        int cnt = 0;
        long cur = 0;
        for(int i = 200000; i > h[m]; --i){
            cur+=l[i];
            if(cur==k){
                cnt++;
                cur=0;
            } else if (cur > k){
                cnt++;
                cur=l[i];
            }
        }
        if(cur!=0) cnt++;
        out.println(cnt);
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
        Cf1065C task = new Cf1065C(); task.run(); task.close();}
}
