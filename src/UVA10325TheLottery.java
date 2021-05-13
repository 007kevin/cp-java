import java.io.*;
import java.util.*;

/**
 * Problem UVA10325TheLottery
 * By inclusion-exclusion principle,
 * M=15 means we need to generate 2^15-1 = 32767 terms
 */
public class UVA10325TheLottery {

    static class Task extends IOHandler {
        public void run() {
            while(in.hasNext()){
                long n = in.nextLong();
                int m = in.nextInt();
                long[] a = new long[m];
                for(int i = 0; i < m; ++i) a[i]=in.nextLong();
                long inc = apply(n,a,m);
                out.println(n-inc);
            }
        }

        public int apply(long n, long[] a, int m){
            if(m==0) return 0;
            int sign=m%2==0?-1:1;
            List<List<Long>> chosen = new ArrayList<>();
            recursiveFor(chosen, new ArrayList<>(), a, 0, m);
            int ret=0;
            for(List<Long> c : chosen){
                ret+=sign*n/c.stream().reduce(1l, (acc, val) -> lcm(acc,val));
            }
            return ret + apply(n,a,m-1);
        }

        public void recursiveFor(
                List<List<Long>> list,
                List<Long> cur,
                long[] a,
                int i,
                int m) {
            if(m==0){
                list.add(new ArrayList<>(cur));
                return;
            }
            for(int j = i; j < a.length; ++j){
                cur.add(a[j]);
                recursiveFor(list, cur, a, j+1, m-1);
                cur.remove(cur.size()-1);
            }
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
