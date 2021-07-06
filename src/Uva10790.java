import java.io.*;
import java.util.*;

/**
 * Problem Uva10790
 */
public class Uva10790 {

    public void run() {
        int c = 1;
        while(true){
            long a = in.nextLong();
            long b = in.nextLong();
            if(a==0&&b==0) return;
            out.println(String.format(
                    "Case %s: %s", c++,
                    ((a*(a-1)/2) * ((b*(b-1)/2)))));
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
        Uva10790 task = new Uva10790(); task.run(); task.close();}
}
