import java.io.*;
import java.util.*;

/**
 * Problem Cf296C
 */
public class Cf296C {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            long[] a = new long[n+2];
            long[] d= new long[n+2];
            Query[] q = new Query[m+2];
            long[] qd = new long[m+2];
            for(int i = 1; i <= n; ++i){
                a[i]=in.nextInt();
            }
            for(int i = 1; i <= m; ++i){
                q[i]=new Query(
                        in.nextInt(),
                        in.nextInt(),
                        in.nextInt());
            }
            for(int i = 0; i < k; ++i){
                int x = in.nextInt();
                int y = in.nextInt();
                qd[x]++;
                qd[y+1]--;
            }
            for(int i = 1; i <= m; ++i) qd[i]+=qd[i-1];
            for(int i = 1; i <= m; ++i){
                d[q[i].l]+=qd[i]*q[i].d;
                d[q[i].r+1]-=qd[i]*q[i].d;
            }
            for(int i = 1; i <= n; ++i) d[i]+=d[i-1];
            for(int i = 1; i <= n; ++i) a[i]+=d[i];
            for(int i = 1; i <= n; ++i){
                out.print(a[i] + " ");
            }
            out.println();
        }
    }

    static class Query {
        int l,r;
        long d;
        Query(int l, int r, long d){this.l=l;this.r=r;this.d=d;}
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public static void main(String[] args) {
        Task task = new Task(); task.run(); task.close();}
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void close() {out.close();}}
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
}
