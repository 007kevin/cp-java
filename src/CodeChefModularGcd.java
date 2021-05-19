import java.io.*;
import java.util.*;

/**
 * Problem CodeChefModularGcd
 */
public class CodeChefModularGcd {

    static class Task extends IOHandler {

        private static final long MOD = 1000000007;
        
        public void run() {
            long T = in.nextInt();
            while(T-->0){
                long A = in.nextLong();
                long B = in.nextLong();
                long N = in.nextLong();
                long ANS = gcd((fexp(A,N) + fexp(B,N)%MOD), (A-B)%MOD);
                out.println(ANS);
            }
        }

        public long gcd(long a, long b){
            if(a==0) return b%MOD;
            if(b==0) return a%MOD;
            if(a%b==0) return b%MOD;
            return gcd(b,a%b)%MOD;
        }

        public long fexp(long a, long n){
            if(n==1) return a%MOD;
            if(n%2==1){
                return ((a%MOD)*(fexp(a,n-1)%MOD)%MOD);
            }
            long r = fexp(a,n/2)%MOD;
            return (r*r)%MOD;
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
