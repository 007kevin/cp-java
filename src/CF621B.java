import java.io.*;
import java.util.*;

/**
 * Problem CF621B
 */
public class CF621B {

    static class Task extends IOHandler {
        private static int MAXN = 1000;
        
        public void run() {
            int[][] grid = new int[1001][1001];
            int n = in.nextInt();
            for(int i = 0; i < n; ++i){
                grid[in.nextInt()][in.nextInt()]=1;
            }
            long ans = 0;
            for(int i = 1; i <= MAXN; ++i){
                int x = i;
                int y = 1;
                int b = 0;
                while(x>0 && y <= MAXN) {
                    b+=grid[x--][y++];
                }
                ans+=b*(b-1)/2;
            }
            for(int i = 2; i <= MAXN; ++i){
                int x = MAXN;
                int y = i;
                int b = 0;
                while(x>0 && y <= MAXN) {
                    b+=grid[x--][y++];
                }
                ans+=b*(b-1)/2;
            }
            for(int i = 1; i <= MAXN; ++i){
                int x = MAXN;
                int y = i;
                int b = 0;
                while(x>0&&y>0) {
                    b+=grid[x--][y--];
                }
                ans+=b*(b-1)/2;
            }
            for(int i = MAXN-1; i >= 1; --i){
                int x = i;
                int y = MAXN;
                int b = 0;
                while(x>0&&y>0) {
                    b+=grid[x--][y--];
                }
                ans+=b*(b-1)/2;
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
