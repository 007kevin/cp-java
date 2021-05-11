import java.io.*;
import java.util.*;

/**
 * Problem CF525B
 */
public class CF525B {

    static class Task extends IOHandler {
        public void run() {
            String s = in.next();
            char[] c = new char[s.length()+1];
            for(int i = 0; i < s.length(); ++i) c[i+1]=s.charAt(i);
            int m = in.nextInt();
            int[] a = new int[c.length];
            for(int i = 0; i < m; ++i){
                a[in.nextInt()]++;
            }
            int moves = 0;
            for(int i = 1; i < c.length/2+1; ++i){
                moves+=a[i];
                if(moves%2==1){
                    char swap = c[i];
                    c[i] = c[s.length() - i + 1];
                    c[s.length() - i + 1] = swap;
                }
            }
            out.println(new String(c, 1, c.length-1));
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
