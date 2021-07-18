import java.io.*;
import java.util.*;

/**
 * Problem Uva10368
 */
public class Uva10368 {

    public void run() {
        while(true){
            long a = in.nextLong();
            long b = in.nextLong();
            if(a==0&&b==0) return;
            if(game(a,b)) out.println("Stan wins");
            else out.println("Ollie wins");
        }
    }

    boolean game(long a, long b){
        if(a>b){
            long t = a;
            a = b;
            b = t;
        }
        if(b==0 || a==0 || b%a==0) return true;
        boolean win = false;
        if(b/a>=2){
            win = win || !game(b%a + a, a);
        }
        win = win || !game(b%a, a);
        return win;
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
        Uva10368 task = new Uva10368(); task.run(); task.close();}
}
