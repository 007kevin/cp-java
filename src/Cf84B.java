import java.io.*;
import java.util.*;

/**
 * Problem Cf84B
 */
public class Cf84B {

    public void run() {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int init = 0;
        for(int i = 0; i < n ; ++i) a[i]=in.nextInt();
        for(int i = 0; i < n ; ++i){
            if(i==0||a[i-1]!=a[i]) init++;
            b[i]=init;
        }
        long cnt = 0;
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            map.put(b[i], map.getOrDefault(b[i], 0l) + 1l);
            cnt+=map.get(b[i]);
        }
        out.println(cnt);
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
        Cf84B task = new Cf84B(); task.run(); task.close();}
}
