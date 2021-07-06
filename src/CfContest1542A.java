import java.io.*;
import java.util.*;

/**
 * Problem CfContest1542A
 */
public class CfContest1542A {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int odd=0,even=0;
            for(int i = 0; i < 2*n; ++i){
                int a = in.nextInt();
                if(a%2==1) odd++;
                else even++;
            }
            if(odd==n&&even==n) out.println("Yes");
            else out.println("No");
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
        CfContest1542A task = new CfContest1542A(); task.run(); task.close();}
}
