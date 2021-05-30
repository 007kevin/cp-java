import java.io.*;
import java.util.*;

/**
 * Problem Cf227C
 */
public class Cf227C {

    static class Task extends IOHandler {
        public void run() {
            long n = in.nextLong();
            long m = in.nextLong();
            out.println((properMod(f(n,m)-1,m)));
        }

        public long f(long n, long m){
            if(n==0) return 1%m;
            if(n==1) return 3%m;
            if(n%2==1){
                return (3 * f(n-1,m))%m;
            }
            long r = f(n/2,m)%m;
            return (r*r)%m;
        }

        public long properMod(long a, long m){
            if(a<0) return m+a;
            return a%m;
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
