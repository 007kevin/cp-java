import java.io.*;
import java.util.*;

/**
 * Problem CF544B
 */
public class CF544B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int k = in.nextInt();
            if((n*n)/2+(n*n)%2 < k) out.println("NO");
            else {
                out.println("YES");
                char[][] map = generate(n,k);
                for(int i = 0; i < n; ++i){
                    out.println(map[i]);
                }
            }
        }

        private char[][] generate(int n, int k) {
            char[][] map = new char[n][n];
            
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    map[i][j]='S';
                }
            }

            for(int i = 0; i < n; ++i){
                for(int j = 0+i%2; j < n; j+=2){
                    if(k>0){
                        map[i][j]='L';
                        k--;
                    }
                }
            }

            return map;
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
