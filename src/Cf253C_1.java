import java.io.*;
import java.util.*;

/**
 * Problem Cf253C_1
 * Improved without implementing BFS
 */
public class Cf253C_1 {

    public void run() {
        int n = in.nextInt();
        int[] line = new int[n+1];
        for(int i = 1; i <= n; ++i) line[i]=in.nextInt();
        int[] s = new int[]{in.nextInt(), in.nextInt()};
        int[] t = new int[]{in.nextInt(), in.nextInt()};
        int step = s[0]<t[0] ? 1 : -1;
        int cnt = 0;
        while(s[0]!=t[0]){
            cnt++;
            s[0]=s[0]+step;
            s[1]=Math.min(s[1], line[s[0]]+1);
        }
        out.println(cnt);
        out.println(Math.abs(t[1]-s[1]) + cnt);
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
        Cf253C_1 task = new Cf253C_1(); task.run(); task.close();}
}
