import java.io.*;
import java.util.*;

/**
 * Problem Cf1220C
 */
public class Cf1220C {

    String M = "Mike";
    String A = "Ann";


    public void run() {
        String s = in.next();
        out.println(M);
        char m = s.charAt(0);
        for(int i = 1; i < s.length(); ++i){
            if(m < s.charAt(i)) out.println(A);
            else out.println(M);
            m=s.charAt(i) < m ? s.charAt(i) : m;
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
        Cf1220C task = new Cf1220C(); task.run(); task.close();}
}