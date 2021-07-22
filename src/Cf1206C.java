import java.io.*;
import java.util.*;

/**
 * Problem Cf1206C
 */
public class Cf1206C {

    public void run() {
        int n = in.nextInt();
        if(n%2==0) out.println("NO");
        else {
            out.println("YES");
            int[] a = new int[2*n];
            int c = 0;
            int v = 1;
            for(int i = 0; i < n; ++i){
                a[c]=v++;
                c=(c+n)%(2*n);
                a[c]=v++;
                c=(c+1)%(2*n);
            }
            for(int num : a)
                out.print(num + " ");
            // for(int i = 0; i < 2*n; ++i){
            //     int sum = 0;
            //     for(int j = 0; j < n; ++j){
            //         sum+=a[(i+j)%(2*n)];
            //     }
            //     out.println(sum);
            // }
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
        Cf1206C task = new Cf1206C(); task.run(); task.close();}
}
