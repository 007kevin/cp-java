import java.io.*;
import java.util.*;

/**
 * Problem CF602B
 */
public class CF602B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; ++i) {
                a[i]=in.nextInt();
            }
            
            int ans=0, j =0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; ++i){
                map.compute(a[i], (k,v) -> v == null ? 1 : v+1);
                while(map.size() > 2){
                    map.compute(a[j++], (k,v) -> v == 1 ? null : v-1);
                }
                ans=Math.max(ans, i-j+1);
            }
            out.println(ans);
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
