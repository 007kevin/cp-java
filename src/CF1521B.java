import java.io.*;
import java.util.*;

/**
 * Problem CF1521B
 */
public class CF1521B {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int[] a = new int[n];
                int min = Integer.MAX_VALUE;
                int mi = 0;
                for(int i = 0; i < n; ++i){
                    a[i]=in.nextInt();
                    if(a[i]<min){
                        min=a[i];
                        mi=i;
                    }
                }
                out.println(n-1);
                int v = a[mi];
                for(int i = mi-1; i >= 0; --i){
                    out.println(String.format("%s %s %s %s", i+1, mi+1, v++ + 1, a[mi]));
                }
                v=a[mi];
                for(int i = mi+1; i < n; ++i){
                    out.println(String.format("%s %s %s %s", mi+1, i+1, a[mi], v++ +1));
                }
            }
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(String[] args) {
        Task task = new Task();
        task.run();
        task.cleanup();
    }
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }
        private boolean prime() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            }
            return true;
        }
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokenizer.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
}
