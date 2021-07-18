import java.io.*;
import java.util.*;

/**
 * Problem CfContest1547E
 */
public class CfContest1547E {

    public void run() {
        int q = in.nextInt();
        while(q-->0){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[k];
            int[] t = new int[k];
            int[] L = new int[n+2]; L[0] = Integer.MAX_VALUE/2;
            int[] R = new int[n+2]; R[n+1] = Integer.MAX_VALUE/2;
            for(int i = 0; i < k; ++i) a[i]=in.nextInt();
            for(int i = 0; i < k; ++i) t[i]=in.nextInt();
            for(int i = 0; i < k; ++i){
                L[a[i]]=t[i];
                R[a[i]]=t[i];
            }
            for(int i = 1; i <= n; ++i){
                L[i] = Math.min(L[i], 1+L[i-1]);
            }
            for(int i = n; i >= 1; --i){
                R[i] = Math.min(R[i], 1+R[i+1]);
            }
            for(int i = 1; i <= n; ++i){
                out.print(Math.min(L[i],R[i]) + " ");
            }
            out.println();
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
        CfContest1547E task = new CfContest1547E(); task.run(); task.close();}
}
