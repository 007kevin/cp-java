import java.io.*;
import java.util.*;

/**
 * Problem CF1237B
 */
public class CF1237B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int[] enter = new int[n+1];
            boolean[] seen = new boolean[n+1];
            for(int i = 1; i <= n; ++i) enter[in.nextInt()]=i;
            int lowest=1, ans=0;
            for(int i = 1; i <= n; ++i){
                while(seen[lowest]) lowest++;
                int m = in.nextInt();
                if(enter[m] > lowest) ans++;
                seen[enter[m]]=true;
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
