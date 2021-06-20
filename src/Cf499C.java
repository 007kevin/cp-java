import java.io.*;
import java.util.*;

/**
 * Problem Cf499C
 */
public class Cf499C {

    public void run() {
        long x1=in.nextLong(),y1=in.nextLong();
        long x2=in.nextLong(),y2=in.nextLong();
        long cnt=0, n = in.nextLong();
        while(n-->0){
            long a = in.nextLong(),b=in.nextLong(),c=in.nextLong();
            long sign1 = a*x1 + b*y1 + c > 0 ? 1 : -1;
            long sign2 = a*x2 + b*y2 + c > 0 ? 1 : -1;
            if(sign1!=sign2) cnt++;
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
        Cf499C task = new Cf499C(); task.run(); task.close();}
}
