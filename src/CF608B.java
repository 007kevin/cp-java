import java.io.*;
import java.util.*;

/**
 * Problem CF608B
 */
public class CF608B {

    static class Task extends IOHandler {
        public void run() {
            int[] a = in.next().chars().map(c -> c-'0').toArray();
            int[] b = in.next().chars().map(c -> c-'0').toArray();
            int[][] p = new int[b.length+1][2];
            for(int i = 0; i < b.length; ++i){
                p[i+1][0]=p[i][0]+((b[i]+1)%2);
                p[i+1][1]=p[i][1]+b[i];
            }
            long ans = 0;
            for(int j = 0; j < a.length; ++j){
                int c = (a[j]+1)%2;
                ans+=p[b.length - a.length + j + 1][c]-p[j][c];
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
