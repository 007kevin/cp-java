import java.io.*;
import java.util.*;

/**
 * Problem Uva583PrimeFactors
 */
public class Uva583PrimeFactors {
    public void run() {
        while(in.hasNext()){
            long n = in.nextLong();
            if(n==0) return;
            long v = n;
            List<Long> pf = new LinkedList<>();
            if(n<0) {
                pf.add(-1l);
                n*=-1;
            }
            for(long i = 2; i*i <= n; ++i){
                while(n%i==0){
                    pf.add(i);
                    n/=i;
                }
            }
            if(n!=1) pf.add(n);
            StringJoiner joiner = new StringJoiner(" x ");
            pf.stream().map(String::valueOf).forEach(joiner::add);
            out.println(String.format("%s = %s", v, joiner ));
        }
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
        Uva583PrimeFactors task = new Uva583PrimeFactors(); task.run(); task.close();}
}
