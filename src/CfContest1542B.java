import java.io.*;
import java.util.*;

/**
 * Problem CfContest1542B
 */
public class CfContest1542B {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            long n = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            if(f(n,a,b)) out.println("Yes");
            else out.println("No");
        }
    }

    boolean f(long n, long a, long b){
        long gcd = gcd(a,b);
        if(n%gcd!=0) return false;
        long N = n/gcd;
        long A = a/gcd;
        long B = b/gcd;
        out.println(N + " " + A + " " + B);
        return true;
    }

    long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
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
        CfContest1542B task = new CfContest1542B(); task.run(); task.close();}
}
