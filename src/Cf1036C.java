import java.io.*;
import java.util.*;

/**
 * Problem Cf1036C
 */
public class Cf1036C {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            long l = in.nextLong();
            long r = in.nextLong();
            out.println(find(r) - find(l-1));
        }
    }

    public long find(long num){
        int[] d = digits(num);
        int n = d.length;
        long cnt = 0;
        for(int i = 1; i <= d[0]; ++i){
            cnt++;
            for(int j = 1; j < n; ++j){
                cnt+=(i==d[0]?d[j]:9);
                for(int k = j+1; k < n; ++k){
                    if(i==d[0]) cnt+=d[j]*d[k];
                    else cnt+=9*9;
                }
            }
        }
        for(int i = 1; i < n; ++i){
            cnt+=9;
            for(int j = i+1; j < n; ++j){
                cnt+=9*9;
                for(int k = j+1; k < n; ++k){
                    cnt+=9*9*9;
                }
            }
        }
        return cnt;
    }

    public int[] digits(long num){
        String s = String.valueOf(num);
        int[] d = new int[s.length()];
        for(int i = 0; i < s.length(); ++i){
            d[i]=s.charAt(i)-'0';
        }
        return d;
    }

    public long ncr(int n, int r){
        return f(n)/(f(r)*f(n-r));
    }

    public long f(int n){
        int f = 1;
        for(int i = 2; i <= n; ++i){
            f*=i;
        }
        return f;
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
        Cf1036C task = new Cf1036C(); task.run(); task.close();}
}
