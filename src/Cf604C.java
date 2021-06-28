import java.io.*;
import java.util.*;

/**
 * Problem Cf604C
 */
public class Cf604C {

    public void run() {
        int n = in.nextInt();
        String b = in.next();
        int len = 0;
        for(int i = 0; i < n; ++i){
            int j = i+1;
            while(j<n && b.charAt(j)==b.charAt(i)) j++;
            len++;
            i=j-1;
        }
        len+=flip(b);
        out.println(len);
    }

    int flip(String b){
        int n = b.length();
        int cnt = 0;
        for(int i = 0; i < n-1; ++i){
            if(b.charAt(i)==b.charAt(i+1)){
                cnt++;
            }
        }
        return Math.min(2,cnt);
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
        Cf604C task = new Cf604C(); task.run(); task.close();}
}
