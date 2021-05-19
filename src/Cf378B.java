import java.io.*;
import java.util.*;

/**
 * Problem Cf378B
 */
public class Cf378B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            int[] ap = new int[n];
            int[] bp = new int[n];
            for(int i = 0; i < n; ++i){
                a[i]=in.nextLong();
                b[i]=in.nextLong();
            }
            int ai=0,bi=0;
            while(ai+bi<n){
                if(a[ai]<b[bi]) ap[ai++]=1;
                else bp[bi++]=1;
            }
            for(int i = 0; i < n/2; ++i) ap[i]=bp[i]=1;
            out.println(toString(ap));
            out.println(toString(bp));
        }

        public String toString(int[] a){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < a.length; ++i)
                sb.append(String.valueOf(a[i]));
            return sb.toString();
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
