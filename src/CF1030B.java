import java.io.*;
import java.util.*;

/**
 * Problem CF1030B
 */
public class CF1030B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int d = in.nextInt();
            int m = in.nextInt();
            for(int i = 0; i < m; ++i){
                int x = in.nextInt();
                int y = in.nextInt();
                if((d<=x+y&&x+y<=2*n-d) && (-d<=x-y&&x-y<=d)){
                    out.println("YES");
                } else {
                    out.println("NO");
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
