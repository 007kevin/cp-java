import java.io.*;
import java.util.*;

/**
 * Problem CfContest1543A
 */
public class CfContest1543A {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            long a = in.nextLong();
            long b = in.nextLong();
            long d = Math.abs(a-b);
            if(d==0) {
                out.println("0 0");
            } else {
                out.println(d + " " + (Math.min(a%d, d-(a%d))));
            }
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
        CfContest1543A task = new CfContest1543A(); task.run(); task.close();}
}
