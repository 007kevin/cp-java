import java.io.*;
import java.util.*;

/**
 * Problem Cf10218
 */
public class Cf10218 {

    public void run() {
        while(true){
            int m = in.nextInt();
            int w = in.nextInt();
            if(m==0&&w==0) return;
            int c = in.nextInt();
            double p = 0;
            for(int i = 2; i <= Math.min(c,m); i+=2){
                p+=i/(m+w);
            }
            out.println(String.format("%.7f", p));

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
        Cf10218 task = new Cf10218(); task.run(); task.close();}
}
