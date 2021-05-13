import java.io.*;
import java.util.*;

/**
 * Problem UVA10168SummationOfFour
 */
public class UVA10168SummationOfFour {

    static int MAX = 10000000;

    static class Task extends IOHandler {
        public void run() {
            BitSet sieve = new BitSet(MAX);
            Set<Integer> primes = new HashSet<>();
            for(int i = 2; i < MAX; ++i){
                if(!sieve.get(i)){
                    primes.add(i);
                    for(int j = i+i; j < MAX; j+=i) sieve.set(j);
                }
            }
            while(in.hasNext()){
                int n = in.nextInt();
                if(n < 8) out.println("Impossible.");
                else if(n%2==1) out.println("2 3 " + find(primes, n-5));
                else {
                    out.println("2 2 " + find(primes, n-4));
                }
            }
        }

        private Pair find(Set<Integer> primes, int n) {
            for(Integer p : primes){
                if(primes.contains(n-p)) return new Pair(p, n-p);
            }
            return null;
        }
    }

    static class Pair {
        int a,b;
        public Pair(int a, int b){
            this.a=a;this.b=b;
        }
        public String toString(){
            return a + " " + b;
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
