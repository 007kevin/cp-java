import java.io.*;
import java.util.*;

/**
 * Problem CfContest1543C
 */
public class CfContest1543C {

    char C = 'C';
    char M = 'M';
    char P = 'P';

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            double c = in.nextDouble();
            double m = in.nextDouble();
            double p = in.nextDouble();
            double v = in.nextDouble();
            out.println(
                find(C,1.0,c,m,p,v) +
                find(M,1.0,c,m,p,v) +
                find(P,1.0,c,m,p,v));
        }
    }

    double find(char A, double d, double c, double m, double p, double v) {
        if(A==P){
            return d * p;
        }
        double e = 0;
        return e;
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
        CfContest1543C task = new CfContest1543C(); task.run(); task.close();}
}
