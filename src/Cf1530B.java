import java.io.*;
import java.util.*;

/**
 * Problem Cf1530B
 */
public class Cf1530B {

    int[][] moves = new int[][] {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0},
        {-1,-1},
        {1,1},
        {-1,1},
        {1,-1}
    };

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int h = in.nextInt();
            int w = in.nextInt();
            int[][] tab = new int[h][w];
            tab[0][0]=1;
            for(int i = 0; i < h; ++i){
                for(int j = 0; j < w; ++j){
                    if(valid(tab,i,j))
                        tab[i][j]=1;
                }
            }
            for(int i = 0; i < h; ++i){
                for(int j = 0; j < w; ++j){
                    out.print(tab[i][j]);
                }
                out.println();
            }
            out.println();
        }
    }

    boolean valid(int[][] tab, int a, int b){
        int h = tab.length;
        int w = tab[0].length;
        if(tab[a][b]==1) return false;
        if(!(a==0||b==0||a==h-1||b==w-1)) return false;
        for(int[] m : moves){
            int i = a+m[0];
            int j = b+m[1];
            if(i<0||j<0||i>=h||j==w) continue;
            if(tab[i][j]==1) return false;
        }
        return true;
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
        Cf1530B task = new Cf1530B(); task.run(); task.close();}
}
