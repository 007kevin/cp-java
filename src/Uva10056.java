import java.io.*;
import java.util.*;

/**
 * Problem Uva10056
 */
public class Uva10056 {

    public void run() {
        int s = in.nextInt();
        while(s-->0){
            double n = in.nextDouble();
            double p = in.nextDouble();
            double i = in.nextDouble();
            double prob = 0.0;
            for(int j = 0; j <= 100; ++j){
                prob+=Math.pow(1-p,j*n);
            }
            prob*=p*Math.pow(1-p, i-1);
            out.println(String.format("%.4f",prob));
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
        Uva10056 task = new Uva10056(); task.run(); task.close();}
}
