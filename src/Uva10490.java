import java.io.*;
import java.util.*;

/**
 * Problem Uva10490
 */
public class Uva10490 {

    public void run() {
        while(in.hasNext()){
            long n = in.nextLong();
            if(n==0) return;
            long p = p(n);
            List<Long> div = div(p);
            if(div.stream().reduce(0l, (acc, v) -> acc+v) == p){
                out.println("Perfect: " + p + "!");
            } else if(isPrime(n)){
                out.println("Given number is prime. But, NO perfect number is available.");
            } else {
                out.println("Given number is NOT prime! NO perfect number is available.");
            }
        }

    }

    long p(long k){
        return (1<<(k-1))*((1<<k) - 1);
    }

    List<Long> div(long n){
        List<Long> list = new LinkedList<>();
        list.add(1l);
        for(long i = 2; i*i <= n; ++i){
            if (n%i==0){
                list.add(i);
                if(i!=n/i) list.add(n/i);
            }
        }
        return list;
    }

    boolean isPrime(long n){
        for(long i = 2; i*i <= n; ++i){
            if (n%i==0){
                return false;
            }
        }
        return true;
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
        Uva10490 task = new Uva10490(); task.run(); task.close();}
}
