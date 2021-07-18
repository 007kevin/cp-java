import java.io.*;
import java.util.*;

/**
 * Problem At209B
 */
public class At209B {

    public void run() {
        int n = in.nextInt();
        int x = in.nextInt();
        int s = 0;
        for(int i = 0; i < n; ++i){
            int a = in.nextInt();
            if(i%2==1) s+=a-1;
            else s+=a;
        }
        if(s<=x) out.println("Yes");
        else out.println("No");
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
        At209B task = new At209B(); task.run(); task.close();}
}
