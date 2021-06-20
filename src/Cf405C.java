import java.io.*;
import java.util.*;

/**
 * Problem Cf405C
 */
public class Cf405C {

    public void run() {
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                matrix[i][j]=in.nextInt();
            }
        }
        int p = 0;
        for(int i = 0; i < n; ++i){
            p=(p+matrix[i][i])%2;
        }
        int q = in.nextInt();
        while(q-->0){
            int t = in.nextInt();
            if(t==1||t==2) {
                p=(p+1)%2;
                in.nextInt();
            }
            else {
                out.print(p);
            }
        }
        out.println();
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
        Cf405C task = new Cf405C(); task.run(); task.close();}
}
