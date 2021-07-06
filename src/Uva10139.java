import java.io.*;
import java.util.*;

/**
 * Problem Uva10139
 */
public class Uva10139 {

    public void run() {
        while(in.hasNext()){
            long n = in.nextLong();
            long m = in.nextLong();
            if(possible(n,m)){
                out.println(String.format("%s divides %s!", m, n));
            } else {
                out.println(String.format("%s does not divide %s!", m, n));
            }
        }
    }

    public boolean possible(long n, long m){
        return pf(m).entrySet().stream()
                .allMatch(e -> e.getValue() <= cnt(n, e.getKey()));
    }

    public Map<Long, Long> pf(long n){
        Map<Long, Long> map = new HashMap<>();
        for(long i = 2; i * i<= n; ++i){
            long cnt = 0;
            while(n%i==0){
                cnt++;
                n/=i;
            }
            if(cnt!=0) map.put(i,cnt);
        }
        if(n!=1) map.put(n,1l);
        return map;
    }

    public long cnt(long n, long p){
        long c = 0;
        for(long i = p; i <= n; i*=p){
            c+=n/i;
        }
        return c;

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
        Uva10139 task = new Uva10139(); task.run(); task.close();}
}
