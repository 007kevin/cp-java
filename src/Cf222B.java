import java.io.*;
import java.util.*;

/**
 * Problem Cf222B
 */
public class Cf222B {

    public void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] t = new int[n+1][m+1];
        int[] row = new int[n+1];
        int[] col = new int[m+1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j){
                t[i][j]=in.nextInt();
            }
        }
        for(int i = 1; i <= n; ++i) row[i]=i;
        for(int i = 1; i <= m; ++i) col[i]=i;
        while(k-->0){
            String s = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            if(s.equals("c")){
                int tmp = col[x];
                col[x]=col[y];
                col[y]=tmp;
            } else if (s.equals("r")){
                int tmp = row[x];
                row[x]=row[y];
                row[y]=tmp;
            } else {
                out.println(t[row[x]][col[y]]);
            }
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
        Cf222B task = new Cf222B(); task.run(); task.close();}
}
