import java.io.*;
import java.util.*;

/**
 * Problem Cf534
 */
public class Cf534B {

    public void run() {
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        int t = in.nextInt();
        int d = in.nextInt();
        int[] s = new int[t];
        s[0]=v1;
        s[t-1]=v2;
        for(int i = 1; i < t-1; ++i) s[i]=s[i-1]+d;
        for(int i = t-2; i >= 0; --i) s[i]=Math.min(s[i], s[i+1] + d);
        out.println(Arrays.stream(s).sum());
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
        Cf534B task = new Cf534B(); task.run(); task.close();}
}
