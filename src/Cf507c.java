import java.io.*;
import java.util.*;

/**
 * Problem Cf507c
 */
public class Cf507c {

    public void run() {
        long h = in.nextLong();
        long n = in.nextLong();
        long c = 0;
        long sum = 0;
        while(c!=h){
            if(n%2==0){
                if(c+1==h||(n/2)%2==0)
                    sum+=(long)Math.pow(2,c+1)-1;
                n/=2;
            } else {
                if(c+1!=h&&((n+1)/2)%2==1)
                    sum+=(long)Math.pow(2,c+1)-1;
                n=(n+1)/2;
            }
            c++;
        }
        out.println(sum + h);
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
        Cf507c task = new Cf507c(); task.run(); task.close();}
}
