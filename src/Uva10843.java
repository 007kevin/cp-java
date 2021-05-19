import java.io.*;
import java.util.*;

/**
 * Problem Uva10843
 */
public class Uva10843 {

    static class Task extends IOHandler {
        static long mod = 2000000011;
        
        
        public void run() {
            int t = in.nextInt();
            int c = 1;
            while(t-->0){
                int n = in.nextInt();
                if(n==0||n==1||n==2) out.println(f(c,1l));
                else out.println(f(c,cayley(n)));
                c++;
            }
        }

        public long cayley(long n) {
            long r = 1;
            for(int i = 0; i < n-2; ++i){
                r=(r*n)%mod;
            }
            return r;
        }
        private String f(int c, long n){
            return String.format("Case #%d: %d", c, n);
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
