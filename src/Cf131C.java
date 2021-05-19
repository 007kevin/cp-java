import java.io.*;
import java.util.*;

/**
 * Problem Cf131C
 */
public class Cf131C {

    static class Task extends IOHandler {
        public void run() {
            Ncr ncr = new Ncr();
            int n = in.nextInt();
            int m = in.nextInt();
            int t = in.nextInt();
            long ans=0;
            for(int i = 4; i <= t-1; ++i){
                if(n>=i&&m>=t-i)
                    ans+=ncr.choose(n,i)*ncr.choose(m,t-i);
            }
            out.println(ans);
        }
    }

    static class Ncr {
        
        long[][] memo = new long[31][31];
        
        public long choose(int n, int r){
            if(n==r||n==0||r==0) return 1;
            if(memo[n][r]!=0) return memo[n][r];
            return memo[n][r]=(choose(n-1,r-1) + choose(n-1,r));
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public static void main(String[] args) {
        Task task = new Task(); task.run(); task.close();}
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void close() {out.close();}}
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
}
