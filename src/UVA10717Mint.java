import java.io.*;
import java.util.*;

/**
 * Problem UVA10717Mint
 */
public class UVA10717Mint {

    static class Task extends IOHandler {
        public void run() {
            while(in.hasNext()){
                int n = in.nextInt();
                int t = in.nextInt();
                if(n==0&&t==0) return;
                long[] c = new long[n];
                for(int i = 0; i < n; ++i) c[i]=in.nextLong();
                while(t-->0){
                    long h = in.nextLong();
                    long floor = 0l;
                    long ceil = Long.MAX_VALUE;
                    for(int i = 0; i < n; ++i){
                        for(int j = i+1; j < n; ++j){
                            for(int k = j+1; k < n; ++k){
                                for(int l = k+1; l < n; ++l){
                                    long lcm = lcm(c[i],lcm(c[j],lcm(c[k],c[l])));
                                    floor=Math.max(floor, floor(h,lcm)*lcm);
                                    ceil=Math.min(ceil, ceil(h,lcm)*lcm);
                                
                                }
                            }
                        }
                    }
                    out.println(floor + " " + ceil);
                }
            }
        }

        private long floor(long a, long b){
            return a/b;
        }

        private long ceil(long a, long b){
            return (a-1)/b+1;
        }

        private long gcd(long a, long b) {
            if(a%b==0) return b;
            return gcd(b,a%b);
        }

        private long lcm(long a, long b) {
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
