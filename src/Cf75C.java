import java.io.*;
import java.util.*;

/**
 * Problem Cf75C
 */
public class Cf75C {

    public void run() {
        long a = in.nextLong();
        long b = in.nextLong();
        TreeSet<Long> aset = new TreeSet<>();
        Set<Long> bset = new HashSet<>();
        for(long i = 1; i*i <= a; ++i){
            if(a%i==0){
                aset.add(i);
                aset.add(a/i);
            }
        }
        aset.add(a);
        for(long i = 1; i*i <= b; ++i){
            if(b%i==0){
                bset.add(i);
                bset.add(b/i);
            }
        }
        bset.add(b);
        int n = in.nextInt();
        while(n-->0){
            long l = in.nextLong();
            long h = in.nextLong();
            Set<Long> set = aset.subSet(l,true,h,true).descendingSet();
            long ans = -1;
            for(long c : set){
                if(bset.contains(c)){
                    ans = c;
                    break;
                }
            }
            out.println(ans);
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
        Cf75C task = new Cf75C(); task.run(); task.close();}
}
