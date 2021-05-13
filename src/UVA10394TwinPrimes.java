import java.io.*;
import java.util.*;

/**
 * Problem UVA10394TwinPrimes
 */
public class UVA10394TwinPrimes {

    static class Task extends IOHandler {
        public void run() {
            BitSet sieve = new BitSet(20000000);
            for(int i = 2; i < 20000000; ++i){
                for(int j = i+i; j < 20000000; j+=i){
                    sieve.set(j);
                }
            }
            List<Integer> primes = new ArrayList<>();
            List<TwinPrime> twinPrimes = new ArrayList<>();
            for(int i = 2; i < 20000000; ++i){
                if(!sieve.get(i)) primes.add(i);
            }
            for(int i = 0; i < primes.size()-1; ++i){
                if(primes.get(i+1) - primes.get(i) == 2){
                    twinPrimes.add(new TwinPrime(primes.get(i), primes.get(i+1)));
                }
            }
            while(in.hasNext()){
                out.println(twinPrimes.get(in.nextInt() - 1));
            }
        }
    }

    static class TwinPrime {
        int a,b;
        public TwinPrime(int a, int b){
            this.a=a;
            this.b=b;
        }

        public String toString() {
            return "(" + a + ", " + b + ")";
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
