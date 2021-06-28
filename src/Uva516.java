import java.io.*;
import java.util.*;

/**
 * Problem Uva516
 */
public class Uva516 {


    public void run() {
        try {
            List<Long> primes = rprimes(32767);
            while(true){
                StringTokenizer tk = new StringTokenizer(in.reader.readLine());
                long v = 1;
                while(tk.hasMoreTokens()){
                    long a = Long.parseLong(tk.nextToken());
                    if(a==0) return;
                    long b = Long.parseLong(tk.nextToken());
                    v*=fpow(a,b);
                }
                v--;
                StringJoiner joiner = new StringJoiner(" ");
                for(long p : primes){
                    if(v%p==0){
                        int cnt = 0;
                        while(v%p==0){
                            cnt++;
                            v/=p;
                        }
                        joiner.add(String.valueOf(p));
                        joiner.add(String.valueOf(cnt));
                    }
                }
                out.println(joiner);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public long fpow(long a, long b){
        if(b==0) return 1;
        if(b==1) return a;
        if(b%2==1) return a*fpow(a,b-1);
        long ret = fpow(a,b/2);
        return ret*ret;
    }

    public List<Long> rprimes(int n){
        int[] sieve = new int[n+1];
        for(int i = 2; i <= n; ++i){
            if(sieve[i]==0){
                for(int j = i+i; j < n; j+=i){
                    sieve[j]=1;
                }
            }
        }
        List<Long> primes = new ArrayList<>();
        for(int i = 2; i <= n; ++i){
            if(sieve[i]==0) primes.add((long)i);
        }
        Collections.reverse(primes);
        return primes;
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
        Uva516 task = new Uva516(); task.run(); task.close();}
}
