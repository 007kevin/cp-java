import java.io.*;
import java.util.*;

/**
 * Problem Uva10622
 */
public class Uva10622 {

    public void run() {
        while(true){
            long n = in.nextLong();
            if(n==0) return;
            if(n<0) {
                long p = pth(-1*n).stream()
                        .filter(v -> v%2==1)
                        .max(Long::compare)
                        .get();
                out.println(p);
            } else {
                long p = pth(n).stream()
                        .max(Long::compare)
                        .get();
                out.println(p);
            }
        }
    }

    public List<Long> pth(long n){
        List<Long> list = new LinkedList<>();
        list.add(1l);
        for(long i = 2l; i*i <= n; ++i){
            long j = i, p=1;
            while(j<n){
                j*=i;
                p++;
            }
            if(j==n) list.add(p);
        }
        return list;
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
        Uva10622 task = new Uva10622(); task.run(); task.close();}
}
