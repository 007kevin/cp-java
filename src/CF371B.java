import java.io.*;
import java.util.*;

/**
 * Problem CF371B
 */
public class CF371B {

    static class Task extends IOHandler {
        public void run() {
            long a = in.nextLong();
            long b = in.nextLong();
            long ans = 0;
            while(a%2==0&&b%2==0){
                a/=2; b/=2;
            }
            while(a%3==0&&b%3==0){
                a/=3; b/=3;
            }
            while(a%5==0&&b%5==0){
                a/=5; b/=5;
            }
            while(a%2==0) {
                a/=2;
                ans++;
            }
            while(a%3==0) {
                a/=3;
                ans++;
            }
            while(a%5==0) {
                a/=5;
                ans++;
            }
            while(b%2==0) {
                b/=2;
                ans++;
            }
            while(b%3==0) {
                b/=3;
                ans++;
            }
            while(b%5==0) {
                b/=5;
                ans++;
            }
            if(a==b) out.println(ans);
            else out.println(-1);
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