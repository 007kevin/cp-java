import java.io.*;
import java.util.*;

/**
 * Problem Cf88C
 */
public class Cf88C {

    static class Task extends IOHandler {
        public void run() {
            long a = in.nextLong();
            long b = in.nextLong();
            long dasha=0,masha=0;
            long n = a*b;
            long lcm = lcm(a,b);
            dasha+=n/a;
            masha+=n/b;
            if(dasha<masha) dasha+=n/lcm;
            else masha+=n/lcm;
            if(dasha==masha) out.println("Equal");
            else if (dasha<masha) out.println("Masha");
            else out.println("Dasha");
            
        }
        public long gcd(long a, long b){
            if(a%b==0) return b;
            return gcd(b,a%b);
        }
        public long lcm(long a, long b){
            return a / gcd(a,b) * b;
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
