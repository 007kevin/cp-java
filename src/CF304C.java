import java.io.*;
import java.util.*;

/**
 * Problem CF304C
 */
public class CF304C {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            if(n==1) out.println("0\n0\n0");
            else if(n%2==0) out.println(-1);
            else {
                for(int i = 0; i < n; ++i) out.print(i + " ");
                out.println();
                int cur = n-1;
                for(int i = 0; i < n; ++i){
                    out.print(cur + " ");
                    cur=mod(cur-2,n);
                }
                out.println();
                for(int i = n-1; i >= 0; --i) out.print(i + " ");
                out.println();
            }
        }

        public int mod(int v, int n){
            if(v>=0) return v;
            return n+v;
        }
                
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
