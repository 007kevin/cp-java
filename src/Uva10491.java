import java.io.*;
import java.util.*;

/**
 * Problem Uva10491
 */
public class Uva10491 {

    public void run() {
        while(in.hasNext()){
            double m = in.nextDouble();
            double n = in.nextDouble();
            double s = in.nextDouble();
            out.println(String.format("%.5f", calc(n,m,s)));
        }
    }

    double calc(double n, double m, double s){
        return div(n,n+m)*div(n-1,n+m-s-1) + div(m,n+m)*div(n,n+m-s-1);
    }

    double div(double a, double b){
        return a/b;
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
        Uva10491 task = new Uva10491(); task.run(); task.close();}
}
