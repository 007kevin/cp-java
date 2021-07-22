import java.io.*;
import java.util.*;

/**
 * Problem Cf451C
 */
public class Cf451C {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            long n = in.nextLong();
            long k = in.nextLong();
            long d1 = in.nextLong();
            long d2 = in.nextLong();
            if(c1(n,k,d1,d2)
                    || c2(n,k,d1,d2)
                    || c3(n,k,d1,d2)
                    || c4(n,k,d1,d2)
                    || c5(n,k,d1,d2)){
                out.println("yes");
            } else {
                out.println("no");
            }
        }
    }

    boolean c1(long n, long k, long a, long b) {
        long g = a+b;
        long r = Math.max(a,b) + Math.abs(a-b);
        if(k-g < 0 || (k-g)%3!=0) return false;
        if((n-k-r) < 0 || (n-k-r)%3!=0) return false;
        return true;
    }

    boolean c2(long n, long k, long a, long b) {
        long g = a + a + b;
        long r = a + b + b;
        if(k-g < 0 || (k-g)%3!=0) return false;
        if((n-k-r) < 0 || (n-k-r)%3!=0) return false;
        return true;
    }

    boolean c3(long n, long k, long a, long b) {
        long g = b + a + b + a;
        long r = a + b;
        if(k-g < 0 || (k-g)%3!=0) return false;
        if((n-k-r) < 0 || (n-k-r)%3!=0) return false;
        return true;
    }

    boolean c4(long n, long k, long a, long b) {
        long g = a + b + b;
        long r = a + b + a;
        if(k-g < 0 || (k-g)%3!=0) return false;
        if((n-k-r) < 0 || (n-k-r)%3!=0) return false;
        return true;
    }

    boolean c5(long n, long k, long a, long b) {
        if(a!=b) return false;
        long g = a;
        long r = 2*a;
        if(k-g < 0 || (k-g)%3!=0) return false;
        if((n-k-r) < 0 || (n-k-r)%3!=0) return false;
        return true;
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
        Cf451C task = new Cf451C(); task.run(); task.close();}
}
