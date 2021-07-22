import java.io.*;
import java.util.*;

/**
 * Problem Cf347
 */
public class Cf347 {

    public void run() {
        int n = in.nextInt();
        int[] a = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i){
            a[i]=in.nextInt();
            if(a[i]>a[max]) max=i;
        }
        int gcd=a[0];
        for(int i = 1; i < n; ++i)
            gcd=gcd(gcd,a[i]);
        int moves = a[max]/gcd - n;
        if(moves%2==1) out.println("Alice");
        else out.println("Bob");
    }

    int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
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
        Cf347 task = new Cf347(); task.run(); task.close();}
}
