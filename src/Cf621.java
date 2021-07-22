import java.io.*;
import java.util.*;

/**
 * Problem Cf621
 */
public class Cf621 {

    public void run() {
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] s = new int[n][2];
        double[] m = new double[n];
        for(int i = 0; i < n; ++i){
            s[i][0]=in.nextInt();
            s[i][1]=in.nextInt();
        }
        double e = 0;
        for(int i = 0; i < n; ++i){
            double a = s[i][1]/p - (s[i][0]-1)/p;
            double A = (s[i][1]-s[i][0]+1);
            double b = s[nxt(i,n)][1]/p - (s[nxt(i,n)][0]-1)/p;
            double B = (s[nxt(i,n)][1]-s[nxt(i,n)][0]+1);
            double tamt = (a)/A + b/B - (a*b)/(A*B);
            m[i]+=tamt;
            m[nxt(i,n)]+=tamt;
        }
        for(double amt : m) {
            e+=amt;
        }
        out.println(e*1000);
    }

    int nxt(int i, int n){
        return (i+1)%n;
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
        Cf621 task = new Cf621(); task.run(); task.close();}
}
