import java.io.*;
import java.util.*;

/**
 * Problem CfContest1547D
 */
public class CfContest1547D {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] x = new int[n];
            for(int i = 0; i < n; ++i) x[i]=in.nextInt();
            out.print(0 + " ");
            for(int i = 1; i < n; ++i){
                int y = find(x,i);
                out.print(y + " ");
                x[i]|=y;
            }
            out.println();
        }
    }

    public int find(int[] x, int i){
        int n = 0;
        for(int j = 0; j < 32; ++j){
            boolean setb = (x[i]&(1<<j))!=0;
            boolean seta = (x[i-1]&(1<<j))!=0;
            if(setb&&seta) continue;
            if(setb) continue;
            if(seta){
                n|=(1<<j);
            }
        }
        return n;
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
        CfContest1547D task = new CfContest1547D(); task.run(); task.close();}
}
